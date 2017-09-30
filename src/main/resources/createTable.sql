
#创建项目
CREATE TABLE `project` (
  `id` VARCHAR(40) NOT NULL COMMENT '项目id',
  `name` VARCHAR(80) NOT NULL COMMENT '项目名称',
  `member_num` INTEGER NOT NULL DEFAULT 0 COMMENT '项目成员数',
  `user_ids` VARCHAR(1000) DEFAULT NULL COMMENT '项目成员id, 通过逗号分割',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目';

#创建目录
CREATE TABLE `directory` (
  `id` varchar(40) NOT NULL COMMENT '目录id',
  `name` varchar(80) NOT NULL COMMENT '目录名称',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新目录时间',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '添加目录时间',
  `dir_id` varchar(40) NULL DEFAULT NULL COMMENT '目录所属父目录id',
  `project_id` VARCHAR(40) NOT NULL COMMENT '目录所属项目Id'

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建文档
CREATE TABLE `document` (
  `id` VARCHAR(40) NOT NULL COMMENT '文档id',
  `title` VARCHAR(40) NOT NULL COMMENT '文档标题',
  `description` VARCHAR(300) NOT NULL COMMENT '文档描述',
  `add_time` TIMESTAMP NULL DEFAULT NULL COMMENT '文档添加时间',
  `update_time` TIMESTAMP NULL DEFAULT NULL COMMENT '文档更新时间',
  `create_user` VARCHAR(40) DEFAULT NULL COMMENT '文档创建者的id',
  `update_user` VARCHAR(40) DEFAULT NULL COMMENT '文档更新者的id',
  `project_id` VARCHAR(40) NOT NULL COMMENT '文档所属项目id',
  `dir_id` VARCHAR(40) NOT NULL COMMENT '文档所属目录id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#文档接口
CREATE TABLE `doc_interface` (
  `id` VARCHAR(40) NOT NULL COMMENT '接口id',
  `title` VARCHAR(40) NOT NULL COMMENT '接口标题',
  `type` INTEGER NOT NULL DEFAULT 1 COMMENT '接口类型',
  `req_params` VARCHAR(1000) NULL COMMENT '请求参数',
  `res` VARCHAR(2000) NOT NULL COMMENT '响应数据',
  `path` VARCHAR(300) NOT NULL COMMENT '请求路径',
  `doc_id` VARCHAR(40) NOT NULL COMMENT '接口所属文档',
  `method` VARCHAR(10) NOT NULL DEFAULT 'get' '接口请求方法'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文档接口';

#修改表结构
alter table `doc_interface`
  Add column method VARCHAR(10) not null default 'get' AFTER `path`
