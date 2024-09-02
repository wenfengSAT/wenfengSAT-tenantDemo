package com.example.demo.service;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.ProtobufBody;
import com.example.demo.proto.CreateOrderProto;

/**
 * 
 * @Description： forest使用示例
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:59:15]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@BaseRequest(baseURL = "localhost:8080")
public interface ProtobufService {

	@Post(url = "/proto/order/create", contentType = "application/x-protobuf")
	CreateOrderProto.CreateOrderResp sendProtobufMessage(@ProtobufBody CreateOrderProto.CreateOrderReq message);
}
