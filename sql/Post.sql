CREATE TABLE `post` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `board_code` varchar(50) NOT NULL,
                        `cont` varchar(255) DEFAULT NULL,
                        `edit_date` datetime(6) DEFAULT NULL,
                        `filename` varchar(255) DEFAULT NULL,
                        `filesize` int NOT NULL,
                        `ori_filename` varchar(255) DEFAULT NULL,
                        `reg_date` datetime(6) DEFAULT NULL,
                        `subject` varchar(255) DEFAULT NULL,
                        `type` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci