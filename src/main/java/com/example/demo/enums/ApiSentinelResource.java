package com.example.demo.enums;

/**
 * 
 * @Description： 功能描述
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月5日下午1:58:47]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
public interface ApiSentinelResource {

	String test = "test";

	/**
	 * 
	 * @Description： 功能描述
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午1:56:56]
	 * @return
	 *
	 */
	int getQps();

	/**
	 * 
	 * @Description： 功能描述
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午1:56:59]
	 * @return
	 *
	 */
	String getResource();

	/**
	 * 
	 * @Description： 功能描述
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午1:57:03]
	 * @return
	 *
	 */
	String getDesc();
}
