package com.example.UsersCRUD_JdbcTemplate.repository;

import com.example.UsersCRUD_JdbcTemplate.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //C
    public void addUser(User user){
        String sql = "INSERT INTO users(name, email) VALUES(?, ?)";

        jdbcTemplate.update(
                sql,
                user.getName(),
                user.getEmail()
        );
    }

    //R
    public Optional<User> findUserById(int id){
        String sql = "SELECT * FROM users WHERE id = ?";

        RowMapper<User> rowMapper = (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        };

        User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(user);
    }

    //U
    public void updateUserById(int id, User user){
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        jdbcTemplate.update(
                sql,
                user.getName(),
                user.getEmail(),
                id
        );
    }

    //D
    public void deleteUserById(int id){
        String sql = "DELETE FROM users WHERE id = ?";

        jdbcTemplate.update(
                sql,
                id
        );
    }
}
