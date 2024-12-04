package com.example.demo.controller;

import com.baomidou.mybatisplus.core.plugins.IgnoreStrategy;
import com.baomidou.mybatisplus.core.plugins.InterceptorIgnoreHelper;
import com.example.demo.config.tenant.TenantContextHolder;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import cn.hutool.core.util.RandomUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @Description： 多租户示例
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:57:01]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RequestMapping("/tenant")
@RestController
public class TenantController {

	@Autowired
	private OrderService orderService;

	// http://localhost:8080/tenant/list
	@GetMapping("/list")
	public List<Order> list() throws Exception {
		TenantContextHolder.setTenantId("1");
		return orderService.list();
	}

	// http://localhost:8080/tenant/admin/list
	@GetMapping("/admin/list")
	public List<Order> adminList() throws Exception {
		// 设置忽略租户插件
		InterceptorIgnoreHelper.handle(IgnoreStrategy.builder().tenantLine(true).build());
		List<Order> list = orderService.list();
		// 关闭忽略策略
		InterceptorIgnoreHelper.clearIgnoreStrategy();
		return list;
	}

	// http://localhost:8080/tenant/listNoTenant
	@GetMapping("/listNoTenant")
	public List<Order> listNoTenant() throws Exception {
		return orderService.selectist();
	}

	// http://localhost:8080/tenant/detail/1
	@GetMapping("/detail/{id}")
	public Order detail(@PathVariable long id) {
		TenantContextHolder.setTenantId("1");
		return orderService.getById(id);
	}

	// http://localhost:8080/enant/insert
	@GetMapping("/insert")
	public void insert() {
		TenantContextHolder.setTenantId("1");
		Order order = new Order();
		order.setName("N" + RandomUtil.randomNumbers(5));
		order.setShopId("S" + RandomUtil.randomNumbers(5));
		orderService.save(order);
	}

}
