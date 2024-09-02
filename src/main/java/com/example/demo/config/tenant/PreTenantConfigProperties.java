package com.example.demo.config.tenant;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * @Description： 多租户配置
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:55:27]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "tenant", ignoreUnknownFields = true)
public class PreTenantConfigProperties {
	/**
	 * 多租户字段
	 */
	private String tenantIdColumn;

	/**
	 * 多租户表
	 */
	private List<String> tenantTables;

}
