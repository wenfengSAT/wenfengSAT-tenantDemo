package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.proto.CreateOrderProto;
import com.example.demo.service.ProtobufService;

/**
 * 
 * @Description： proto协议示例
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:56:39]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@RestController
@RequestMapping("/proto")
public class ProtoController {

	@Resource
	private ProtobufService protobufService;

	@PostMapping(value = "/order/create", consumes = "application/x-protobuf", produces = "application/x-protobuf")
	public CreateOrderProto.CreateOrderResp message(@RequestBody HttpEntity<CreateOrderProto.CreateOrderReq> req) {
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

	@RequestMapping(value = "/order/create1", produces = "application/x-protobuf")
	@ResponseBody
	public CreateOrderProto.CreateOrderResp getPersonProto(CreateOrderProto.CreateOrderReq request) {
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

	@GetMapping(value = "/test")
	public String test() {
		List<CreateOrderProto.Sku> skus = new ArrayList<CreateOrderProto.Sku>();
		CreateOrderProto.Sku sku = CreateOrderProto.Sku.newBuilder().setCount(1).setSkuId("X001").build();
		skus.add(sku);
		CreateOrderProto.CreateOrderReq req = CreateOrderProto.CreateOrderReq.newBuilder()
				.setAddress("和畅五路西103号德赛西威汽车电子股份有限公司").addAllSkus(skus).build();
		CreateOrderProto.CreateOrderResp resp = protobufService.sendProtobufMessage(req);
		System.err.println(resp.getOrderId());
		return "Suecss...";
	}
}
