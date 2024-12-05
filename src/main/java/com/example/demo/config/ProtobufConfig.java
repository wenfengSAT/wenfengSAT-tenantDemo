package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 * 
 * @Description： Protobuf配置
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月5日下午2:13:15]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Configuration
public class ProtobufConfig {

	@Bean
	public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

}
