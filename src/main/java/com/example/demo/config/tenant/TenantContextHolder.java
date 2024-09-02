package com.example.demo.config.tenant;

import com.alibaba.ttl.TransmittableThreadLocal;

import lombok.experimental.UtilityClass;

/**
 * 
 * @Description： 租户ID在内存里的管理
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:54:23]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
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
