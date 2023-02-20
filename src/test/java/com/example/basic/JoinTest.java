package com.example.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.command.MemoVO;
import com.example.basic.command.UsersVO;
import com.example.basic.mapper.TestMapper;

@SpringBootTest
public class JoinTest {
	
	@Autowired
	private TestMapper testMapper;
	
	//N : 1 조인
	@Test
	public void testCode01 () {
		List<MemoVO> list = testMapper.joinOne();
		System.out.println(list.toString());
	}
	
	//1: N 조인
	@Test
	public void testCode02() {
		UsersVO<MemoVO> vo = testMapper.joinTwo();
		System.out.println(vo.toString());
	}
}
