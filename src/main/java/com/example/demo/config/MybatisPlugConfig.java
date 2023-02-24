package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.example.demo.config.tenant.PreTenantHandler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.mapper")
public class MybatisPlugConfig {

	@Autowired
	private PreTenantHandler preTenantHandler;

	/**
	 * mybatis plus 拦截器各组件配置
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
		// 多租户配置
		TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor();
		tenantLineInnerInterceptor.setTenantLineHandler(preTenantHandler);
		mybatisPlusInterceptor.addInnerInterceptor(tenantLineInnerInterceptor);
		return mybatisPlusInterceptor;
	}

}