package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("tb_order")
public class Order extends Model<Order> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id")
	private Long id;

	private String name;

	private String tenantId;

	private String shopId;

}
