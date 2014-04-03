CREATE TABLE `version_info` (
`id` int NOT NULL,
`version_no` varchar NOT NULL,
`version_target` varchar NULL,
`start_time` datetime NOT NULL,
`end_time` datetime NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `version_content` (
`id` int NOT NULL,
`version_no` varchar NOT NULL,
`theme` varchar NOT NULL,
`has_doc` int NOT NULL,
`has_img` int NOT NULL,
`has_code` int NOT NULL,
`note` varchar NULL,
`has_table` int NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `version_develop_info` (
`id` int NOT NULL,
`version_content_id` int NOT NULL,
`doc_ok` int NOT NULL,
`img_ok` int NOT NULL,
`test_ok` int NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `version_content_test` (
`id` int NOT NULL,
`version_content_id` int NOT NULL,
`test_focus` varchar(255) NOT NULL,
`is_ok` int NOT NULL,
`note` varchar NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `user` (
`id` int NOT NULL,
`account` varchar NOT NULL,
`passwd` varchar NOT NULL,
`email` varchar NOT NULL,
`class` varchar NOT NULL,
`score` int NOT NULL,
PRIMARY KEY (`id`) 
);

