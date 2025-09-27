package com.example.MemberCRUD_JdbcTemplate.Member.repository;

import com.example.MemberCRUD_JdbcTemplate.Member.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImp implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;

    public MemberRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addMember(Member member) {
        String sql = "INSERT INTO members(name, email, age) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getName(),
                member.getEmail(),
                member.getAge());
    }

    @Override
    public Optional<Member> findMemberById(int id) {
        String sql = "SELECT * FROM members WHERE id = ?";

        RowMapper<Member> rowMapper = (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getInt("id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setAge(rs.getInt("age"));
            return  member;
        };

        Member member = jdbcTemplate.queryForObject(
                sql,
                rowMapper,
                id
        );

        return Optional.ofNullable(member);
    }

    @Override
    public void updateMemberById(int id, Member member) {
        String sql = "UPDATE members SET name = ?, email = ?, age = ? WHERE id = ?";

        jdbcTemplate.update(
                sql,
                member.getName(),
                member.getEmail(),
                member.getAge(),
                id
        );
    }

    @Override
    public void deleteMemberById(int id) {
        String sql = "DELETE FROM members WHERE id = ?";

        jdbcTemplate.update(
                sql,
                id
                );
    }

    @Override
    public List<Member> findUsers(){
        String sql = "SELECT * FROM members";
        RowMapper<Member> rowMapper = (rs, rowNum) -> {
            Member member = new Member();
            member.setAge(rs.getInt("id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setAge(rs.getInt("age"));

            return member;
        };

        List<Member> memberList = jdbcTemplate.query(sql, rowMapper);
        return  memberList;
    }
}
