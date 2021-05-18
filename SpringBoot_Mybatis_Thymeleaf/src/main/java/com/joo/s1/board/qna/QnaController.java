package com.joo.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.joo.s1.board.BoardVO;
import com.joo.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception{
		List<BoardVO> ar= qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	@GetMapping("select")
	public ModelAndView getSelect(BoardVO boardVO)throws Exception{
		ModelAndView mv= new ModelAndView();
		boardVO = qnaService.getSelect(boardVO);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/select");
		return mv;
	}
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO,Model model)throws Exception{
		boardVO= qnaService.getSelect(boardVO);
		model.addAttribute("vo", boardVO);
		model.addAttribute("action", "update");
		return "board/form";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO)throws Exception{
		int result= qnaService.setUpdate(boardVO);
		return "redirect:./list";
	}
	
	
	@GetMapping("insert")
	public String setInsert(Model model)throws Exception{
		model.addAttribute("vo", new BoardVO());
		model.addAttribute("action", "insert");
		return "board/form";
	}

	@PostMapping("insert")
	public String setInsert(BoardVO boardVO, MultipartFile [] files)throws Exception{
		int result = qnaService.setInsert(boardVO, files);

		return "redirect:./list";
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO)throws Exception{

		int result = qnaService.setDelete(boardVO);

		return "redirect:./list";
	}

	@GetMapping("reply")
	public String setReplyInsert(BoardVO boardVO, Model model)throws Exception{
		model.addAttribute("vo", boardVO);
		model.addAttribute("action", "reply");
		return "board/form";
	}

	@PostMapping("reply")
	public String setReplyInsert(BoardVO boardVO, MultipartFile [] files)throws Exception{
		int result = qnaService.setReplyInsert(boardVO, files);

		return "redirect:./list";
	}	
	
}
