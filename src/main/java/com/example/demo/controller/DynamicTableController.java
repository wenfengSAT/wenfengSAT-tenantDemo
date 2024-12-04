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

@RestController
@RequestMapping("/table")
public class DynamicTableController {

	@Autowired
	private LogMapper logMapper;
	@Autowired
	private LogService logService;

	// http://localhost:8080/table/default
	@GetMapping("/default")
	public List<Log> testDefault() throws Exception {
		List<Log> list = logService.list();
		return list;
	}

	// http://localhost:8080/table/insert
	@GetMapping("/insert")
	public String insert() throws Exception {
		MonthTableNameHandler.setData("202411");
		Log log = new Log();
		log.setBody("log body...");
		logMapper.insert(log);
		MonthTableNameHandler.removeData();
		return "SUCCESS";
	}

	// http://localhost:8080/table/list
	@GetMapping("/list")
	public List<Log> list() throws Exception {
		MonthTableNameHandler.setData("202411");
		List<Log> list = logService.list();
		MonthTableNameHandler.removeData();
		return list;
	}

}
