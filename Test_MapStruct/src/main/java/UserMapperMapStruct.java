import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

// MapStruct를 이용한 Mapping interface 
// -> 라이브러리가 직접 구현해줌

// 매핑을 해주는 인터페이스
@Mapper
public interface UserMapperMapStruct {

    UserMapperMapStruct userMapperMapStruct = Mappers.getMapper(UserMapperMapStruct.class);

    // MapStruct 구조를 처음 봤을때
    // User 객체의 Team객체의 name필드의 인스턴스를 가져와서
    // UserResponseDto의 teamName필드에 넣는다? -> 내 예상과 동일
    
    // 실제 결과
    // 원본 객체의 field = User{ id, name, age, Team(Team객체)}
    // DTO 객체의 field = DTO{name, age, TeamName(String)}

    // 매핑 규칙 | 해당 규칙으로 매핑해준다.
    // 원본객체의 Team.getName() -> DTO객체의 String으로 바로 매핑해줌
    @Mapping(source = "team.name", target = "teamName")
    UserResponseDto toDto(User user);

    //요소 타입(파마미터와 리턴타입)에 맞는 매핑매서드를 찾아서 리스트 매핑 시 내부적으로 로직 자동 수행
    List<UserResponseDto> toDtoList(List<User> users);
    //리스트 매핑은 내부적으로 기존 단일 매핑 함수를 재사용함.
}