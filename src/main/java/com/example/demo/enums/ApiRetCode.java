package com.example.demo.enums;


import cn.hutool.core.util.StrUtil;
import lombok.Getter;

/**
 * 
 * @Description： 统一异常错误码
 * 
 * @author [ wenfengSAT@163.com ] on [2021年6月15日下午4:37:00]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Getter
public enum ApiRetCode implements CodeEnum {

	
	/**
	 * 成功
     */
	SUCCESS(0, "sucess!"),

    /**
      * 错误码
     */
    ERROR_PARAM(600, "请求参数不正确！"),
    REQUESTMETHODNOTSUPPORTED(601, "请求方式不支持！"),
    MEDIATYPENOTSUPPORTED(602, "请求协议格式不支持！"),
    SYSTEM_EXCEPTION(603, "系统错误！"),
    BUSY_SERVICE_EXCEPTION(604, "服务拥挤！"),
    SIGN_ERROR(605, "接口签名错误！"),
    
	;

	private int code;
	private String msg;

	ApiRetCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getFormat(Object... str) {
		return StrUtil.format(this.getMsg(), str);
	}

}
