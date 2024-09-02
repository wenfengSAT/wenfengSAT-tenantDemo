package com.example.demo.entity;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.demo.handler.EncryptHandler;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "tb_order", autoResultMap = true)
public class Order extends Model<Order> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	// 加解密示例
	@TableField(typeHandler = EncryptHandler.class)
	private String name;

	@NotBlank(message = "租户ID不能为空")
	private String tenantId;

	private String shopId;

}
