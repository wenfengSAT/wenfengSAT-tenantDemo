package com.example.demo.enums;

/**
 * 
 * @Description： 异常返回码枚举接口
 * 
 * @author [ wenfengSAT@163.com ] on [2021年6月15日下午4:32:15]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
public interface CodeEnum {

	/**
	 * 
	 * @Description： 获取返回码
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2021年6月15日下午4:37:59]
	 * @return
	 *
	 */
	int getCode();

	/**
	 * 
	 * @Description： 获取返回信息
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2021年6月15日下午4:38:09]
	 * @return
	 *
	 */
	String getMsg();

}
