import org.mapstruct.factory.Mappers;

import java.util.List;

public class Main {

    // DTO 매핑 기술

    // 1. 직접 매핑
    // 2. mapstruct

    // 두가지 매핑 기술의 메모리(JVM) 성능 분석
    
    public static void main(String[] args) {
        // 팀 생성
        Team teamA = new Team(1L, "TeamA");

        // 사용자 생성
        User user1 = new User(1L, "Alice", 25);
        User user2 = new User(2L, "Bob", 30);

        // 팀에 사용자 추가 (연관관계 설정)
        teamA.addUser(user1);
        teamA.addUser(user2);

        // ===== 순수 자바 매핑 =====
        List<UserResponseDto> dtoListJava = UserMapperJava.toDtoList(teamA.getUsers());
        System.out.println("순수 자바 매핑:");
        dtoListJava.forEach(System.out::println);

        // ===== MapStruct 매핑 =====
        // MapStruct는 별도 라이브러리 필요, 컴파일 시 자동 생성
        List<UserResponseDto> dtoListMapStruct = UserMapperMapStruct.userMapperMapStruct.toDtoList(teamA.getUsers());


        System.out.println("MapStruct 매핑:");
        dtoListMapStruct.forEach(System.out::println);
    }
}