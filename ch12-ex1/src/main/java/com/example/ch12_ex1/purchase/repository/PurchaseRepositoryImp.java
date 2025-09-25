package com.example.ch12_ex1.purchase.repository;

import com.example.ch12_ex1.purchase.domain.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImp implements PurchaseRepository{
    
    // 빈 자동 등록
    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // POST -> INSERT
    @Override
    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase(product, price) VALUES(?, ?)";

        // INSERT
        // 즉 ResultSet return 이 없어 JdbcTemplate의 update()메소드에 쿼리 및 파라미터 바인딩
        jdbcTemplate.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    // GET -> SELECT
    // JdbcTemplate 로직에서
    // RowMapper 단일 인터페이스정의로 인해 RowMapper의 구현체 필요
    // RowMapper는 단일 인터페이스 이므로 단일 인터페이스 구현체인 람다 사용 가능
    @Override
    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> rowMapper = (rs, rowNum) -> {
            Purchase pc = new Purchase();
            pc.setId(rs.getInt("id"));
            pc.setProduct(rs.getString("product"));
            pc.setPrice(rs.getBigDecimal("price"));
            return pc;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

}
