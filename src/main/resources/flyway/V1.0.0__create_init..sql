
CREATE TABLE IF NOT EXISTS `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_id` varchar(32) NOT NULL DEFAULT '' COMMENT '所属租户',
  `shop_id` varchar(32) NOT NULL DEFAULT '' COMMENT '所属店铺',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '订单名',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';
