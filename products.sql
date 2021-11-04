/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : javaweb_22

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 04/11/2021 20:45:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of products
-- ----------------------------
BEGIN;
INSERT INTO `products` VALUES (1, 'Nike Jordan', 'https://cdn-images.farfetch-contents.com/15/95/78/34/15957834_30928142_600.jpg', 100.00);
INSERT INTO `products` VALUES (2, 'Adidas NMD', 'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/d44fa06fc83f4644b7e8acbc01160e1b_9366/NMD_R1_Primeblue_Shoes_Black_GZ9258_01_standard.jpg', 100.00);
INSERT INTO `products` VALUES (3, 'Adidas NMD 2', 'https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/c0dab4071480448f97e1ac86015631d1_9366/nmd_r1.jpg', 100.00);
INSERT INTO `products` VALUES (4, 'Adidas NMD 3', 'https://assets.adidas.com/images/w_385,h_385,f_auto,q_auto:sensitive,fl_lossy/a1c3a70d758f44e98ccfab1701239125_9366/nmd_r1-shoes.jpg', 200.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
