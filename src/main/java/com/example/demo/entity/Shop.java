package com.example.demo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "tb_shop", autoResultMap = true)
public class Shop extends Model<Shop> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private String id;

	private String name;

	@Version
	private Long version;

	private Date createTime;

	private Date updateTime;
}
