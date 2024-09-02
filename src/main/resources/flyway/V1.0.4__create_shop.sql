
CREATE TABLE `tb_shop` (
  `id` varchar(30) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `version` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` smallint(6) NOT NULL DEFAULT '0' COMMENT '逻辑删除：0-未删除 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺';
