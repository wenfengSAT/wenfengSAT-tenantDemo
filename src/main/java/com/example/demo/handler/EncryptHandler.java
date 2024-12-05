package com.example.demo.handler;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @Description： 使用mybatis-plus实现加解密
 * 
 * @author [ wenfengSAT@163.com ] on [2024年9月2日上午10:57:25]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
@Slf4j
@MappedTypes({ String.class })
@MappedJdbcTypes(JdbcType.VARCHAR)
public class EncryptHandler extends BaseTypeHandler<String> {

	/**
	 * 线上运行后勿修改，会影响已加密数据解密
	 */
	private static final byte[] KEYS = "shc987654321camp".getBytes(StandardCharsets.UTF_8);

	/**
	 * 设置参数
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		System.out.println(parameter + " setNonNullParameter...");
		if (StringUtils.isEmpty(parameter)) {
			ps.setString(i, null);
			return;
		}
		String encrypt = encrypt(parameter);
		ps.setString(i, encrypt);
	}

	/**
	 * 获取值
	 */
	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		System.out.println(columnName + " getNullableResult...");
		return decrypt(rs.getString(columnName));
	}

	/**
	 * 获取值
	 */
	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		log.info("getNullableResult...");
		return decrypt(rs.getString(columnIndex));
	}

	/**
	 * 获取值
	 */
	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		log.info("getNullableResult...");
		return decrypt(cs.getString(columnIndex));
	}

	/**
	 * 获取值
	 */
	private String encrypt(String value) {
		if (null == value) {
			return null;
		}
		String encrypt = null;
		try {
			encrypt = SecureUtil.aes(KEYS).encryptHex(value);
		} catch (Exception e) {
			log.error("encrypt fail!", e);
		}
		return encrypt;
	}

	/**
	 * 获取值
	 */
	public String decrypt(String value) {
		if (null == value) {
			return null;
		}
		String decrypt = null;
		try {
			decrypt = SecureUtil.aes(KEYS).decryptStr(value);
		} catch (Exception e) {
			log.error("decrypt fail!", e);
		}
		return decrypt;
	}
}
