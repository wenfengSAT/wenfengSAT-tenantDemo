package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.demo.enums.ApiSentinelResource;

/**
 * 
 * @Description： 哨兵限流
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月4日上午9:52:04]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

	/**
	 * 
	 * @Description： 测试限流
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日上午10:58:39]
	 * @return
	 *
	 * @Url http://localhost:8080/sentinel/logic
	 */
	@GetMapping("/logic")
	@SentinelResource(value = ApiSentinelResource.test, blockHandler = "handleFlowQpsException", fallback = "apiFallback")
	public String logic() {
		return "unlock...";
	}
}
