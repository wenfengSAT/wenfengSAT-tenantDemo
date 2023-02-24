# Host: 127.0.0.1  (Version 5.7.17-log)
# Date: 2023-02-24 15:38:17
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "tb_order"
#

CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_id` varchar(32) NOT NULL DEFAULT '' COMMENT '所属租户',
  `shop_id` varchar(32) NOT NULL DEFAULT '' COMMENT '所属店铺',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '订单名',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';
