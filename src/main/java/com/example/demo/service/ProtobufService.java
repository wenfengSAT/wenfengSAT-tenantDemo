package com.example.demo.service;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.ProtobufBody;
import com.example.demo.proto.CreateOrderProto;

@BaseRequest(baseURL = "localhost:8080")
public interface ProtobufService {

	@Post(url = "/proto/order/create", contentType = "application/x-protobuf")
	CreateOrderProto.CreateOrderResp sendProtobufMessage(@ProtobufBody CreateOrderProto.CreateOrderReq message);
}
