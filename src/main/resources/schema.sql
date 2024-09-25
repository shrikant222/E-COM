CREATE TABLE IF NOT EXISTS `buyer` (
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


CREATE TABLE IF NOT EXISTS `roles` (
                                       `role_id` int NOT NULL AUTO_INCREMENT,
                                       `role_name` varchar(50) NOT NULL,
                                       `created_at` TIMESTAMP NOT NULL,
                                       `created_by` varchar(50) NOT NULL,
                                       `updated_at` TIMESTAMP DEFAULT NULL,
                                       `updated_by` varchar(50) DEFAULT NULL,
                                       PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `address` (
   `address_id` int NOT NULL AUTO_INCREMENT,
   `address1` varchar(200) NOT NULL,
    `address2` varchar(200) DEFAULT NULL,
    `city` varchar(50) NOT NULL,
    `state` varchar(50) NOT NULL,
    `zip_code` int NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`address_id`)
    );

CREATE TABLE IF NOT EXISTS `person` (
    `person_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `email` varchar(50) NOT NULL,
    `mobile_number` varchar(20) NOT NULL,
    `pwd` varchar(200) NOT NULL,
    `role_id` int NOT NULL,
    `address_id` int NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`person_id`),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
    );