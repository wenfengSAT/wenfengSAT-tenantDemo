package com.example.demo.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RetryService;


/**
 * 
 * @Description： 重试
 * 
 * @author [ wenfengSAT@163.com ] on [2025年4月7日下午4:06:55]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RestController
@RequestMapping("/retry")
public class RetryController {
	
	@Autowired
	private RetryService retryService;

	/**
	 * 
	 * @Description： http://localhost:8080/retry/test
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2025年4月7日下午4:17:32]
	 * @return
	 * @throws IOException
	 *
	 */
	@GetMapping("/test")
	public String retry() throws IOException {

		return retryService.retry();
	}


}
