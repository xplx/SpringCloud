package com.example.comsumer;

import com.example.comsumer.annotation.MyFirstAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComsumerApplicationTests {
	@MyFirstAnnotation("吃饭")
	@Test
	public void sayHello() {
		System.out.println("吃饭");
	}
}
