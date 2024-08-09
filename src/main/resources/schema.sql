CREATE TABLE IF NOT EXISTS `Buyer` (
  `buyer_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `age` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `pincode` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
    `country` varchar(100) NOT NULL,
    `size` varchar(100) NOT NULL,
    `additional_info` varchar(500) NOT NULL,
  `status` varchar(10) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL
);