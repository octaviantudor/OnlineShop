CREATE TABLE `shopping_carts` (
                                  id_shopping_cart bigint NOT NULL AUTO_INCREMENT,
                                  `checked` tinyint(1) DEFAULT '0',
                                  PRIMARY KEY (id_shopping_cart)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `shopping_cart_products` (
                                           `id_shopping_cart` bigint NOT NULL,
                                           `id_product` bigint NOT NULL,
                                           PRIMARY KEY (id_product,id_shopping_cart),
                                           CONSTRAINT `shopping_carts_products_ibfk_1` FOREIGN KEY (id_shopping_cart) REFERENCES `shopping_carts` (id_shopping_cart)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
