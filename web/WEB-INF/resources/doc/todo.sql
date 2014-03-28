create database todo character set utf8 collate utf8_general_ci;

## 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `valied` int(11) NOT NULL,
  `activited` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

## 任务表
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sendor_account` varchar(255) NOT NULL,
  `receiver_account` varchar(255) NOT NULL,
  `task_title` varchar(255) NOT NULL,
  `task_content` varchar(1024) DEFAULT NULL,
  `finish_time` datetime NOT NULL,
  `first_remind_time` datetime NOT NULL,
  `second_remind_time` datetime NOT NULL,
  `priority` int(11) NOT NULL,
  `media` blob,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

## 日程
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `content` varchar(1024) NOT NULL,
  `date_time` datetime NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;