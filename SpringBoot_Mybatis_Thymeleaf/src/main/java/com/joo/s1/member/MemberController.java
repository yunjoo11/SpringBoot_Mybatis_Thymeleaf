package com.joo.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String setLogin() throws Exception{
		return "member/memberLogin";
	}
	
	@PostMapping("login")
	public String setLogin(MemberVO memberVO, HttpSession session) throws Exception{
		memberVO= memberService.getLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		return "redirect:/";
	}
	
	@GetMapping("join")
	public String setJoin() throws Exception{
		
		return "member/memberJoin";
	}
	
}
