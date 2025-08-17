package service;

public interface UserService {
    Boolean login(String username);
    void getProfile(String username);
}
