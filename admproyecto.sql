-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-07-2016 a las 10:02:18
-- Versión del servidor: 5.5.50-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `admproyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE IF NOT EXISTS `proyecto` (
  `id_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `descripcion` text NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_usuario_2` (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`id_proyecto`, `nombre`, `descripcion`, `id_usuario`) VALUES
(1, 'prueba', 'prueba', 1),
(2, 'proyecto 2', 'descripción 2', 1),
(3, 'Proyecto 3', 'prueba 3', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE IF NOT EXISTS `tarea` (
  `id_tarea` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` text NOT NULL,
  `estado` text NOT NULL,
  `id_proyecto` int(11) NOT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `id_proyecto` (`id_proyecto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id_tarea`, `titulo`, `estado`, `id_proyecto`) VALUES
(1, 'titulo1', 'inicial', 1),
(2, 'tarea1', 'inicial', 2),
(3, 'tarea2', 'terminado', 1),
(4, 'tarea3', 'terminado', 2),
(5, 'tarea4', 'inicial', 1),
(6, 'tarea5', 'terminado', 1),
(7, 'tarea7', 'desarrollo', 1),
(8, 'hola', 'desarrollo', 1),
(9, 'prueba9', 'terminado', 2),
(10, 'tarea10', 'desarrollo', 2),
(11, 'tarea11', 'desarrollo', 3),
(12, 'uhnuoinmi', 'inicial', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `email` text NOT NULL,
  `rol` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `email`, `rol`) VALUES
(1, 'Joyce', 'joyce@example.com', 'estudiante');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
