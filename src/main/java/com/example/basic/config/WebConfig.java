package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.controller.HomeController;
import com.example.basic.util.UserAuthHandler;
import com.example.basic.util.UserSuccessHandler;


@Configuration //개별적인 스프링 빈 설정 파일, spring에서 servlet-context.xml로 썼던거
public class WebConfig implements WebMvcConfigurer{

	/*
	 * //빈을 보관하고 있는 장소 (스프링 컨테이너)
	 * 
	 * @Autowired //applicationContext를 주입해라 ApplicationContext applicationContext;
	 * 
	 * //application properties의 값을 직접 참조 //properties 파일에 선언된 변수를 바로 참조
	 * 
	 * @Value("${server.port}") //application properties 변수명 String port; //이 변수에
	 * 담아줌
	 * 
	 * @Bean //해당 메서드를 실행하게 됨, 실행하고 끝 public void test() { //
	 * System.out.println("테스트 빈 실행"); // return new 생성클래스(); 해야 빈이 등록됨
	 * 
	 * TestBean t = applicationContext.getBean(TestBean.class);
	 * System.out.println(t);
	 * 
	 * HomeController h = applicationContext.getBean(HomeController.class);
	 * System.out.println(h);
	 * 
	 * int a = applicationContext.getBeanDefinitionCount();
	 * System.out.println("빈의 개수: " + a);
	 * 
	 * System.out.println("properties에 선언된 값: " + port); }
	 * 
	 * @Bean //해당 메서드를 실행하게 됨, 실행하고 나서 return으로 new 클래스()하면 ioc 컨테이너가 빈으로 보관함 public
	 * TestBean testBean() { //수동! System.out.println("테스트 빈 실행2"); return new
	 * TestBean(); //빈으로 등록 }
	 */
	
	
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler(); //UserAuthHandler 빈 생성, 등록
	}
	
	@Bean
	public UserSuccessHandler userSuccessHandler() {
		return new UserSuccessHandler(); //UserSuccessHandler 빈 생성, 등록
	}
	
	//WebMvcConfigurer 클래스가 제공해주는 인터셉터 추가 함수 - 오버라이딩 되면 이 메서드 먼저 실행, 이거 쓰면 알아서 스프링으로 던져줌
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(userAuthHandler())
					//경로 정해서 포함 시킬수도 있음 (캡쳐)
					.addPathPatterns("/user/*") //패스경로 포함 (전체)
					.excludePathPatterns("/user/login") //패스경로 제외
					; //핸들러 인터셉터 타입이 들어감
			
			//경로별로 인터셉터를 다르게 등록 - 여러개 더 추가해서 사용 가능
			//registry.addInterceptor(null);
			registry.addInterceptor(userSuccessHandler())
					.addPathPatterns("/user/*");
		
	}
	
	
	
	
	
}
