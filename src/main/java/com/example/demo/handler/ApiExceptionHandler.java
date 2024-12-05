package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.example.demo.enums.ApiRetCode;
import com.example.demo.exception.BaseException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description： api统一异常处理
 * 
 * @author [ wenfengSAT@163.com ] on [2021年6月15日下午3:55:41]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Slf4j
@Component
@RestControllerAdvice
public class ApiExceptionHandler {

	private static final String RESULTCODE = "code";

	private static final String RESULTDESC = "msg";

	/**
	 * 
	 * @Description： 统一异常处理
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年7月10日下午12:05:49]
	 * @param e
	 * @return
	 *
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handlerException(Exception e) {
		log.error("ApiExceptionHandler.handlerException msg:{}", e);
		Map<String, Object> result = new HashMap<>();
		if (e instanceof BlockException || e.getCause() instanceof FlowException) {
			result.put(RESULTCODE, ApiRetCode.BUSY_SERVICE_EXCEPTION.getCode());
			result.put(RESULTDESC, ApiRetCode.BUSY_SERVICE_EXCEPTION.getMsg());
		} else if (e instanceof FlowException || e.getCause() instanceof FlowException) {
			result.put(RESULTCODE, ApiRetCode.BUSY_SERVICE_EXCEPTION.getCode());
			result.put(RESULTDESC, ApiRetCode.BUSY_SERVICE_EXCEPTION.getMsg());
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			result.put(RESULTCODE, ApiRetCode.REQUESTMETHODNOTSUPPORTED.getCode());
			result.put(RESULTDESC, ApiRetCode.REQUESTMETHODNOTSUPPORTED.getMsg());
		} else if (e instanceof HttpMediaTypeNotSupportedException) {
			result.put(RESULTCODE, ApiRetCode.MEDIATYPENOTSUPPORTED.getCode());
			result.put(RESULTDESC, ApiRetCode.MEDIATYPENOTSUPPORTED.getMsg());
		} else if (e instanceof BaseException) {
			result.put(RESULTCODE, String.valueOf(((BaseException) e).getResponseEnum().getCode()));
			result.put(RESULTDESC, ((BaseException) e).getMessage());
		} else {
			result.put(RESULTCODE, ApiRetCode.SYSTEM_EXCEPTION.getCode());
			result.put(RESULTDESC, ApiRetCode.SYSTEM_EXCEPTION.getMsg());
		}
		return result;
	}

	/**
	 * 
	 * @Description： 统一捕获参数校验的异常抛出
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2021年6月15日下午3:55:56]
	 * @param e
	 * @return
	 *
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> bindException(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		StringBuilder errorMesssage = new StringBuilder("参数异常:");
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			errorMesssage.append(fieldError.getDefaultMessage()).append(",");
		}
		Map<String, Object> context = new HashMap<>();
		context.put(RESULTCODE, ApiRetCode.ERROR_PARAM.getCode());
		context.put(RESULTDESC, errorMesssage.toString());
		return context;
	}

}
