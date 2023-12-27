package com.mire.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mire.biz.board.BoardVO_back;

@Repository
public class BoardDAOMybaties {

	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 기능의 메소드 구현

	// 글 등록
	public void insertBoard(BoardVO_back vo) {
		System.out.println("===> mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	// 글 수정
	public void updateBoard(BoardVO_back vo) {
		System.out.println("===> mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	// 글 삭제
	public void deleteBoard(BoardVO_back vo) {
		System.out.println("===> mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	// 글 상세 조회
	public BoardVO_back getBoard(BoardVO_back vo) {
		System.out.println("===> mybatis로 getBoard() 기능 처리");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	// 글 목록 조회
	public List<BoardVO_back> getBoardList(BoardVO_back vo) {
		System.out.println("===> mybatis로 getBoardList() 기능 처리");
		 return mybatis.selectList("BoardDAO.getBoardList", vo); 

//		if (vo.getSearchCondition().equals("TITLE")) {
//			return mybatis.selectList("BoardDAO.getBoardList_t", vo);
//		} else {
//			return mybatis.selectList("BoardDAO.getBoardList_c", vo);
//		}

	}
}