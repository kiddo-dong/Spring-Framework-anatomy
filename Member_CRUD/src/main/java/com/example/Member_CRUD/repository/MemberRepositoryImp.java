package com.example.Member_CRUD.repository;

import com.example.Member_CRUD.domain.Member;
import org.apache.catalina.User;

import java.sql.*;
import java.util.Optional;
import java.util.logging.Logger;

public class MemberRepositoryImp implements MemberRepository{

    private final Logger logger = Logger.getLogger(MemberRepositoryImp.class.getName());

    private String url = "jdbc:mysql://localhost:3033";
    private String user = "root";
    private String password = "password";

    @Override
    public void addMember(Member member) {
        String sql = "INSERT INTO members(id, name, age) VALUES(?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
          ps.setString(1, member.getId());
          ps.setString(2, member.getName());
          ps.setInt(3, member.getAge());
          ps.executeUpdate();
        }catch (SQLException e){
            logger.severe("DB Error" + e.getErrorCode());
        }
    }

    @Override
    public Optional<Member> findByUser(String id) {


        String sql = "SELECT * FROM members WHERE id = ? ";

        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ){
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Member member = new Member();

                member.setId(rs.getString("id"));
                member.setName(rs.getString("name"));
                member.setAge(rs.getInt("age"));
                return Optional.of(member);
            }

        } catch (SQLException e){
            logger.severe("DB Error" + e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void updateUserByid(String id, Member member) {
        String sql = "UPDATE members SET name = ?, age = ? WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, id);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.severe("DB Error" + e.getErrorCode());
        }
    }

    @Override
    public void deleteUserByid(String id) {
        String sql = "DELETE FROM members WHERE id = ? ";

        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.severe("DB Error" + e.getErrorCode());
        }
    }
}
