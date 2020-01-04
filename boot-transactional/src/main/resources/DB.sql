drop database  if exists  supermarket;
create database supermarket;
use supermarket;
drop table if exists `order_item`;
CREATE TABLE `order_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT   '订单ID',
  `order_no` varchar(64) NOT NULL COMMENT '订单号',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `price` decimal(12,2) NOT NULL COMMENT '单价',
  `count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '订单项表';


drop table if exists `good_stock` ;
CREATE TABLE `good_stock` (
  `stock_id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '库存ID',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `total` int(11) NOT NULL COMMENT '总数量',
  `sold` int(11) NOT NULL COMMENT '已售出',
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '商品库存表';

insert into  good_stock (goods_id,total,sold) values(100000,10,0);
