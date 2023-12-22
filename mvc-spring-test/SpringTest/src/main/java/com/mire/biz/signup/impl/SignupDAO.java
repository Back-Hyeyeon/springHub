package com.mire.biz.signup.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.mire.biz.common.JDBCUtil;
import com.mire.biz.signup.SignupVO;

@Repository("signupDAO")
public class SignupDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public final String SIGNUP_INSERT = "insert into signup(newid, nickname, username, sign_passwd, email, phonenum, bankname, bankaccount) "
			+ "values(?, ?, ?,?, ?, ?,?, ?);";
	
	public final String SIGNUP_UPDATE = "update signup set nickname=?, username=?, sign_passwd=?, email=?, phonenum=? where newid=?";
	public final String SIGNUP_DELETE = "delete from signup where newid=? ";
	public final String SIGNUP_GETLOG = "SELECT * FROM  SIGNUP WHERE NEWID=? AND SIGN_PASSWD=?";
	private final String SIGNUP_GET = "select * from signup where newid=?";
	
	
	//회원가입
	public void insertSignuup(SignupVO vo) {
		System.out.println("JDBC insert");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SIGNUP_INSERT);
			stmt.setString(1, vo.getNewid());
			stmt.setString(2, vo.getNickname());
			stmt.setString(3, vo.getUsername());
			stmt.setString(4, vo.getSign_passwd());
			stmt.setString(5, vo.getEmail());
			stmt.setString(6, vo.getPhonenum());
			stmt.setString(7, vo.getBankname());
			stmt.setString(8, vo.getBankaccount());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//회원정보 수정
	public void updateSignuup(SignupVO vo) {
		System.out.println("JDBC update");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SIGNUP_UPDATE);
			stmt.setString(1, vo.getNickname());
			stmt.setString(2, vo.getUsername());
			stmt.setString(3, vo.getSign_passwd());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getPhonenum());
			stmt.setString(6, vo.getNewid());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//회원삭제
	public void deleteSignuup(SignupVO vo) {
		System.out.println("JDBC delete");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SIGNUP_DELETE);
			stmt.setString(1, vo.getNewid());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//로그인
	public SignupVO getLogSignuup(SignupVO vo) {
		System.out.println("JDBC getLogSignuup");
		SignupVO user = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement("Select * from signup");
//			stmt.setString(1, vo.getNewid());
//			stmt.setString(2, vo.getSign_passwd());
			rs = stmt.executeQuery();
			System.out.println("rs : ");
			if(rs.next() == true) {
				user = new SignupVO();
				System.out.println("rs : "+rs.getString("NEWID"));
				user.setNewid(rs.getString("NEWID"));
				user.setNickname(rs.getString("NICKNAME"));
				user.setUsername(rs.getString("USERNAME"));
				user.setSign_passwd(rs.getString("SIGN_PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPhonenum(rs.getString("PHONENUM"));
				user.setBankname(rs.getString("BANKNAME"));
				user.setBankaccount(rs.getString("BANKACCOUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	//회원정보 상세보기
	public SignupVO getSignuup(SignupVO vo) {
		System.out.println("JDBC getSignuup");
		SignupVO signupVO = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SIGNUP_GET);
			stmt.setString(1, vo.getNewid());
			rs = stmt.executeQuery();
			if (rs.next()) {
				signupVO = new SignupVO();
				signupVO.setNewid(rs.getString("NEWID"));
				signupVO.setNickname(rs.getString("NICKNAME"));
				signupVO.setUsername(rs.getString("USERNAME"));
				signupVO.setSign_passwd(rs.getString("SIGN_PASSWD"));
				signupVO.setEmail(rs.getString("EMAIL"));
				signupVO.setPhonenum(rs.getString("PHONENUM"));
				signupVO.setBankname(rs.getString("BANKNAME"));
				signupVO.setBankaccount(rs.getString("BANKACCOUNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return signupVO;
	}
	
}
