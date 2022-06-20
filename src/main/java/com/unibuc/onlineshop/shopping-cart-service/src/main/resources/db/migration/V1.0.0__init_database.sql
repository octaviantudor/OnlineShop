CREATE TABLE `shopping_carts` (
                                  id_shopping_cart bigint NOT NULL AUTO_INCREMENT,
                                  `checked` tinyint(1) DEFAULT '0',
                                  `username` varchar(60),
                                  PRIMARY KEY (id_shopping_cart)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `shopping_cart_products` (
                                           `id` bigint NOT NULL AUTO_INCREMENT,
                                           `id_shopping_cart` bigint NOT NULL,
                                           `id_product` varchar(60) NOT NULL,
                                           PRIMARY KEY (id),
                                           CONSTRAINT `shopping_carts_products_ibfk_1` FOREIGN KEY (id_shopping_cart) REFERENCES `shopping_carts` (id_shopping_cart)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
