package com.example.demo.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
	
	@InterceptorIgnore(tenantLine = "true")
	List<Order> selectist();

}
