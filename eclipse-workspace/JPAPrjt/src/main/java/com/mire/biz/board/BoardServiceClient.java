package com.mire.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import oracle.jdbc.rowset.OracleWebRowSetXmlReader;

public class BoardServiceClient {

	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPrjt");
		EntityManager em = emf.createEntityManager();
		
		// transaction 생성 트랜젝션 필수
		EntityTransaction etx = em.getTransaction();

		try {

			

			// CURD 작업
			etx.begin();// 시작하겠다 begin

			Board board = new Board();
			board.setTitle("JPA Test");
			board.setWriter("김동진");
			board.setContent("소리소문 없이 사라지는");

			// 글 등록(insert)
			em.persist(board);// 인서트 저장기능 persist

			// 글 목록 조회 테이블 명이 아니라 클래스명을 넣는 것으로 생각하고 적어라.
			String jpasql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpasql, Board.class).getResultList();

			// 콘솔창출력
			for (Board data : boardList) {
				System.out.println("==============" + data.toString());
			}

			etx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			etx.rollback();

		} finally {
			em.close();
		}
		emf.close();

	}

}
