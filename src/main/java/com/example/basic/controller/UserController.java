package com.example.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.basic.command.UsersVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login") //화면 띄우는 거고
	public String login() {
		return "user/login";	
	}
	
	//로그인 기능
	@PostMapping("/login") //포스트로 로그인 하는거
	public String loginForm(UsersVO vo, HttpSession session) {
		
		//select * from 유저 where id=? and pw=? 날리면 select된 값이 넘어옴, 없으면 값이 없고(null값 나타냄)
		//System.out.println(vo.toString()); 확인
		
		//서비스 영역 호출 (로그인 성공)
		UsersVO userVO = new UsersVO();
		userVO.setId("aaa");
		userVO.setName("홍길동"); //성공이라고 가정 - 값이 있을 것임
		
		//로그인 성공 - 세션을 이용해서 인증값
		if(userVO != null) { //로그인 성공했다면
			session.setAttribute("user_id", userVO.getId()); //토큰
			return "redirect:/user/mypage"; //로그인 성공
		} 
		
		return "user/login"; //실패시에 그냥 다시 로그인 페이지
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "user/mypage";
	}
	
	@GetMapping("info")
	public String info() {
		return "user/info";
	}
	
}
