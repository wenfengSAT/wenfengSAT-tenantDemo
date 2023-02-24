package com.example.demo.config.tenant;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

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
