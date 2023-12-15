package com.mire.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mire.biz.board.BoardService;
import com.mire.biz.board.BoardVO;
import com.mire.biz.common.LogAdvice;
import com.mire.biz.common.LogAdvice2;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
@Autowired
	private BoardDAO boardDAO;

	
	@Override
	public void insertBoard(BoardVO vo) {
		//AOP를 사용하여 xml로 관리 할 것이다.
		//로깅 분리
//		System.out.println("［공통 로그］ 비즈니스 로직 수행 전 동작");
//		log.printLogging();
		if(vo.getSeq() == 0){
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		
		boardDAO.insertBoard(vo);
		//예외처리 분리
//		System.out.println("［공통 로그］ 예외처리 동작");
		//트랜젝션 분리
//		System.out.println("［공통 로그］ 트랜젝션 동작");
		//로깅 end 분리
//		System.out.println("［공통 로그］ 비즈니스 로직 수행 후 동작");
	}

	@Override
	public void updateBoard(BoardVO vo) {
//		log.printLogging();
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
//		log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
