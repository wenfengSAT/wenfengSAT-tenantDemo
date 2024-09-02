package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dtflys.forest.springboot.annotation.ForestScan;

/**
 * 
 * @Description： 主程序
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:51:05]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo.**" })
@ForestScan(basePackages = "com.example.demo.**")
public class TenantDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantDemoApplication.class, args);
	}

}
