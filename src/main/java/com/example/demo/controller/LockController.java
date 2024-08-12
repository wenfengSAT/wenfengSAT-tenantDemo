package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.lock.LockInfo;
import com.baomidou.lock.LockTemplate;
import com.baomidou.lock.annotation.Lock4j;
import com.example.demo.entity.Order;

import cn.hutool.core.util.ObjectUtil;

@RestController
@RequestMapping("/api")
public class LockController {

	@Autowired
	private LockTemplate lockTemplate;

	@GetMapping("/lock/test")
	public String lock() {
		// 获取锁,过期时间(10000ms) 防止死锁, 尝试获取锁超时时间(1000ms)
		final LockInfo lockInfo = lockTemplate.lock("testKey", 10000L, 1000L);
		if (ObjectUtil.isNull(lockInfo)) {
			// 业务处理中, 请稍后再试
			return "lock...";
		}
		// 获取锁成功，处理业务
		try {
			System.out.println("获取锁成功，处理业务, 当前线程:" + Thread.currentThread().getName());
		} catch (Exception e) {
			// 业务处理异常
		} finally {
			// 释放锁
			lockTemplate.releaseLock(lockInfo);
		}
		// 结束
		return "unlock...";
	}

	// 默认获取锁超时3秒，30秒锁过期
	@Lock4j
	public void simple() {
		// do something
	}

	// 完全配置，支持spel
	@Lock4j(keys = { "#order.id", "#order.name" }, expire = 60000, acquireTimeout = 1000)
	public Order customMethod(Order order) {
		return order;
	}

	// 用户在5秒内只能访问1次
	@Lock4j(keys = { "#order.id" }, acquireTimeout = 0, expire = 5000, autoRelease = false)
	public Boolean test(Order order) {
		return true;
	}
}
