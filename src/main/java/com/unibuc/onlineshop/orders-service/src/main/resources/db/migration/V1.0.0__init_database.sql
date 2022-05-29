CREATE TABLE `bank_accounts` (
                            `id_account` bigint NOT NULL AUTO_INCREMENT,
                            `card_number` varchar(100) DEFAULT NULL,
                            `secure_code` varchar(3) DEFAULT NULL,
                            `cardholder` varchar(100) DEFAULT NULL,
                            `valid_date` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (id_account)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `addresses` (
                             `id_address` bigint NOT NULL AUTO_INCREMENT,
                             `country` varchar(100) DEFAULT NULL,
                             `city` varchar(100) DEFAULT NULL,
                             `street` varchar(100) DEFAULT NULL,
                             `postal_code` varchar(100) DEFAULT NULL,
                             `details` varchar(100) DEFAULT NULL,
                             PRIMARY KEY (id_address)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
                         `id_user` bigint NOT NULL AUTO_INCREMENT,
                         `first_name` varchar(100) DEFAULT NULL,
                         `last_name` varchar(100) DEFAULT NULL,
                         `email` varchar(100) DEFAULT NULL,
                         `phone` varchar(100) DEFAULT NULL,
                         `birthdate` date DEFAULT NULL,
                         `id_addresses` bigint DEFAULT NULL,
                         `id_accounts` bigint DEFAULT NULL,
                         PRIMARY KEY (id_user),
                         KEY `id_addresses` (`id_addresses`),
                         KEY `id_accounts` (`id_accounts`),
                         CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_addresses`) REFERENCES `addresses` (id_address),
                         CONSTRAINT `users_ibfk_2` FOREIGN KEY (`id_accounts`) REFERENCES `bank_accounts` (id_account)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `orders` (
                          `id_order` bigint NOT NULL AUTO_INCREMENT,
                          `id_users` bigint DEFAULT NULL,
                          `id_shopping_carts` bigint DEFAULT NULL,
                          `total_price` double DEFAULT NULL,
                          PRIMARY KEY (id_order),
                          KEY `id_users` (`id_users`),
                          KEY `id_shopping_carts` (`id_shopping_carts`),
                          CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



