package com.example.demo.enums;

import lombok.Getter;

/**
 * 
 * @Description： 功能描述
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月5日下午1:58:56]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Getter
public enum SentinelEnum implements ApiSentinelResource {

	TEST(1, test, "限流测试"),

	;

	private int qps;
	private String resource;
	private String desc;

	SentinelEnum(int qps, String resource, String desc) {
		this.qps = qps;
		this.resource = resource;
		this.desc = desc;
	}
}
