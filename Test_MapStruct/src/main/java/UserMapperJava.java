import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Mapping을 직접 해주는 Class
public class UserMapperJava {

    // Object to DTO
    public static UserResponseDto toDto(User user){
        if(user == null ){
            return null;
        }

        // DTO 매핑을 위해서 새 DTO 객체 생성
        // 해당 객체로 Return 해줘야함
        UserResponseDto userResponseDto = new UserResponseDto();

        // 객체 -> DTO Mapping
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setTeamName(user.getTeam().getName()); // User 객체의 Team.name

        return userResponseDto;
    }

    // List<Object> to List<DTO>
    public static List<UserResponseDto> toDtoList(List<User> users){

        if(users == null){
            return Collections.emptyList();
        }

        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        // List<객체> -> List<DTO> Mapping
        for(User u : users){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setName(u.getName());
            userResponseDto.setAge(u.getAge());
            userResponseDto.setTeamName(u.getTeam().getName());

            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }
}