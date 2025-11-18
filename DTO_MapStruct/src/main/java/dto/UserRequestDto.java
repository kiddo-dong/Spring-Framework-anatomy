package dto;

public class UserRequestDto {
    private String name;
    private int age;
    private String TeamName;

    public UserRequestDto(String name, int age, String teamName) {
        this.name = name;
        this.age = age;
        TeamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }
}
