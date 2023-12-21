package com.mire.biz.admin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mire.biz.admin.AdminVO;
import com.mire.biz.common.JDBCUtil;

public class AdminDAO {

	
	private Connection coon = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String ADMIN_GET = "SELECT * FROM admin WHERE ID=? AND PASSWORD=?";
	private final String ADMIN_INSERT = "insert into admin(ID, PASSWORD, NAME, ROLE ) "
			+ "values (?, ?, ?, ?)";

	public AdminVO getAdmin(AdminVO vo) {
		AdminVO admin = null;
		try {
			System.out.println("getAdmin");
			coon = JDBCUtil.getConnection();
			stmt = coon.prepareStatement(ADMIN_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();

			if (rs.next() == true) {
				admin = new AdminVO();
				admin.setId(rs.getString("ID"));
				admin.setPassword(rs.getString("PASSWORD"));
				admin.setName(rs.getString("NAME"));
				admin.setRole(rs.getString("ROLE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, coon);
		}
		return admin;

	}
	
	public void insertAdmin(AdminVO vo) {
		System.out.println("insertAdmin");
		try {
			coon = JDBCUtil.getConnection();
			stmt = coon.prepareStatement(ADMIN_INSERT);
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
