package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @Description： 接口安全
 * 
 * @author [ Wenfeng.Huang@desaysv.com ] on [2024年12月6日上午11:29:29]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	/**
	 * 请求过期时间-60s
	 */
	public static final long EXPIRE_TIME = 60000;

	/**
	 * 
	 * @Description： 接口安全设计
	 * 
	 * @author [ Wenfeng.Huang@desaysv.com ]
	 * @Date [2024年12月6日下午3:14:26]
	 * @param req
	 * @return
	 *
	 */
	@PostMapping("/security")
	public String security(@RequestBody SecurityReq req) {
		long requestTime = req.getTimestamp();
		if (!checkExpire(requestTime)) {
			return "expired";
		}
		if (!checkSign(req)) {
			return "tampered";
		}
		return "success";
	}

	/**
	 * 
	 * @Description： 防重放
	 * 
	 * @author [ Wenfeng.Huang@desaysv.com ]
	 * @Date [2024年12月6日下午3:05:43]
	 * @param requestTime
	 * @return
	 *
	 */
	private boolean checkExpire(long requestTime) {
		return EXPIRE_TIME > System.currentTimeMillis() - requestTime;
	}

	/**
	 * 
	 * @Description： 防篡改
	 * 
	 * @author [ Wenfeng.Huang@desaysv.com ]
	 * @Date [2024年12月6日下午3:09:15]
	 * @param req
	 * @return
	 *
	 */
	private boolean checkSign(SecurityReq req) {
		return true;
	}

	@Setter
	@Getter
	public static class SecurityReq {
		/**
		 * 签名
		 */
		private String sign;
		/**
		 * 时间戳
		 */
		private long timestamp;
		/**
		 * 业务流水号
		 */
		private String traceId;

	}

}
