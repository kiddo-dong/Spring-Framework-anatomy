package com.example.ch13_ex1.repository;

import com.example.ch13_ex1.domain.Account;
import com.example.ch13_ex1.rowMapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTamplate;

    public AccountRepository(JdbcTemplate jdbcTamplate) {
        this.jdbcTamplate = jdbcTamplate;
    }

    // 고객 id로 계좌 찾기
    public Account findAccountById(long id){
        // rowMapper class 로 모듈화
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbcTamplate.queryForObject(sql,new AccountRowMapper(), id);
    }

    // 잔액 연산 후 업데이트 할 고객 id로 잔액 변경
    public void changeAmount(long id, BigDecimal amount){
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTamplate.update(sql,amount,id);
    }

    // 모든 고객 찾기
    public List<Account> findAllAccounts(){
        String sql = "SELECT * FROM account";
        return jdbcTamplate.query(sql,new AccountRowMapper());
    }

}
