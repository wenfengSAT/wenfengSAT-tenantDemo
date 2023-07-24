package com.example.demo.proto;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderProtoTest {

	public static void main(String[] args) {
		List<CreateOrderProto.Sku> skus = new ArrayList<CreateOrderProto.Sku>();
		CreateOrderProto.Sku sku = CreateOrderProto.Sku.newBuilder().setCount(1).setSkuId("X001").build();
		skus.add(sku);
		CreateOrderProto.CreateOrderReq req = CreateOrderProto.CreateOrderReq.newBuilder()
				.setAddress("和畅五路西103号德赛西威汽车电子股份有限公司").addAllSkus(skus).build();
		System.out.println(req.toString());
		System.out.println(req.getSkusList().toString());
	}
}
