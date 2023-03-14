package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.proto.CreateOrderProto;

@RestController
@RequestMapping("/proto")
public class ProtoController {

	@PostMapping(value = "/order/create", consumes = "application/x-protobuf", produces = "application/x-protobuf")
	public CreateOrderProto.CreateOrderResp message(HttpEntity<CreateOrderProto.CreateOrderReq> req) {
		CreateOrderProto.CreateOrderReq request = req.getBody();
		System.out.println(request.toString());
		List<CreateOrderProto.Sku> skus = request.getSkusList();
		System.out.println(skus.toString());

		List<CreateOrderProto.OrderItem> items = new ArrayList<CreateOrderProto.OrderItem>();
		CreateOrderProto.OrderItem item = CreateOrderProto.OrderItem.newBuilder().setItemId("X001")
				.setName("iPhone6s 土豪金 64G").build();
		items.add(item);
		CreateOrderProto.CreateOrderResp response = CreateOrderProto.CreateOrderResp.newBuilder().setOrderId("X10086")
				.addAllOrderItem(items).build();
		return response;
	}
}
