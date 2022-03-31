package com.jz.quick;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jz.quick.mapper")
public class QuickApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuickApplication.class, args);
	}

}
