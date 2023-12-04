package com.example.demo.proto;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ProtobufService;

import cn.hutool.json.JSONUtil;

//注意！！！先修改端口为8080启动项目，然后再将端口修改为8081再运行单元测试，
//直接运行单侧测试是不行的
@SpringBootTest
public class CreateOrderProtoTest {

	@Resource
	private ProtobufService protobufService;

	public static void main(String[] args) {
		List<CreateOrderProto.Sku> skus = new ArrayList<CreateOrderProto.Sku>();
		CreateOrderProto.Sku sku = CreateOrderProto.Sku.newBuilder().setCount(1).setSkuId("X001").build();
		skus.add(sku);
		CreateOrderProto.CreateOrderReq req = CreateOrderProto.CreateOrderReq.newBuilder()
				.setAddress("和畅五路西103号德赛西威汽车电子股份有限公司").addAllSkus(skus).build();
		System.out.println(req.toString());
		System.out.println(req.getSkusList().toString());
	}

	@Test
	public void test() {
		List<CreateOrderProto.Sku> skus = new ArrayList<CreateOrderProto.Sku>();
		CreateOrderProto.Sku sku = CreateOrderProto.Sku.newBuilder().setCount(1).setSkuId("X001").build();
		skus.add(sku);
		CreateOrderProto.CreateOrderReq req = CreateOrderProto.CreateOrderReq.newBuilder()
				.setAddress("和畅五路西103号德赛西威汽车电子股份有限公司").addAllSkus(skus).build();
		CreateOrderProto.CreateOrderResp resp = protobufService.sendProtobufMessage(req);
		System.err.println(JSONUtil.toJsonStr(resp));
	}
}
