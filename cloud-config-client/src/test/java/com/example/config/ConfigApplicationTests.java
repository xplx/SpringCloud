package com.example.config;

import com.example.config.controller.rabbitmq.SendController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Autowired
	private SendController sendController;

	@Test
	public void hello() throws Exception {
		sendController.send();
	}
}
