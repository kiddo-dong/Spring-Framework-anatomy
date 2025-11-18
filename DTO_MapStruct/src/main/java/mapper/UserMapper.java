package mapper;

import dto.UserRequestDto;
import dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import user.User;

// Mapper Class 명시
// 해당 Interface를 읽어 MapStruct 매핑 구현체 자동생성
@Mapper
public interface UserMapper {
    // RequestDto To Entity

    User toEntity(UserRequestDto userRequestDto);

    // Entity To ResposeDto
    @Mapping(source = "team.name",target = "teamName")
    UserResponseDto toUserResponseDto(User user);
}