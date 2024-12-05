package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.example.demo.enums.SentinelEnum;

/**
 * 
 * @Description： Sentinel切面类配置
 * 
 * @author [ Wenfeng.Huang@desay-svautomotive.com ] on [2021年6月15日下午4:29:20]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Configuration
public class SentinelAspectConfig {

	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}

	/**
	 * 
	 * @Description： 初始化限流规则
	 * 
	 * @author [ Wenfeng.Huang@desay-svautomotive.com ]
	 * @Date [2021年6月15日下午4:29:12]
	 * @throws Exception
	 *
	 */
	@PostConstruct
	private void initRules() throws Exception {
		List<FlowRule> ruleList = new ArrayList<FlowRule>();
		for (SentinelEnum sentinel : SentinelEnum.values()) {
			FlowRule rule = new FlowRule();
			rule.setResource(sentinel.getResource());
			rule.setCount(sentinel.getQps());// 限流阈值
			rule.setGrade(RuleConstant.FLOW_GRADE_QPS);// 限流阈值类型（QPS 或并发线程数）
			rule.setLimitApp("default");// 流控针对的调用来源，若为 default 则不区分调用来源
			// 流量控制手段（直接拒绝、Warm Up、匀速排队）
			rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
			ruleList.add(rule);
		}
		FlowRuleManager.loadRules(ruleList);
	}

}
