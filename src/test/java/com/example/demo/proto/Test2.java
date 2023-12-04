package com.example.demo.proto;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import cn.hutool.json.JSONUtil;

public class Test2 {
	public static void main(String[] args) throws IOException {
		List<CreateOrderProto.Sku> skus = new ArrayList<CreateOrderProto.Sku>();
		CreateOrderProto.Sku sku = CreateOrderProto.Sku.newBuilder().setCount(1).setSkuId("X001").build();
		skus.add(sku);
		CreateOrderProto.CreateOrderReq req = CreateOrderProto.CreateOrderReq.newBuilder()
				.setAddress("和畅五路西103号").addAllSkus(skus).build();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			URI uri = new URI("http", null, "127.0.0.1", 8080, "/proto/order/create", "", null);
			HttpPost post = new HttpPost(uri);
			post.setEntity(new ByteArrayEntity(req.toByteArray()));
			post.setHeader("Content-Type", "application/x-protobuf");

			HttpResponse response = httpClient.execute(post);

			if (response.getStatusLine().getStatusCode() == 200) {

				CreateOrderProto.CreateOrderResp resp = CreateOrderProto.CreateOrderResp
						.parseFrom(response.getEntity().getContent());
				System.err.println(JSONUtil.toJsonStr(resp));
			} else {
				System.err.println(response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			httpClient.close();
		}
	}
}
