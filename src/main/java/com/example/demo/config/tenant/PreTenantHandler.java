package com.example.demo.config.tenant;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.example.demo.config.tenant.PreTenantConfigProperties;

import cn.hutool.core.util.StrUtil;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.StringValue;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description： 多租户SQL处理
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:55:41]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Builder
@Slf4j
@Component
@AllArgsConstructor
public class PreTenantHandler implements TenantLineHandler {

	private final PreTenantConfigProperties configProperties;

	/**
	 * 租户Id
	 * 
	 * @return
	 */
	@Override
	public Expression getTenantId() {
		String tenantId = TenantContextHolder.getTenantId();
		log.debug("当前租户为 >> {}", tenantId);
		if (StrUtil.isBlank(tenantId)) {
			return new NullValue();
		}
		return new StringValue(tenantId);
	}

	/**
	 * 租户字段名
	 *
	 * @return
	 */
	@Override
	public String getTenantIdColumn() {
		return configProperties.getTenantIdColumn();
	}

	/**
	 * 根据表名判断是否进行过滤
	 *
	 * @param tableName
	 * @return
	 */
	@Override
	public boolean ignoreTable(String tableName) {
		return !configProperties.getTenantTables().stream().anyMatch((e) -> e.equalsIgnoreCase(tableName));
	}
}
