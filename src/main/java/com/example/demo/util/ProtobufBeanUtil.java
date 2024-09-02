package com.example.demo.util;

import com.google.gson.Gson;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * 
 * @Description： Protobuf与实体对象转换
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:58:22]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
public class ProtobufBeanUtil {

	private ProtobufBeanUtil() {
	}

	/**
	 * 将ProtoBean对象转化为POJO对象
	 *
	 * @param destPojoClass 目标POJO对象的类类型
	 * @param sourceMessage 含有数据的ProtoBean对象实例
	 * @param <PojoType>    目标POJO对象的类类型范型
	 * @return
	 * @throws IOException
	 */
	public static <PojoType> PojoType toPojoBean(@NotNull Class<PojoType> destPojoClass, @NotNull Message sourceMessage)
			throws IOException {
		String json = JsonFormat.printer().print(sourceMessage);
		return new Gson().fromJson(json, destPojoClass);
	}

	/**
	 * 将POJO对象转化为ProtoBean对象
	 *
	 * @param destBuilder    目标Message对象的Builder类
	 * @param sourcePojoBean 含有数据的POJO对象
	 * @return
	 * @throws IOException
	 */
	public static void toProtoBean(@NotNull Message.Builder destBuilder, @NotNull Object sourcePojoBean)
			throws IOException {
		String json = new Gson().toJson(sourcePojoBean);
		JsonFormat.parser().merge(json, destBuilder);
	}

}
