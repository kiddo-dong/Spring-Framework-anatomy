import dto.UserRequestDto;
import dto.UserResponseDto;
import mapper.UserMapper;
import team.Team;
import user.User;

import java.util.ArrayList;
import java.util.List;

// MapStruct Testing
public class Main {
    public static void main(String[] args) {

        //Mapper
        UserMapper userMapper = new UserMapperImpl();

        // Team 생성
        Team teamA = new Team(1L,"Team A");

        // UserRequestDto 생성
        // Controller Layer
        UserRequestDto userRequestDto1 = new UserRequestDto("유저1",23,"Team A");
        UserRequestDto userRequestDto2 = new UserRequestDto("유저2", 24, "Team B");

        if(userRequestDto1.getTeamName().equals(teamA)){
            //userMapper.toEntity(userRequestDto1);
        } else {
            System.out.println("400 응답주기");
        }

        // 연관관계 Mapping Testing
        System.out.println("======================================\n");

        // MapStruct를 사용해서 Mapping
        // RequestDto -> Entity


        // Entity -> ResponseDto
    }
}