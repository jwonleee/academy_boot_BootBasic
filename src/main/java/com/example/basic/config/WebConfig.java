package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.controller.HomeController;


@Configuration //개별적인 스프링 빈 설정 파일, spring에서 servlet-context.xml로 썼던거
public class WebConfig implements WebMvcConfigurer{

	//빈을 보관하고 있는 장소 (스프링 컨테이너)
	@Autowired //applicationContext를 주입해라
	ApplicationContext applicationContext;
	
	//application properties의 값을 직접 참조
	//properties 파일에 선언된 변수를 바로 참조
	@Value("${server.port}") //application properties 변수명
	String port; //이 변수에 담아줌
	
	@Bean //해당 메서드를 실행하게 됨, 실행하고 끝
	public void test() {
//		System.out.println("테스트 빈 실행");
//		return new 생성클래스(); 해야 빈이 등록됨
		
		TestBean t = applicationContext.getBean(TestBean.class);
		System.out.println(t);
		
		HomeController h = applicationContext.getBean(HomeController.class);
		System.out.println(h);
		
		int a = applicationContext.getBeanDefinitionCount();
		System.out.println("빈의 개수: " + a);
		
		System.out.println("properties에 선언된 값: " + port);
	}
	
	@Bean //해당 메서드를 실행하게 됨, 실행하고 나서 return으로 new 클래스()하면 ioc 컨테이너가 빈으로 보관함
	public TestBean testBean() { //수동!
		System.out.println("테스트 빈 실행2");
		return new TestBean(); //빈으로 등록
	}
	
}
