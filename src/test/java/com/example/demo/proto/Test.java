package com.example.demo.proto;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		List<CreateOrderProto.Sku> skus = new ArrayList<CreateOrderProto.Sku>();
		CreateOrderProto.Sku sku = CreateOrderProto.Sku.newBuilder().setCount(1).setSkuId("X001").build();
		skus.add(sku);
		CreateOrderProto.CreateOrderReq req = CreateOrderProto.CreateOrderReq.newBuilder()
				.setAddress("和畅五路西103号").addAllSkus(skus).build();
		
		
		HttpResponse response = doPost("http://localhost:8080/proto/order/create", req);
		CreateOrderProto.CreateOrderResp resp = CreateOrderProto.CreateOrderResp
				.parseFrom(response.getEntity().getContent());
		System.err.println(JSONUtil.toJsonStr(resp));
		
		
		HttpUtil.createPost("http://localhost:8080/proto/order/create")
				.header(Header.CONTENT_TYPE, "application/x-protobuf").execute();
	}
	

	public static HttpResponse doPost(String uri, CreateOrderProto.CreateOrderReq message) throws Exception {
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost post = new HttpPost(uri);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(message.toByteArray());
			InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);
			post.setEntity(inputStreamEntity);
			post.addHeader("Content-Type", "application/x-protobuf");
			closeableHttpResponse = httpclient.execute(post);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// httpclient.close();
		}
		return closeableHttpResponse;
	}
}
