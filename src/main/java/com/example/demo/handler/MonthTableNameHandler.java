package com.example.demo.handler;

import java.util.Arrays;
import java.util.List;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description： 按月份参数，组成动态表名
 * 
 * @author [ wenfengSAT@163.com ] on [2024年12月3日下午3:47:12]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Slf4j
public class MonthTableNameHandler implements TableNameHandler {

	// 用于记录哪些表可以使用该月份动态表名处理器（即哪些表按月分表）
	private List<String> tableNames;

	// 构造函数，构造动态表名处理器的时候，传递tableNames参数
	public MonthTableNameHandler(String... tableNames) {
		this.tableNames = Arrays.asList(tableNames);
	}

	/**
	 * 每个请求线程维护一个month数据，避免多线程数据冲突。所以使用ThreadLocal
	 */
	private static final ThreadLocal<String> MONTH_DATA = new TransmittableThreadLocal<String>();

	/**
	 * 
	 * @Description： 设置请求线程的month数据
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月3日下午5:35:27]
	 * @param month
	 *
	 */
	public static void setData(String month) {
		MONTH_DATA.set(month);
	}

	/**
	 * 
	 * @Description： 删除当前请求线程的month数据
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月3日下午5:35:12]
	 *
	 */
	public static void removeData() {
		MONTH_DATA.remove();
	}

	/**
	 * 
	 * @Description： 动态表名接口实现方法
	 * 
	 * @author [ wenfengSAT@163.com ]
	 * @Date [2024年12月3日下午5:35:12]
	 *
	 */
	@Override
	public String dynamicTableName(String sql, String tableName) {
		log.info("dynamicTableName tableNames:{}, tableName:{}, sql:{}", JSONUtil.toJsonStr(tableNames), tableName,
				sql);
		if (this.tableNames.contains(tableName)) {
			if (StrUtil.isBlank(MONTH_DATA.get())) {
				String month = DateUtil.format(DateTime.now(), "yyyyMM");
				return tableName + "_" + month; // 表名增加月份后缀
			}
			// 表名增加月份后缀
			return tableName + "_" + MONTH_DATA.get();
		} else {
			// 表名原样返回
			return tableName;
		}
	}
}
