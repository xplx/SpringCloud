package com.example.eureka;

import com.example.eureka.controller.rabbitmq.HelloSenderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private HelloSenderController helloSender;

	@Test
	public void hello() throws Exception {
		helloSender.send();
	}
}
