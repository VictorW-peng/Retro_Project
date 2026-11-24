-- Suture 数据库初始化脚本（MySQL 8）
-- 使用方式：mysql -u root -p < docs/sql/schema.sql

CREATE DATABASE IF NOT EXISTS `suture`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE `suture`;

CREATE TABLE IF NOT EXISTS `sys_user` (
    `user_id`       INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `user_name`     VARCHAR(64)  NOT NULL COMMENT '用户名',
    `user_password` VARCHAR(128) NOT NULL COMMENT '密码（当前为明文比对，后续升级为哈希）',
    `salt`          VARCHAR(64)  DEFAULT NULL COMMENT '密码盐值',
    `email`         VARCHAR(128) DEFAULT NULL COMMENT '邮箱',
    `phone`         VARCHAR(32)  DEFAULT NULL COMMENT '手机号',
    `gender`        TINYINT      DEFAULT NULL COMMENT '性别：1-男，2-女',
    `create_user`   VARCHAR(64)  DEFAULT NULL COMMENT '创建人',
    `create_time`   DATETIME     DEFAULT NULL COMMENT '创建时间',
    `modified_user` VARCHAR(64)  DEFAULT NULL COMMENT '修改人',
    `modified_time` DATETIME     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`user_id`),
    KEY `idx_sys_user_user_name` (`user_name`),
    KEY `idx_sys_user_email` (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户表';
