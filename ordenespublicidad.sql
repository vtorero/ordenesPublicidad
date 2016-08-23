-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-08-2016 a las 23:38:08
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ordenespublicidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ord_clientes`
--

DROP TABLE IF EXISTS `ord_clientes`;
CREATE TABLE IF NOT EXISTS `ord_clientes` (
  `C_CLIENTE` varchar(100) NOT NULL,
  `RAZON_SOCIAL` varchar(500) DEFAULT NULL,
  `CONTACTO` varchar(180) DEFAULT NULL,
  `RPT_LEGAL` varchar(180) DEFAULT NULL,
  `RPT_DNI` varchar(10) DEFAULT NULL,
  `RPT_DIRECCION` varchar(200) DEFAULT NULL,
  `RUC` varchar(20) NOT NULL,
  `DIRECCION` varchar(500) DEFAULT NULL,
  `TELEFONO` varchar(100) DEFAULT NULL,
  `F_CREACION` datetime DEFAULT NULL,
  `USUARIO` varchar(20) DEFAULT NULL,
  KEY `C_CLIENTE` (`C_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
