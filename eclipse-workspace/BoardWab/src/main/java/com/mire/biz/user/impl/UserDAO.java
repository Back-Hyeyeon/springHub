package com.mire.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.mire.biz.common.JDBCUtil;
import com.mire.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	private Connection coon = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
	private final String USER_INSERT = "insert into USERS(ID, PASSWORD, NAME, ROLE ) "
			+ "values (?, ?, ?, ?)";

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("==> JDBC는 getUser() 테스트");
			coon = JDBCUtil.getConnection();
			stmt = coon.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();

			if (rs.next() == true) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, coon);
		}
		return user;

	}
	
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC는 insert UserVO()");
		try {
			coon = JDBCUtil.getConnection();
			stmt = coon.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, coon);
		}
	}
}
