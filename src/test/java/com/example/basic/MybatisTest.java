package com.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.mapper.TestMapper;

@SpringBootTest
public class MybatisTest {

	@Autowired
	TestMapper testMapper;
	
	@Test
	public void testCode01() {
		System.out.println(testMapper.getTime());
	}
}
