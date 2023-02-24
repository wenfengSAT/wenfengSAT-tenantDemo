package com.example.demo.controller;

import com.example.demo.config.tenant.TenantContextHolder;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ResourceController {

	@Autowired
	private OrderService orderService;

	// http://localhost:8080/api/list
	@GetMapping("/list")
	public List<Order> list() throws Exception {
		return orderService.list();
	}

	// http://localhost:8080/api/listNoTenant
	@GetMapping("/listNoTenant")
	public List<Order> listNoTenant() throws Exception {
		return orderService.selectist();
	}

	// http://localhost:8080/api/detail/1
	@GetMapping("/detail/{id}")
	public Order detail(@PathVariable long id) {
		TenantContextHolder.setTenantId("1");
		return orderService.getById(id);
	}

}
