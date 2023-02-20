package com.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.command.BuilderVO;
import com.example.basic.command.BuilderVO.Builder;
import com.example.basic.command.BuilderVO2;
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
	//자주 사용하지는 않지만 형태나 사용하는 방법을 알아두세요
	@Test
	public void testCode02() {
//		기존 set메서드의 사용
//		Builder xx = BuilderVO.builder();
//		xx = xx.setAge(10);
//		xx = xx.setName("집가자");
//		BuilderVO vo = xx.build();
//		System.out.println(vo.toString());
		
		BuilderVO vo = BuilderVO.builder().setAge(10)
										  .setName("집가자")
									      .build();
		System.out.println(vo.toString());
		
		vo = BuilderVO.builder().setAge(20).
				  setName("ddd")
			      .build();
		
		System.out.println(vo.toString());
		
		BuilderVO2 vo2 = BuilderVO2.builder()
				   					  .name("동키") //name 저장
				   					  .age(30) //int 저장
				   					  .build();
		
		System.out.println(vo2.toString());
		
	}
}
