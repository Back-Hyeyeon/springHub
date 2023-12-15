package com.mire.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardSsrviceClient {

	public static void main(String[] args) {
		// 스프링 컨테이너를 만드는 생성자이다.(객체관리 목적.)
		AbstractApplicationContext gen = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService) gen.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		vo.setTitle("스프링2");
		vo.setWriter("백혜연");
		vo.setContent("임시내용......");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
		System.out.println("——> " + board.toString());
		}

		gen.close();
	}

}
