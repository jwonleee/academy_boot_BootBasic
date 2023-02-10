package com.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.command.BuilderVO;
import com.example.basic.command.BuilderVO.Builder;
import com.example.basic.controller.HomeController;

@SpringBootTest //스프링부트 테스트 클래스
public class BootTest {

//	@Autowired //빈으로 등록되어 있어서 autowired 사용가능
//	HomeController homeController;
//	
//	@Test
//	public void testCode01() {
//		System.out.println(homeController.home());
//	}
	
	//builder 패턴 객체의 사용
	@Test
	public void testCode02() {
//		Builder xx = BuilderVO.builder();
//		xx = xx.setAge(10);
//		xx = xx.setName("집가자");
//		BuilderVO vo = xx.build();
//		System.out.println(vo.toString());
		
		BuilderVO vo = BuilderVO.builder().setAge(10)
										  .setName("집가자")
									      .build();
		System.out.println(vo.toString());
		
	}
}
