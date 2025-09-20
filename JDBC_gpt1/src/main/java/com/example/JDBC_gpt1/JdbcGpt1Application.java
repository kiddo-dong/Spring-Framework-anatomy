package com.example.JDBC_gpt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.SortedMap;

@SpringBootApplication
public class JdbcGpt1Application {

	public static void main(String[] args) {
		SpringApplication.run(JdbcGpt1Application.class, args);

		String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
		String user = "root";
		String password = "password";

		// DriverManager 객체에서 DB에 맞는 Driver 호출
		// Driver 내부에서 TCP/IP Connection & User/pass 검증
		// 연결 시 return
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			// 테이블 생성
			try(Statement st = conn.createStatement()){
				st.execute("CREATE TABLE users (" +
						"id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
						"username VARCHAR(50), email VARCHAR(100))");
			}

			// INSERT 문
			String insertSql = "INSERT INTO users(username, email) VALUES (?, ?)";
			try(PreparedStatement ps = conn.prepareStatement(insertSql)){
				ps.setString(1, "Kiddo-dong");
				ps.setString(2, "xxx@gmail.com");
				ps.executeUpdate();
			}

			// SELECT 문
			String selecctSql = "SELECT id, username, email FROM users";
			try(PreparedStatement ps = conn.prepareStatement(selecctSql);
				ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					User users = new User();
					System.out.println("User : " + rs.getInt("id") + rs.getString("name" + rs.getString("email")));

					rs.close();
					ps.close();
					conn.close();
				}
			}

		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
