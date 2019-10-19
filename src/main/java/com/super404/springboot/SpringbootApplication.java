package com.super404.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication顶得上下面三个注解
@Configuration
@EnableAutoConfiguration
@ComponentScan*/
@SpringBootApplication
@MapperScan("com.super404.springboot.mapper")
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}