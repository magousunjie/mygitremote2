package cn.java.ckEc.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages="{cn.java.ckEc.controller,cn.java.ckEc.service}")
@MapperScan(basePackages="{cn.java.ckEc.mapper}")
public class ImutCkecStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImutCkecStartApplication.class, args);
	}

}

