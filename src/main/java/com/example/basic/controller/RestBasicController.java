package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.basic.command.SimpleVO;

@RestController // Controller + ResponseBody -> 컨트롤러 어노테이션 따로 해주지 않음
public class RestBasicController {

   /*
    *1. ResponseBody는 return값이 뷰리졸버가 아니고, 요청이 들어온 곳으로 반환된다
    * 
    */
	
//	@Value("${값}")
//	String Server;
   
   @GetMapping("/getText")
   public String getText() {
         
      return "hello world";
   }
   
   
   //객체를 담게 되면 application/json 형식으로 반환하게 됩니다.
   /*
    * produces - 보내는 데이터에 대한 타입
    * consumes - 받는 데이터에 대한 타입 
    */
   @GetMapping(value="/getObject", produces = "application/json")
   public SimpleVO getObject() {
	   SimpleVO vo = new SimpleVO("1", "홍길동", "aaa123");
	   return vo; 
   }
   
   @GetMapping("/getObject2")
   public Map<String, Object> getObject2() {
	   
	   Map<String, Object> map = new HashMap<>();
	   
	   SimpleVO vo = new SimpleVO("1", "홍길동", "aaa123");
	   map.put("total", 100);
	   map.put("data", vo);
	   
	   return map;
   }
   
   //리스트 형식의 반환
   @GetMapping("/getObject3")
   public List<SimpleVO> getObject3() {
	   
	   List<SimpleVO> list = new ArrayList<>();
	   
	   for(int i = 1; i <= 10; i++) {
		   list.add(new SimpleVO("1", "홍길동"+i, "aaa123"+i) );
	   }
	   return list; //배열 형식으로 담김
   }
   
   //방법 2가지
   //get형식 값을 받는 방법1 - 쿼리스트링?키=값
   //http://localhost:8383/getKey?name=abc&id=defg
   @GetMapping("/getKey")
   public String getKey(@RequestParam("id") String id,
		   				@RequestParam("name") String name) {
	   
	   System.out.println(id);
	   System.out.println(name);
	   
	   return "success";
   }
   
   //get형식 값을 받는 방법2 - 쿼리파람 URL/키/키
   //http://localhost:8383/getPath/desc/aaa123 
   @GetMapping("/getPath/{sort}/{apiKey}")
   public String getPath(@PathVariable("sort") String sort,
		   				 @PathVariable("apiKey") String key ) {
	   
	   System.out.println(sort);
	   System.out.println(key);
	   
	   return "success";
   }
   
   //////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////post 형식의 처리///////////////////////////////////////////
   //믿을 수 있는 데이터만 받아줘야 함
   
   //값을 받는 방법 1 - VO로 맵핑
   //JSON 형식의 데이터를 자바의 객체로 맵핑 ▶ @RequestBody
   //{"id": "aaa", "name": "bbb"}
   
   //cors - 기본적으로 서버가 다르면 요청을 거절하는데 (특정 서버에 대하여 허용)
   //@CrossOrigin(*) - 모든 곳에서 다열림
   @CrossOrigin("http://localhost:3000")
   @PostMapping("/getJson")
   public String getJson(@RequestBody SimpleVO vo) {
	   
	   System.out.println(vo.toString());
	   return "success";
   }
   
   //값을 받는 방법2 - Map으로 맵핑
   @PostMapping("/getMap")
   public String getMap(@RequestBody  Map<String, Object> map) {
	   
	   System.out.println(map.toString());
	   
	   return "success";
   }
   
   //consumer를 통한 데이터제한
   //consumer는 특정 타입의 데이터를 받도록 처리하는 옵셥 (기본값 json)
   //클라이언트에는 Content-type을 이용해서 보내는 데이터에 대한 타입을 명시 (반드시 필수)
   //컨슈머의 짝궁은 클라이언트의 컨슈머 타입, 프로듀서의 짝궁은 클라이언트의 데이터 타입 (캡쳐)
   @PostMapping(value="/getResult", consumes = "text/plain")
   public String getResult(@RequestBody String data) {
	   
	   System.out.println(data);
	   return "success";
   }
   
   //응답문서의 형태를 직접 선언 - ResponseEntity
   @PostMapping("/createRes")
   public ResponseEntity createRes() {
	   
	   SimpleVO vo = new SimpleVO("1", "홍길동", "aaa"); //데이터
	   
	   HttpHeaders header = new HttpHeaders(); //헤더정보
	   header.add("Authrization", "token");
	   
	   HttpStatus status = HttpStatus.ACCEPTED; //상태코드 (성공 or 실패)
	   
	   //제네릭은 데이터를 따라갑니다.
	   ResponseEntity<SimpleVO> entity = new ResponseEntity<>(vo, header, status);
	   
	   return entity;
   }
   
   
   
   
}