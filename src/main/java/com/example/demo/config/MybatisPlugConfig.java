package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.example.demo.config.tenant.PreTenantHandler;
import com.example.demo.handler.MonthTableNameHandler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @Description： mybatis plus配置
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:53:49]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Configuration
@MapperScan("com.example.demo.mapper")
public class MybatisPlugConfig {

	@Autowired
	private PreTenantHandler preTenantHandler;

	/**
	 * 
	 * @Description： mybatis plus 拦截器各组件配置
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午2:12:58]
	 * @return
	 *
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
		// 多租户配置
		TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor();
		tenantLineInnerInterceptor.setTenantLineHandler(preTenantHandler);
		mybatisPlusInterceptor.addInnerInterceptor(tenantLineInnerInterceptor);
		// 乐观锁插件
		mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		// 动态表名插件
		DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
		dynamicTableNameInnerInterceptor.setTableNameHandler(
				// 可以传多个表名参数，指定哪些表使用MonthTableNameHandler处理表名称
				new MonthTableNameHandler("tb_log"));
		mybatisPlusInterceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
		//
		return mybatisPlusInterceptor;
	}

}