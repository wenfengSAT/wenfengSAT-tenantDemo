package com.example.demo.handler;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description： ID生成器
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月5日下午2:28:54]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Slf4j
@Component
public class CustomIdGeneratorHandler implements IdentifierGenerator {

	private final AtomicLong al = new AtomicLong(1);

	@Override
	public Long nextId(Object entity) {
		// 可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
		String bizKey = entity.getClass().getName();
		log.info("bizKey:{}", bizKey);
		MetaObject metaObject = SystemMetaObject.forObject(entity);
		String name = (String) metaObject.getValue("name");
		final long id = al.getAndAdd(1);
		log.info("为{}生成主键值->:{}", name, id);
		return id;
	}

}
