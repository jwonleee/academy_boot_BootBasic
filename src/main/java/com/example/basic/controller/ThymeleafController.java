package com.example.basic.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.command.BuilderVO2;
import com.example.basic.command.SimpleVO;

@Controller
@RequestMapping("/view")
public class ThymeleafController {

	@RequestMapping("/ex01") //get방식만 허용
	public String ex01() {
		return "/view/ex01";
	}
	
	
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		
		//사용할 가짜 데이터
		ArrayList<BuilderVO2> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			BuilderVO2 vo = BuilderVO2.builder().name("홍길동" + i)
									  .age(i)
									  .build(); //builder로 담기 
			list.add(vo);
		}
		
		//model
		model.addAttribute("list",list);
		
		return "/view/ex02";
	}
	
	@RequestMapping("/ex03")
	public String ex03(Model model) {
		
		//사용할 가짜 데이터
		ArrayList<BuilderVO2> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			BuilderVO2 vo = BuilderVO2.builder().name("타임리프" + i)
									  .age(i)
									  .build(); //builder로 담기 
			list.add(vo);
		}
		
		//model
		model.addAttribute("list",list);
		
		return "/view/ex03";
	}
	
	//test
	//쿼리스트링
	@GetMapping("/test")
	public String test(@RequestParam("age") int age,
					   @RequestParam("name") String name) {
		
		System.out.println("test 메서드 실행");
		System.out.println(age);
		System.out.println(name);
		
		return "view/test";
	}
	
	//쿼리 파라미터
	@GetMapping("/test2/{a}/{b}") //3단으로 넘어오는 a,b
	public String test(@PathVariable("a") String a,
					   @PathVariable("b") String b) {
		System.out.println(a);
		System.out.println(b);
		
		return "view/test";
	}
	
	//화면에서 사용
	@GetMapping("/ex04")
	public String ex04(Model model) {
		
		BuilderVO2 vo = new BuilderVO2("이순신",20);
		model.addAttribute(("name"), "홍길동");
		model.addAttribute("vo",vo);
		
		return "view/ex04";
	}
	
	//타임리프 내장함수
	@GetMapping("/ex05")
	public String ex05(Model model) {
		
		//날짜의 형변환은 database, 자바, 화면 등 자신이 자신있는 곳에서 처리하면 됨
		model.addAttribute("regdate", LocalDateTime.now() ); //날짜형, 이거 쓰세요
		
		return "view/ex05";
	}
	
	//타임리프 include
	@GetMapping("/ex06")
	public String ex06() {
		
		return "view/ex06";
	}
	
	//타임리프 템플릿 모형 사용하기
	@GetMapping("/ex07")
	public String ex07() {
		
		return "view/ex07";
	}
	
	//quiz01- 실습
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		
		SimpleVO vo = new SimpleVO("1", "제니", "jennybyj");
		model.addAttribute("vo",vo);
		
		//build로 넣어줄 수도 있음
		//SimpleVO vo2 = SimpleVO.builder().num("2").name("로제").id("rose").build();
		
		return "view/quiz01";
	}
	
	//쿼리스트링
	@GetMapping("/quiz_result01")
	public String quiz_result01(@RequestParam("num") String num,
								@RequestParam("name") String name,
								@RequestParam("id") String id,
								Model model) {
		
		model.addAttribute("num", num);
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		
		return "view/quiz_result01";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}