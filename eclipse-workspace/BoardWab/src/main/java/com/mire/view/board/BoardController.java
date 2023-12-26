package com.mire.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mire.biz.board.BoardService;
import com.mire.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

//글등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		MultipartFile uploadFile = vo.getUploadFile();
		//업로드된 파일이 있다면 서버저장장치레 저장한다.
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("fileName : "+fileName);
			File file = new File("C:/DEV/fileSave/"+fileName);
			uploadFile.transferTo(file);
		}
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		System.out.println("dataTransform");
		// 검색정보 null체크
				if (vo.getSearchCondition() == null) {
					vo.setSearchCondition("TITLE");
				}
				if (vo.getSearchKeyword() == null) {
					vo.setSearchKeyword("");
				}
				// String searchCondition = request.getParameter("searchCondition");
//				String searchKeyword = request.getParameter("searchKeyword");
//				System.out.println(condition);
//				System.out.println(keyword);
				List<BoardVO> boardList = boardService.getBoardList(vo);
				return boardList;
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("/updateBoard.do");
		System.out.println(vo.toString());
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		// 검색정보 null체크
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		// String searchCondition = request.getParameter("searchCondition");
//		String searchKeyword = request.getParameter("searchKeyword");
//		System.out.println(condition);
//		System.out.println(keyword);

		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";

	}

}
