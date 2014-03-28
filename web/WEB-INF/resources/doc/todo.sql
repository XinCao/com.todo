create database todo character set utf8 collate utf8_general_ci;

drop table if exists todo;
CREATE TABLE `todo` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;