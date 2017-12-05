package com.iparhan.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan("com.iparhan.blog.dao")
public class IparhanController {
	public static void main(String[] args) {
		SpringApplication.run(IparhanController.class, args);
	}

}
