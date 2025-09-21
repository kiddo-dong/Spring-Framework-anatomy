package com.example.JDBC_MySql_test1.repository;

import com.example.JDBC_MySql_test1.domain.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserRepositoryImp implements UserRepository{

    private final Logger logger = Logger.getLogger(UserRepositoryImp.class.getName());

    // MySql DB 정보
    private String url = "jdbc:mysql://localhost:3306/SpringStudy?serverTimezone=UTC&useSSL=false";
    private String username = "root";
    private String password = "password";

    @Override
    public List<User> findAllUser() {

        // User리스트 반환을 위한 객체
        // 메모리 관리를 위해 메서드 내부에서 만듦
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e){
            logger.severe("DB Error");
        }

        return users;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users(id, name, email) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e){
            logger.severe("DB Error");
        }
    }
}
