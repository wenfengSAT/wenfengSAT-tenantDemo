package com.example.demo.config.tenant;

import com.alibaba.ttl.TransmittableThreadLocal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TenantContextHolder {

	private final ThreadLocal<String> THREAD_LOCAL_TENANT = new TransmittableThreadLocal<>();

	/**
	 * TTL 设置租户ID
	 *
	 * @param tenantId
	 */
	public void setTenantId(String tenantId) {
		THREAD_LOCAL_TENANT.set(tenantId);
	}

	/**
	 * 获取TTL中的租户ID
	 *
	 * @return
	 */
	public String getTenantId() {
		return THREAD_LOCAL_TENANT.get();
	}

	/**
	 * 删除TTL中的租户ID
	 *
	 */
	public void clear() {
		THREAD_LOCAL_TENANT.remove();
	}
}
