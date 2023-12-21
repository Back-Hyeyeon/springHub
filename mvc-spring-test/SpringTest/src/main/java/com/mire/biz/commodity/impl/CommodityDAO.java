package com.mire.biz.commodity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mire.biz.commodity.CommodityVO;
import com.mire.biz.common.JDBCUtil;

@Repository("commodityDAO")
public class CommodityDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	private final String COMMODITY_INSERT = "insert into commodity(seq, item, prices, topics, subtopics, quantity) "
			+ "values ((select nvl(max(seq), 0)+1 from commodity), ?, ?, ?,? ,?)";
	private final String COMMODITY_UPDATE = "update commodity set item=?, prices=?, topics=?, subtopics=?, quantity=? where seq=?";
	private final String COMMODITY_DELETE = "delete from commodity where seq=?";
	private final String COMMODITY_GET = "select * from commodity where seq=?";
	private final String COMMODITY_LIST_SEARCH = "select * from commodity where topics like '%'||?||'%' order by seq desc";
	
	// 상품 등록
		public void insertCommodity(CommodityVO vo) {
			System.out.println("===> JDBC로 insertCommodity() 기능 처리");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(COMMODITY_INSERT);
				stmt.setString(1, vo.getItem());
				stmt.setString(2, vo.getPrices());
				stmt.setString(3, vo.getTopics());
				stmt.setString(4, vo.getSubtopics());
				stmt.setString(5, vo.getQuantity());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}

		//상품 수정
		public void updateCommodity(CommodityVO vo) {
			System.out.println("===> JDBC로 updateBoard() 기능 처리");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(COMMODITY_UPDATE);
				stmt.setString(1, vo.getItem());
				stmt.setString(2, vo.getPrices());
				stmt.setString(3, vo.getTopics());
				stmt.setString(4, vo.getSubtopics());
				stmt.setString(5, vo.getQuantity());
				stmt.setInt(6, vo.getSeq());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}

		// 상품 삭제
		public void deleteCommodity(CommodityVO vo) {
			System.out.println("===> JDBC로 deleteBoard() 기능 처리");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(COMMODITY_DELETE);
				stmt.setInt(1, vo.getSeq());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}

		//상품 상세 조회
		public CommodityVO getCommodity(CommodityVO vo) {
			System.out.println("===> JDBC로 getBoard() 기능 처리");
			CommodityVO comm = null;
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(COMMODITY_GET);
				stmt.setInt(1, vo.getSeq());
				
				rs = stmt.executeQuery();
				if (rs.next()) {
					comm = new CommodityVO();
					comm.setSeq(rs.getInt("SEQ"));
					comm.setItem(rs.getString("ITEM"));
					comm.setPrices(rs.getString("PRICES"));
					comm.setTopics(rs.getString("TOPICS"));
					comm.setSubtopics(rs.getString("SUBTOPICS"));
					comm.setQuantity(rs.getString("QUANTITY"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return comm;
		}

		// 상품 목록 조회
		public List<CommodityVO> getCommodityList(CommodityVO vo) {
			System.out.println("===> JDBC로 getBoardList() 기능 처리");
			List<CommodityVO> commodityList = new ArrayList<>();
			try {
				conn = JDBCUtil.getConnection();
				if(vo.getSearch().equals("TOPICS")) {
					stmt = conn.prepareStatement(COMMODITY_LIST_SEARCH);
				}
//				stmt = conn.prepareStatement(BOARD_LIST);
				stmt.setString(1, vo.getSearch());
				rs = stmt.executeQuery();
				while (rs.next()) {
					CommodityVO comm = new CommodityVO();
					comm = new CommodityVO();
					comm.setSeq(rs.getInt("SEQ"));
					comm.setItem(rs.getString("ITEM"));
					comm.setPrices(rs.getString("PRICES"));
					comm.setTopics(rs.getString("TOPICS"));
					comm.setSubtopics(rs.getString("SUBTOPICS"));
					comm.setQuantity(rs.getString("QUANTITY"));
					commodityList.add(comm);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return commodityList;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
