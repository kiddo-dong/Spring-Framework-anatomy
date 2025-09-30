package com.example.Account_Transaction.repository;

import com.example.Account_Transaction.domain.Account;
import com.example.Account_Transaction.rowMapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImp implements AccountRepository{

    private final JdbcTemplate jdbcTemplate;

    public AccountRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 계좌 생성
    @Override
    public void addAccount(Account account){
        String sql = "INSERT INTO account(name, amount) VALUES(?, ?)";
        jdbcTemplate.update(sql, account.getName(), account.getAmount());
    }

    // 계좌 삭제(잔액 존재 시 rollback)
    @Override
    public void deleteAccountById(Long id) {
        String sql = "DELETE FROM account WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // 계좌 조회
    @Override
    public Account findAccountById(Long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
         return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    // 전체 계좌 조회
    @Override
    public List<Account> findAllAccount() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

    // 송금 -> 입금 트랜잭션
    @Override
    public void UpdateTransferAmount(BigDecimal amount, Long id) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, id);
    }
}
