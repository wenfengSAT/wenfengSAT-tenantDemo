package com.example.demo.service.impl;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.springframework.stereotype.Service;

import com.example.demo.service.RetryService;

/**
 * 
 * @Description： Spring Retry
 * 
 * @author [ wenfengSAT@163.com ] on [2025年4月7日下午4:25:46]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Service
public class RetryServiceImpl implements RetryService {

	@Override
	public String retry() throws IOException {
		// 为了演示，我们模拟一个可能失败的API调用
		if (Math.random() < 0.7) { // 70%的概率失败
			System.err.println("error...");
			throw new SocketTimeoutException("retry...");
		}
		System.err.println("success...");
		return "success...";
	}

	@Override
	public String recover(Exception e) {
		// 记录重试之后还失败的日志
		System.err.println("recover...");
		return "recover...";
	}

}
