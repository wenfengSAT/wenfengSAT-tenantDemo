package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

	@Override
	public List<Order> selectist() {
		return this.baseMapper.selectist();
	}

}
