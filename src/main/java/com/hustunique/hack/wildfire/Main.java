package com.hustunique.hack.wildfire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hustunique.hack.controller")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}