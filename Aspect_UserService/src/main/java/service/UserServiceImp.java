    package service;
    import annotation.AuthCheck;
    import annotation.LogExecution;
    import org.springframework.stereotype.Component;

    @Component("user")
    public class UserServiceImp implements UserService{
        private final String username_repo = "dh6559";

        @Override
        @AuthCheck
        public Boolean login(String username){
            if(username_repo.equals(username)){
                System.out.println("로그인 성공 : " + username);
                return true;
            } else {
                System.out.println(username + "은 존재하지 않습니다.");
                return false;
            }
        }

        @Override
        @LogExecution
        public void getProfile(String username){
            System.out.println("프로필 조회 : " + username);
        }
    }
