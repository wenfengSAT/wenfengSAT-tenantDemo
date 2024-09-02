package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Description： 服务器重定向
 * 
 * @author [ wenfengSAT@163.com ] on [2024年8月13日上午10:16:35]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RestController
@RequestMapping("/url")
public class UrlController {

	/**
	 * 
	 * @Description： 服务器重定向
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年8月13日上午10:17:04]
	 * @return
	 *
	 */
	@RequestMapping("redirect")
	public ModelAndView redirect() {
		return new ModelAndView("redirect:http://www.baidu.com");
	}

}