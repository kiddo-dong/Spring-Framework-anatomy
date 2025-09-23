package com.example.UserCRUD_DataSource.repository;

import com.example.UserCRUD_DataSource.domain.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class UserRepositoryImp implements UserRepository{

    private Logger logger = Logger.getLogger(UserRepositoryImp.class.getName());

    private final DataSource dataSource;

    public UserRepositoryImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Creat
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users(id, name, email) VALUES(?, ?, ?)";
        
        // DataSource 사용으로 HikariCP에 DB 정보 자동 할당 및 드라이버<->DB 자동 연결
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e){
            logger.severe("DB Error : " + e.getErrorCode());
        }
    }

    // Read
    @Override
    public Optional<User> findUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    return Optional.of(user);
                }
            }
        } catch (SQLException e){
            logger.severe("DB Error : " + e.getErrorCode());
        }
        return Optional.empty();
    }

    // Update
    @Override
    public void updateUserById(int id, User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e){
            logger.severe("DB Error : " + e.getErrorCode());
        }
    }

    // Delete
    @Override
    public void deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException e) {
            logger.severe("DB Error : " + e.getErrorCode());
        }
    }
}

/* DataSource Interface 사용시 문제점
    1. DB와 연결은 간단해졌지만 여전히 DB에 보낼 파라미터나 리턴받을 데이터를 직접 코드 짜야함
    2. 쿼리문 거슬림.
*/