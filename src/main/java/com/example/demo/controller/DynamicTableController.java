package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Log;
import com.example.demo.handler.MonthTableNameHandler;
import com.example.demo.mapper.LogMapper;
import com.example.demo.service.LogService;

/**
 * 
 * @Description： mybatisplus动态表示例
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月5日下午2:15:11]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RestController
@RequestMapping("/table")
public class DynamicTableController {

	@Autowired
	private LogMapper logMapper;
	@Autowired
	private LogService logService;

	/**
	 * 
	 * @Description： 测试默认情况
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午2:15:37]
	 * @return
	 * @throws Exception
	 *
	 * @Url http://localhost:8080/table/default
	 */
	@GetMapping("/default")
	public List<Log> testDefault() throws Exception {
		List<Log> list = logService.list();
		return list;
	}

	/**
	 * 
	 * @Description： 测试手动指定分表日期
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午2:15:37]
	 * @return
	 * @throws Exception
	 *
	 * @Url http://localhost:8080/table/insert
	 */
	@GetMapping("/insert")
	public String insert() throws Exception {
		MonthTableNameHandler.setData("202411");
		Log log = new Log();
		log.setBody("log body...");
		logMapper.insert(log);
		MonthTableNameHandler.removeData();
		return "SUCCESS";
	}

	/**
	 * 
	 * @Description： 测试查询
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月5日下午2:15:37]
	 * @return
	 * @throws Exception
	 *
	 * @Url http://localhost:8080/table/list
	 */
	@GetMapping("/list")
	public List<Log> list() throws Exception {
		MonthTableNameHandler.setData("202411");
		List<Log> list = logService.list();
		MonthTableNameHandler.removeData();
		return list;
	}

}
