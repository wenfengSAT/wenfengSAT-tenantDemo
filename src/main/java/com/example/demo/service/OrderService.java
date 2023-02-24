package com.example.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Order;

public interface OrderService extends IService<Order> {

	List<Order> selectist();
}
