package com.example.demo.service;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * 
 * @Description： Spring Retry
 * 
 * @author [ wenfengSAT@163.com ] on [2025年4月7日下午4:25:46]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
public interface RetryService {

	@Retryable(value = { IOException.class, SocketTimeoutException.class }, // 指定需要重试的异常
			maxAttempts = 3, // 最大尝试次数（包括第一次）
			backoff = @Backoff(delay = 1000, multiplier = 2, maxDelay = 5000) // 重试延迟策略
	)
	String retry() throws IOException;

	/**
	 * 
	 * @Description： 方法因指定异常而失败时的恢复方法，重试完仍失败时候调用
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2025年4月7日下午4:37:11]
	 * @param e
	 * @return
	 *
	 */
	@Recover
	String recover(Exception e);
}
