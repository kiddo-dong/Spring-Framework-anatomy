package com.example.ch12_ex1.repository;

import com.example.ch12_ex1.domain.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    // JDBCTemplate AutoWired
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // INSERT DATA | HTTTP POST
    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
        // request Object
        // DB에 쿼리 날리기
        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    // GET DATA | HTTP GET
    public List<Purchase> purchasesRowMapper(){
        return List.of();
    }
}