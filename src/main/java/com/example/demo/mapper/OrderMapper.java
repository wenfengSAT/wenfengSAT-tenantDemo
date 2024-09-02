package com.example.demo.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
	
	/**
	 * 
	 * @Description： 忽略多租户
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年9月2日上午11:27:50]
	 * @return
	 *
	 */
	@InterceptorIgnore(tenantLine = "true")
	List<Order> selectist();

}
