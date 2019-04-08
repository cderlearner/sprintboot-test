CREATE TABLE FOO (ID INT IDENTITY, BAR VARCHAR(64));

CREATE TABLE `wv_partners_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL COMMENT '事件唯一 ID',
  `method` varchar(120) NOT NULL COMMENT '被调用的方法',
  `arguments` mediumtext NOT NULL COMMENT '调用使用的参数',
  `result` mediumtext COMMENT '返回值',
  `error` mediumtext COMMENT '异常错误栈',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_uuid` (`uuid`)
) ;
