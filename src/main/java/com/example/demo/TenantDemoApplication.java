package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dtflys.forest.springboot.annotation.ForestScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo.**" })
@ForestScan(basePackages = "com.example.demo.**")
public class TenantDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantDemoApplication.class, args);
	}

}
