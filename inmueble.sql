/*
-- Query: SHOW CREATE TABLE inmueble
-- Date: 2026-04-15 18:19
*/
INSERT INTO `` (`Table`,`Create Table`) VALUES ('inmueble','CREATE TABLE `inmueble` (\n  `numero` varchar(20) NOT NULL,\n  `fecha_compra` varchar(20) DEFAULT NULL,\n  `estado` tinyint(1) DEFAULT NULL,\n  `propietario_id` varchar(20) DEFAULT NULL,\n  `tipo` varchar(20) DEFAULT NULL,\n  `pisos` int DEFAULT NULL,\n  `piso` int DEFAULT NULL,\n  PRIMARY KEY (`numero`),\n  KEY `propietario_id` (`propietario_id`),\n  CONSTRAINT `inmueble_ibfk_1` FOREIGN KEY (`propietario_id`) REFERENCES `propietario` (`id`)\n) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci');
