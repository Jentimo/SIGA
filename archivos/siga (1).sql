-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2022 a las 17:50:05
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `siga`
--
CREATE DATABASE IF NOT EXISTS `siga` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE `siga`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso`
--

CREATE TABLE `acceso` (
  `id_acceso` int(11) NOT NULL,
  `tipo` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `acceso`
--

INSERT INTO `acceso` (`id_acceso`, `tipo`) VALUES
(1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `id_actividad` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id_actividad`, `nombre`, `activo`) VALUES
(1, 'Reparacion de Disco Duro', 1),
(2, 'Mantenimiento Preventivo', 1),
(3, 'Reparacion de Red', 1),
(4, 'Actualizacion de Software', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `idBit` int(11) NOT NULL,
  `Usuario` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Fecha_h` datetime NOT NULL,
  `descr` text COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`idBit`, `Usuario`, `Fecha_h`, `descr`) VALUES
(1, '28276746', '2022-03-31 23:30:41', 'Inicio Sesion'),
(2, '28276746', '2022-03-31 23:30:53', 'Ha cerrado sesion'),
(3, '28276746', '2022-04-01 15:25:17', 'Inicio Sesion'),
(4, '28276746', '2022-04-01 15:25:26', 'Ingreso al modulo Bitacora'),
(5, '28276746', '2022-04-01 15:26:26', 'Ha cerrado sesion'),
(6, '28276746', '2022-04-01 16:05:08', 'Inicio Sesion'),
(7, '28276746', '2022-04-01 16:05:14', 'Ingreso al modulo Bitacora'),
(8, '28276746', '2022-04-01 16:05:51', 'Ingreso al modulo Usuario'),
(9, '28276746', '2022-04-01 16:05:57', 'Ha cerrado sesion'),
(10, '28276746', '2022-04-02 11:32:52', 'Inicio Sesion'),
(11, '28276746', '2022-04-02 11:32:55', 'Ingreso al modulo Bitacora'),
(12, '28276746', '2022-04-02 11:33:02', 'Ingreso al modulo actividad'),
(13, '28276746', '2022-04-02 11:33:07', 'Ha cerrado sesion'),
(14, '28276746', '2022-04-02 20:05:34', 'Inicio Sesion'),
(15, '28276746', '2022-04-02 20:05:42', 'Ingreso al modulo actividad'),
(16, '28276746', '2022-04-02 20:07:11', 'Ha cerrado sesion'),
(17, '28276746', '2022-04-02 20:08:02', 'Inicio Sesion'),
(18, '28276746', '2022-04-02 20:08:05', 'Ingreso al modulo actividad'),
(19, '28276746', '2022-04-02 20:09:05', 'Ha cerrado sesion'),
(20, '28276746', '2022-04-02 22:27:06', 'Inicio Sesion'),
(21, '28276746', '2022-04-02 22:27:10', 'Ingreso al modulo actividad'),
(22, '28276746', '2022-04-02 22:28:00', 'Ha cerrado sesion'),
(23, '28276746', '2022-04-02 22:28:56', 'Inicio Sesion'),
(24, '28276746', '2022-04-02 22:28:58', 'Ingreso al modulo actividad'),
(25, '28276746', '2022-04-02 22:29:28', 'Ha registrado la actividad Reparacion de Disco Duro'),
(26, '28276746', '2022-04-02 22:30:07', 'Ingreso al modulo Sede'),
(27, '28276746', '2022-04-02 22:30:14', 'Ha cerrado sesion'),
(28, '28276746', '2022-04-02 22:30:33', 'Inicio Sesion'),
(29, '28276746', '2022-04-02 22:30:36', 'Ingreso al modulo actividad'),
(30, '28276746', '2022-04-02 22:30:49', 'Ha cerrado sesion'),
(31, '28276746', '2022-04-02 22:36:49', 'Inicio Sesion'),
(32, '28276746', '2022-04-02 22:37:57', 'Ingreso al modulo Bitacora'),
(33, '28276746', '2022-04-02 22:38:06', 'Ha cerrado sesion'),
(34, '28276746', '2022-04-02 22:41:06', 'Inicio Sesion'),
(35, '28276746', '2022-04-02 22:41:09', 'Ingreso al modulo actividad'),
(36, '28276746', '2022-04-02 22:41:13', 'Ingreso al modulo Bitacora'),
(37, '28276746', '2022-04-02 22:41:32', 'Ingreso al modulo actividad'),
(38, '28276746', '2022-04-02 22:43:56', 'Ha registrado la actividad Mantenimiento de Red'),
(39, '28276746', '2022-04-02 22:44:02', 'Ingreso al modulo Bitacora'),
(40, '28276746', '2022-04-02 22:45:12', 'Ha cerrado sesion'),
(41, '28276746', '2022-04-02 22:47:14', 'Inicio Sesion'),
(42, '28276746', '2022-04-02 22:47:37', 'Ingreso al modulo actividad'),
(43, '28276746', '2022-04-02 22:47:43', 'Ingreso al modulo Bitacora'),
(44, '28276746', '2022-04-02 22:48:12', 'Ingreso al modulo Sede'),
(45, '28276746', '2022-04-02 22:48:15', 'Ha cerrado sesion'),
(46, '28276746', '2022-04-03 15:40:51', 'Inicio Sesion'),
(47, '28276746', '2022-04-03 15:41:02', 'Ingreso al modulo actividad'),
(48, '28276746', '2022-04-03 15:41:20', 'Ha cerrado sesion'),
(49, '28276746', '2022-04-03 15:51:25', 'Inicio Sesion'),
(50, '28276746', '2022-04-03 15:51:30', 'Ingreso al modulo actividad'),
(51, '28276746', '2022-04-03 15:51:58', 'Ha cerrado sesion'),
(52, '28276746', '2022-04-03 15:57:42', 'Inicio Sesion'),
(53, '28276746', '2022-04-03 15:57:44', 'Ingreso al modulo actividad'),
(54, '28276746', '2022-04-03 15:58:46', 'Ha cerrado sesion'),
(55, '28276746', '2022-04-03 16:07:25', 'Inicio Sesion'),
(56, '28276746', '2022-04-03 16:07:28', 'Ingreso al modulo actividad'),
(57, '28276746', '2022-04-03 16:08:07', 'Ingreso al modulo Bitacora'),
(58, '28276746', '2022-04-03 16:08:10', 'Ingreso al modulo actividad'),
(59, '28276746', '2022-04-03 16:08:52', 'Ha cerrado sesion'),
(60, '28276746', '2022-04-03 16:18:39', 'Inicio Sesion'),
(61, '28276746', '2022-04-03 16:18:42', 'Ingreso al modulo actividad'),
(62, '28276746', '2022-04-03 16:19:16', 'Ha cerrado sesion'),
(63, '28276746', '2022-04-03 16:24:44', 'Inicio Sesion'),
(64, '28276746', '2022-04-03 16:24:46', 'Ingreso al modulo actividad'),
(65, '28276746', '2022-04-03 16:24:57', 'Ha registrado la actividad hola'),
(66, '28276746', '2022-04-03 16:25:04', 'Ingreso al modulo Bitacora'),
(67, '28276746', '2022-04-03 16:25:06', 'Ingreso al modulo actividad'),
(68, '28276746', '2022-04-03 16:25:25', 'Ha cerrado sesion'),
(69, '28276746', '2022-04-03 16:27:18', 'Inicio Sesion'),
(70, '28276746', '2022-04-03 16:27:21', 'Ingreso al modulo actividad'),
(71, '28276746', '2022-04-03 16:28:40', 'Ha cerrado sesion'),
(72, '28276746', '2022-04-03 16:30:26', 'Inicio Sesion'),
(73, '28276746', '2022-04-03 16:30:29', 'Ingreso al modulo actividad'),
(74, '28276746', '2022-04-03 16:30:33', 'Ha eliminado la actividad hola'),
(75, '28276746', '2022-04-03 16:30:37', 'Ingreso al modulo Bitacora'),
(76, '28276746', '2022-04-03 16:33:21', 'Ha cerrado sesion'),
(77, '28276746', '2022-04-03 16:46:27', 'Inicio Sesion'),
(78, '28276746', '2022-04-03 16:46:30', 'Ingreso al modulo actividad'),
(79, '28276746', '2022-04-03 16:46:36', 'Ha registrado la actividad hola'),
(80, '28276746', '2022-04-03 16:50:06', 'Ha cerrado sesion'),
(81, '28276746', '2022-04-03 16:51:29', 'Inicio Sesion'),
(82, '28276746', '2022-04-03 16:51:31', 'Ingreso al modulo actividad'),
(83, '28276746', '2022-04-03 16:51:39', 'Ha registrado la actividad bb'),
(84, '28276746', '2022-04-03 16:51:45', 'Ha registrado la actividad bb'),
(85, '28276746', '2022-04-03 16:52:02', 'Ingreso al modulo Bitacora'),
(86, '28276746', '2022-04-03 16:52:09', 'Ha cerrado sesion'),
(87, '28276746', '2022-04-03 16:52:38', 'Inicio Sesion'),
(88, '28276746', '2022-04-03 16:52:40', 'Ingreso al modulo actividad'),
(89, '28276746', '2022-04-03 16:52:46', 'Ha registrado la actividad cccc'),
(90, '28276746', '2022-04-03 16:53:00', 'Ha cerrado sesion'),
(91, '28276746', '2022-04-03 16:54:51', 'Inicio Sesion'),
(92, '28276746', '2022-04-03 16:54:52', 'Ingreso al modulo actividad'),
(93, '28276746', '2022-04-03 16:54:59', 'Ha registrado la actividad jhhiho'),
(94, '28276746', '2022-04-03 16:56:29', 'Ha cerrado sesion'),
(95, '28276746', '2022-04-03 16:57:00', 'Inicio Sesion'),
(96, '28276746', '2022-04-03 16:57:02', 'Ingreso al modulo actividad'),
(97, '28276746', '2022-04-03 16:57:06', 'Ha registrado la actividad dfdfd'),
(98, '28276746', '2022-04-03 16:57:14', 'Ha eliminado la actividad dfdfd'),
(99, '28276746', '2022-04-03 16:57:17', 'Ha eliminado la actividad jhhiho'),
(100, '28276746', '2022-04-03 16:57:19', 'Ha eliminado la actividad cccc'),
(101, '28276746', '2022-04-03 16:57:21', 'Ha eliminado la actividad bb'),
(102, '28276746', '2022-04-03 16:57:24', 'Ha eliminado la actividad bb'),
(103, '28276746', '2022-04-03 16:57:26', 'Ha eliminado la actividad hola'),
(104, '28276746', '2022-04-03 16:57:29', 'Ha cerrado sesion'),
(105, '28276746', '2022-04-04 16:58:05', 'Inicio Sesion'),
(106, '28276746', '2022-04-04 16:58:10', 'Ingreso al modulo Departamento'),
(107, '28276746', '2022-04-04 16:59:05', 'Ha cerrado sesion'),
(108, '28276746', '2022-04-04 17:21:40', 'Inicio Sesion'),
(109, '28276746', '2022-04-04 17:21:44', 'Ingreso al modulo Departamento'),
(110, '28276746', '2022-04-04 17:22:13', 'Ha cerrado sesion'),
(111, '28276746', '2022-04-04 17:42:33', 'Inicio Sesion'),
(112, '28276746', '2022-04-04 17:42:38', 'Ingreso al modulo Departamento'),
(113, '28276746', '2022-04-04 17:44:15', 'Ha cerrado sesion'),
(114, '28276746', '2022-04-04 17:46:20', 'Inicio Sesion'),
(115, '28276746', '2022-04-04 17:46:23', 'Ingreso al modulo Departamento'),
(116, '28276746', '2022-04-04 17:47:58', 'Ha cerrado sesion'),
(117, '28276746', '2022-04-04 18:06:29', 'Inicio Sesion'),
(118, '28276746', '2022-04-04 18:06:44', 'Ingreso al modulo Departamento'),
(119, '28276746', '2022-04-04 18:06:56', 'Ha registrado el departamento Enfermeria '),
(120, '28276746', '2022-04-04 18:07:35', 'Ha cerrado sesion'),
(121, '28276746', '2022-04-04 18:09:38', 'Inicio Sesion'),
(122, '28276746', '2022-04-04 18:09:48', 'Ingreso al modulo Departamento'),
(123, '28276746', '2022-04-04 18:10:21', 'Ha registrado el departamento Almacen'),
(124, '28276746', '2022-04-04 18:12:09', 'Ha cerrado sesion'),
(125, '28276746', '2022-04-04 18:24:25', 'Inicio Sesion'),
(126, '28276746', '2022-04-04 18:24:30', 'Ingreso al modulo Departamento'),
(127, '28276746', '2022-04-04 18:24:37', 'Ha cerrado sesion'),
(128, '28276746', '2022-04-04 18:28:07', 'Inicio Sesion'),
(129, '28276746', '2022-04-04 18:28:11', 'Ingreso al modulo Departamento'),
(130, '28276746', '2022-04-04 18:28:30', 'Ha eliminado la actividad Almacen'),
(131, '28276746', '2022-04-04 18:29:40', 'Ingreso al modulo Bitacora'),
(132, '28276746', '2022-04-04 18:30:07', 'Ha cerrado sesion'),
(133, '28276746', '2022-04-04 18:42:15', 'Inicio Sesion'),
(134, '28276746', '2022-04-04 18:42:28', 'Ingreso al modulo Departamento'),
(135, '28276746', '2022-04-04 18:44:14', 'Ha eliminado la actividad Enfermeria '),
(136, '28276746', '2022-04-04 18:44:17', 'Ha eliminado la actividad Historias Medicas'),
(137, '28276746', '2022-04-04 18:44:20', 'Ha eliminado la actividad Recursos Humanos'),
(138, '28276746', '2022-04-04 18:44:31', 'Ha registrado el departamento Recursos Humanos'),
(139, '28276746', '2022-04-04 18:44:46', 'Ha cerrado sesion'),
(140, '28276746', '2022-04-07 21:06:19', 'Inicio Sesion'),
(141, '28276746', '2022-04-07 21:06:31', 'Ingreso al modulo Region'),
(142, '28276746', '2022-04-07 21:07:23', 'Ha cerrado sesion'),
(143, '28276746', '2022-04-07 21:08:19', 'Inicio Sesion'),
(144, '28276746', '2022-04-07 21:08:23', 'Ingreso al modulo Region'),
(145, '28276746', '2022-04-07 21:08:39', 'Ha cerrado sesion'),
(146, '28276746', '2022-04-07 22:32:33', 'Inicio Sesion'),
(147, '28276746', '2022-04-07 22:32:36', 'Ingreso al modulo Region'),
(148, '28276746', '2022-04-07 22:33:27', 'Ha cerrado sesion'),
(149, '28276746', '2022-04-07 22:44:48', 'Inicio Sesion'),
(150, '28276746', '2022-04-07 22:44:53', 'Ingreso al modulo Region'),
(151, '28276746', '2022-04-07 22:45:29', 'Ha registrado la region Recursos Humanos'),
(152, '28276746', '2022-04-07 22:45:44', 'Ha registrado la region Historias Medicas'),
(153, '28276746', '2022-04-07 22:46:04', 'Ha cerrado sesion'),
(154, '28276746', '2022-04-07 23:35:36', 'Inicio Sesion'),
(155, '28276746', '2022-04-07 23:35:39', 'Ingreso al modulo Region'),
(156, '28276746', '2022-04-07 23:35:51', 'Ingreso al modulo Sede'),
(157, '28276746', '2022-04-07 23:36:01', 'Ha cerrado sesion'),
(158, '28276746', '2022-04-07 23:36:33', 'Inicio Sesion'),
(159, '28276746', '2022-04-07 23:36:46', 'Ingreso al modulo Departamento'),
(160, '28276746', '2022-04-07 23:36:49', 'Ha eliminado la actividad prueba'),
(161, '28276746', '2022-04-07 23:40:12', 'Ha eliminado la actividad Recursos Humanos '),
(162, '28276746', '2022-04-07 23:41:27', 'Ha cerrado sesion'),
(163, '28276746', '2022-04-07 23:48:28', 'Inicio Sesion'),
(164, '28276746', '2022-04-07 23:48:42', 'Ingreso al modulo Departamento'),
(165, '28276746', '2022-04-07 23:48:51', 'Ha registrado el departamento hola'),
(166, '28276746', '2022-04-07 23:48:54', 'Ha eliminado la actividad hola'),
(167, '28276746', '2022-04-07 23:49:07', 'Ha registrado el departamento hola'),
(168, '28276746', '2022-04-07 23:49:20', 'Ha registrado el departamento Recursos Humanos'),
(169, '28276746', '2022-04-07 23:50:56', 'Ha registrado el departamento Enfermeria'),
(170, '28276746', '2022-04-07 23:54:52', 'Ha eliminado la actividad Enfermeria'),
(171, '28276746', '2022-04-07 23:55:09', 'Ha registrado el departamento Prueba 2'),
(172, '28276746', '2022-04-07 23:55:12', 'Ha eliminado la actividad Prueba 2'),
(173, '28276746', '2022-04-07 23:58:02', 'Ha cerrado sesion'),
(174, '28276746', '2022-04-08 00:00:29', 'Inicio Sesion'),
(175, '28276746', '2022-04-08 00:00:32', 'Ingreso al modulo Departamento'),
(176, '28276746', '2022-04-08 00:00:34', 'Ha eliminado la actividad Recursos Humanos'),
(177, '28276746', '2022-04-08 00:02:05', 'Ha cerrado sesion'),
(178, '28276746', '2022-04-08 00:07:35', 'Inicio Sesion'),
(179, '28276746', '2022-04-08 00:07:39', 'Ingreso al modulo Departamento'),
(180, '28276746', '2022-04-08 00:07:53', 'Ha registrado el departamento Recursos Humanos '),
(181, '28276746', '2022-04-08 00:08:02', 'Ha registrado el departamento Hola '),
(182, '28276746', '2022-04-08 00:08:06', 'Ha registrado el departamento sdsdsdsd'),
(183, '28276746', '2022-04-08 00:08:10', 'Ha registrado el departamento sdsds'),
(184, '28276746', '2022-04-08 00:08:17', 'Ha eliminado la actividad sdsds'),
(185, '28276746', '2022-04-08 00:08:25', 'Ha registrado el departamento hola'),
(186, '28276746', '2022-04-08 00:08:27', 'Ha eliminado la actividad hola'),
(187, '28276746', '2022-04-08 00:08:30', 'Ha eliminado la actividad sdsdsdsd'),
(188, '28276746', '2022-04-08 00:08:32', 'Ha eliminado la actividad Hola '),
(189, '28276746', '2022-04-08 00:08:35', 'Ha eliminado la actividad hola'),
(190, '28276746', '2022-04-08 00:08:39', 'Ha eliminado la actividad Recursos Humanos '),
(191, '28276746', '2022-04-08 00:08:50', 'Ha registrado el departamento Recursos Humanos'),
(192, '28276746', '2022-04-08 00:08:54', 'Ha cerrado sesion'),
(193, '28276746', '2022-04-08 00:16:58', 'Inicio Sesion'),
(194, '28276746', '2022-04-08 00:17:01', 'Ingreso al modulo Departamento'),
(195, '28276746', '2022-04-08 00:17:05', 'Ingreso al modulo actividad'),
(196, '28276746', '2022-04-08 00:17:20', 'Ha registrado la actividad Mantenimiento Preventivo'),
(197, '28276746', '2022-04-08 00:17:24', 'Ha eliminado la actividad Mantenimiento Preventivo'),
(198, '28276746', '2022-04-08 00:17:34', 'Ha registrado la actividad Mantenimiento Preventivo'),
(199, '28276746', '2022-04-08 00:18:01', 'Ha cerrado sesion'),
(200, '28276746', '2022-04-08 12:35:53', 'Inicio Sesion'),
(201, '28276746', '2022-04-08 12:35:57', 'Ingreso al modulo Sede'),
(202, '28276746', '2022-04-08 12:36:33', 'Ha cerrado sesion'),
(203, '28276746', '2022-04-08 18:15:06', 'Inicio Sesion'),
(204, '28276746', '2022-04-08 18:25:54', 'Ingreso al modulo Sede'),
(205, '28276746', '2022-04-08 18:26:19', 'Registro la sede  Hospital Juan Daza Pereira'),
(206, '28276746', '2022-04-08 18:29:45', 'Ha cerrado sesion'),
(207, '28276746', '2022-04-08 18:39:05', 'Inicio Sesion'),
(208, '28276746', '2022-04-08 18:39:08', 'Ingreso al modulo Region'),
(209, '28276746', '2022-04-08 18:39:11', 'Ingreso al modulo Sede'),
(210, '28276746', '2022-04-08 18:41:04', 'Ha cerrado sesion'),
(211, '28276746', '2022-04-08 18:43:38', 'Inicio Sesion'),
(212, '28276746', '2022-04-08 18:43:43', 'Ingreso al modulo Sede'),
(213, '28276746', '2022-04-08 18:46:30', 'Ha cerrado sesion'),
(214, '28276746', '2022-04-09 07:08:34', 'Inicio Sesion'),
(215, '28276746', '2022-04-09 07:08:43', 'Ingreso al modulo PC'),
(216, '28276746', '2022-04-09 07:08:53', 'Ha cerrado sesion'),
(217, '28276746', '2022-04-09 07:09:40', 'Inicio Sesion'),
(218, '28276746', '2022-04-09 07:09:42', 'Ingreso al modulo Bitacora'),
(219, '28276746', '2022-04-09 07:11:40', 'Ingreso al modulo actividad'),
(220, '28276746', '2022-04-09 07:11:57', 'Ingreso al modulo Sede'),
(221, '28276746', '2022-04-09 07:12:00', 'Ingreso al modulo actividad'),
(222, '28276746', '2022-04-09 07:12:31', 'Ha registrado la actividad Reparacion de Red'),
(223, '28276746', '2022-04-09 07:16:03', 'Ha registrado la actividad Actualizacion de Software'),
(224, '28276746', '2022-04-09 07:18:26', 'Ingreso al modulo Usuario'),
(225, '28276746', '2022-04-09 07:18:39', 'Ha cerrado sesion'),
(226, '28276746', '2022-04-09 08:17:38', 'Inicio Sesion'),
(227, '28276746', '2022-04-09 08:17:45', 'Ingreso al modulo Sede'),
(228, '28276746', '2022-04-09 08:18:07', 'Ha cerrado sesion'),
(229, '28276746', '2022-04-09 08:20:30', 'Inicio Sesion'),
(230, '28276746', '2022-04-09 08:20:38', 'Ingreso al modulo Sede'),
(231, '28276746', '2022-04-09 08:21:02', 'Registro la sede  Hospital Juan Daza Pereira'),
(232, '28276746', '2022-04-09 08:25:40', 'Registro la sede  Hospital Juan Daza Pereira'),
(233, '28276746', '2022-04-09 08:26:14', 'Registro la sede  Hospital Juan Daza Pereira'),
(234, '28276746', '2022-04-09 08:26:22', 'Ha cerrado sesion'),
(235, '28276746', '2022-04-09 08:33:48', 'Inicio Sesion'),
(236, '28276746', '2022-04-09 08:33:53', 'Ingreso al modulo Sede'),
(237, '28276746', '2022-04-09 08:34:11', 'Registro la sede  Hospital Juan Daza Periera'),
(238, '28276746', '2022-04-09 08:35:46', 'Registro la sede  Hospital Pastor Oropeza'),
(239, '28276746', '2022-04-09 08:36:18', 'Registro la sede  Hospital Sanidad de Barrio Union'),
(240, '28276746', '2022-04-09 08:36:43', 'Ingreso al modulo Departamento'),
(241, '28276746', '2022-04-09 08:52:16', 'Ha registrado el departamento  Enfermeria'),
(242, '28276746', '2022-04-09 08:55:00', 'Ha registrado el departamento  Historias Medicas'),
(243, '28276746', '2022-04-09 08:55:33', 'Ha cerrado sesion'),
(244, '28276746', '2022-04-09 09:00:01', 'Inicio Sesion'),
(245, '28276746', '2022-04-09 09:00:06', 'Ingreso al modulo Region'),
(246, '28276746', '2022-04-09 09:00:07', 'Ingreso al modulo Sede'),
(247, '28276746', '2022-04-09 09:00:09', 'Ingreso al modulo Departamento'),
(248, '28276746', '2022-04-09 09:00:11', 'Ingreso al modulo departamento/sede'),
(249, '28276746', '2022-04-09 09:00:22', 'Ha cerrado sesion'),
(250, '28276746', '2022-04-10 18:18:57', 'Inicio Sesion'),
(251, '28276746', '2022-04-10 18:19:03', 'Ingreso al modulo departamento/sede'),
(252, '28276746', '2022-04-10 18:19:51', 'Ha cerrado sesion'),
(253, '28276746', '2022-04-10 18:31:05', 'Inicio Sesion'),
(254, '28276746', '2022-04-10 18:31:08', 'Ingreso al modulo departamento/sede'),
(255, '28276746', '2022-04-10 18:41:22', 'Ha cerrado sesion'),
(256, '28276746', '2022-04-10 19:05:01', 'Inicio Sesion'),
(257, '28276746', '2022-04-10 19:05:06', 'Ingreso al modulo departamento/sede'),
(258, '28276746', '2022-04-10 19:05:15', 'Ha cerrado sesion'),
(259, '28276746', '2022-04-12 21:33:11', 'Inicio Sesion'),
(260, '28276746', '2022-04-12 21:33:24', 'Ingreso al modulo Usuario'),
(261, '28276746', '2022-04-12 21:33:32', 'Ha cerrado sesion'),
(262, '28276746', '2022-04-13 09:16:58', 'Inicio Sesion'),
(263, '28276746', '2022-04-13 09:17:14', 'Ingreso al modulo Bitacora'),
(264, '28276746', '2022-04-13 09:17:47', 'Ha cerrado sesion'),
(265, '28276746', '2022-04-13 12:26:08', 'Inicio Sesion'),
(266, '28276746', '2022-04-13 12:26:19', 'Ingreso al modulo Sede'),
(267, '28276746', '2022-04-13 12:26:46', 'Ingreso al modulo departamento/sede'),
(268, '28276746', '2022-04-13 12:27:32', 'Ingreso al modulo Sede'),
(269, '28276746', '2022-04-13 12:27:47', 'Ha cerrado sesion'),
(270, '28276746', '2022-04-13 12:43:04', 'Inicio Sesion'),
(271, '28276746', '2022-04-13 12:43:08', 'Ingreso al modulo Sede'),
(272, '28276746', '2022-04-13 12:43:25', 'Ha cerrado sesion'),
(273, '28276746', '2022-04-13 13:29:24', 'Inicio Sesion'),
(274, '28276746', '2022-04-13 13:29:29', 'Ingreso al modulo Departamento'),
(275, '28276746', '2022-04-13 13:29:51', 'Ha cerrado sesion'),
(276, '28276746', '2022-04-13 15:28:38', 'Inicio Sesion'),
(277, '28276746', '2022-04-13 15:28:52', 'Ingreso al modulo departamento/sede'),
(278, '28276746', '2022-04-13 15:29:14', 'Ha cerrado sesion'),
(279, '28276746', '2022-04-13 15:33:55', 'Inicio Sesion'),
(280, '28276746', '2022-04-13 15:33:57', 'Ingreso al modulo departamento/sede'),
(281, '28276746', '2022-04-13 15:34:41', 'Ha cerrado sesion'),
(282, '28276746', '2022-04-13 15:40:09', 'Inicio Sesion'),
(283, '28276746', '2022-04-13 15:40:21', 'Ingreso al modulo departamento/sede'),
(284, '28276746', '2022-04-13 15:40:24', 'Ingreso al modulo Departamento'),
(285, '28276746', '2022-04-13 15:40:32', 'Ingreso al modulo Bitacora'),
(286, '28276746', '2022-04-13 15:41:21', 'Ingreso al modulo Departamento'),
(287, '28276746', '2022-04-13 15:41:27', 'Ingreso al modulo Sede'),
(288, '28276746', '2022-04-13 15:41:29', 'Ingreso al modulo departamento/sede'),
(289, '28276746', '2022-04-13 15:42:06', 'Ha cerrado sesion'),
(290, '28276746', '2022-04-13 16:39:53', 'Inicio Sesion'),
(291, '28276746', '2022-04-13 16:40:02', 'Ingreso al modulo actividad'),
(292, '28276746', '2022-04-13 16:40:11', 'Ha registrado la actividad d'),
(293, '28276746', '2022-04-13 16:40:27', 'Ha eliminado la actividad d'),
(294, '28276746', '2022-04-13 16:40:31', 'Ha cerrado sesion'),
(295, '28276746', '2022-04-13 16:46:54', 'Inicio Sesion'),
(296, '28276746', '2022-04-13 16:46:57', 'Ingreso al modulo actividad'),
(297, '28276746', '2022-04-13 16:47:05', 'Ingreso al modulo Region'),
(298, '28276746', '2022-04-13 17:02:40', 'Ha cerrado sesion'),
(299, '28276746', '2022-04-15 11:56:29', 'Inicio Sesion'),
(300, '28276746', '2022-04-15 11:56:32', 'Ingreso al modulo Sede'),
(301, '28276746', '2022-04-15 11:56:36', 'Ingreso al modulo departamento/sede'),
(302, '28276746', '2022-04-15 11:57:03', 'Ha cerrado sesion'),
(303, '28276746', '2022-04-15 16:21:33', 'Inicio Sesion'),
(304, '28276746', '2022-04-15 16:21:38', 'Ingreso al modulo Sede'),
(305, '28276746', '2022-04-15 16:22:36', 'Ha cerrado sesion'),
(306, '28276746', '2022-04-15 16:39:10', 'Inicio Sesion'),
(307, '28276746', '2022-04-15 16:39:24', 'Ingreso al modulo Usuario'),
(308, '28276746', '2022-04-15 16:39:43', 'Ha cerrado sesion'),
(309, '28276746', '2022-04-15 16:40:42', 'Inicio Sesion'),
(310, '28276746', '2022-04-15 16:40:45', 'Ingreso al modulo Usuario'),
(311, '28276746', '2022-04-15 16:40:49', 'Ha cerrado sesion'),
(312, '28276746', '2022-04-15 16:45:50', 'Inicio Sesion'),
(313, '28276746', '2022-04-15 16:45:59', 'Ingreso al modulo Departamento'),
(314, '28276746', '2022-04-15 16:51:42', 'Ha cerrado sesion'),
(315, '28276746', '2022-04-15 18:28:09', 'Inicio Sesion'),
(316, '28276746', '2022-04-15 18:28:17', 'Ingreso al modulo departamento/sede'),
(317, '28276746', '2022-04-15 18:28:23', 'Ingreso al modulo Region'),
(318, '28276746', '2022-04-15 18:29:31', 'Ingreso al modulo Region'),
(319, '28276746', '2022-04-15 18:29:33', 'Ingreso al modulo Departamento'),
(320, '28276746', '2022-04-15 18:29:42', 'Ingreso al modulo departamento/sede'),
(321, '28276746', '2022-04-15 18:47:39', 'Ha cerrado sesion'),
(322, '28276746', '2022-04-15 19:19:09', 'Inicio Sesion'),
(323, '28276746', '2022-04-15 19:27:24', 'Ingreso al modulo departamento/sede'),
(324, '28276746', '2022-04-15 19:30:09', 'Ha cerrado sesion'),
(325, '28276746', '2022-04-15 19:32:06', 'Inicio Sesion'),
(326, '28276746', '2022-04-15 19:32:12', 'Ingreso al modulo departamento/sede'),
(327, '28276746', '2022-04-15 19:33:39', 'Ha cerrado sesion'),
(328, '28276746', '2022-04-15 20:06:39', 'Inicio Sesion'),
(329, '28276746', '2022-04-15 20:06:42', 'Ingreso al modulo departamento/sede'),
(330, '28276746', '2022-04-15 20:07:13', 'Ha cerrado sesion'),
(331, '28276746', '2022-04-15 20:22:53', 'Inicio Sesion'),
(332, '28276746', '2022-04-15 20:22:55', 'Ingreso al modulo departamento/sede'),
(333, '28276746', '2022-04-15 20:23:18', 'Ingreso al modulo Departamento'),
(334, '28276746', '2022-04-15 20:23:24', 'Ingreso al modulo departamento/sede'),
(335, '28276746', '2022-04-15 20:26:49', 'Ha cerrado sesion'),
(336, '28276746', '2022-04-15 20:28:40', 'Inicio Sesion'),
(337, '28276746', '2022-04-15 20:28:43', 'Ingreso al modulo departamento/sede'),
(338, '28276746', '2022-04-15 20:36:52', 'Ha cerrado sesion'),
(339, '28276746', '2022-04-15 20:41:57', 'Inicio Sesion'),
(340, '28276746', '2022-04-15 20:42:00', 'Ingreso al modulo departamento/sede'),
(341, '28276746', '2022-04-15 20:42:56', 'Ha cerrado sesion'),
(342, '28276746', '2022-04-15 20:46:43', 'Inicio Sesion'),
(343, '28276746', '2022-04-15 20:46:44', 'Ingreso al modulo departamento/sede'),
(344, '28276746', '2022-04-15 20:46:57', 'Ingreso al modulo Sede'),
(345, '28276746', '2022-04-15 20:46:59', 'Ingreso al modulo departamento/sede'),
(346, '28276746', '2022-04-15 20:47:14', 'Ha cerrado sesion'),
(347, '28276746', '2022-04-15 20:54:02', 'Inicio Sesion'),
(348, '28276746', '2022-04-15 20:54:04', 'Ingreso al modulo departamento/sede'),
(349, '28276746', '2022-04-15 20:55:05', 'Ingreso al modulo Region'),
(350, '28276746', '2022-04-15 20:55:07', 'Ingreso al modulo Sede'),
(351, '28276746', '2022-04-15 20:58:47', 'Ingreso al modulo Departamento'),
(352, '28276746', '2022-04-15 20:58:50', 'Ingreso al modulo Region'),
(353, '28276746', '2022-04-15 20:58:53', 'Ingreso al modulo Sede'),
(354, '28276746', '2022-04-15 20:58:58', 'Ingreso al modulo PC'),
(355, '28276746', '2022-04-15 20:59:02', 'Ha cerrado sesion'),
(356, '28276746', '2022-04-15 21:22:35', 'Inicio Sesion'),
(357, '28276746', '2022-04-15 21:23:51', 'Ingreso al modulo departamento/sede'),
(358, '28276746', '2022-04-15 21:25:36', 'Ha cerrado sesion'),
(359, '28276746', '2022-04-15 21:34:47', 'Inicio Sesion'),
(360, '28276746', '2022-04-15 21:34:49', 'Ingreso al modulo departamento/sede'),
(361, '28276746', '2022-04-15 21:35:32', 'Ha cerrado sesion'),
(362, '28276746', '2022-04-15 21:37:04', 'Inicio Sesion'),
(363, '28276746', '2022-04-15 21:37:06', 'Ingreso al modulo departamento/sede'),
(364, '28276746', '2022-04-15 21:39:45', 'Ingreso al modulo Departamento'),
(365, '28276746', '2022-04-15 21:39:46', 'Ingreso al modulo departamento/sede'),
(366, '28276746', '2022-04-15 21:40:23', 'Ingreso al modulo Sede'),
(367, '28276746', '2022-04-15 21:40:24', 'Ingreso al modulo Region'),
(368, '28276746', '2022-04-15 21:40:26', 'Ingreso al modulo departamento/sede'),
(369, '28276746', '2022-04-15 21:41:27', 'Ha cerrado sesion'),
(370, '28276746', '2022-04-15 21:44:50', 'Inicio Sesion'),
(371, '28276746', '2022-04-15 21:44:52', 'Ingreso al modulo departamento/sede'),
(372, '28276746', '2022-04-15 21:47:11', 'Ha cerrado sesion'),
(373, '28276746', '2022-04-15 21:51:46', 'Inicio Sesion'),
(374, '28276746', '2022-04-15 21:51:48', 'Ingreso al modulo departamento/sede'),
(375, '28276746', '2022-04-15 21:52:22', 'Ingreso al modulo Sede'),
(376, '28276746', '2022-04-15 21:52:30', 'Ingreso al modulo Departamento'),
(377, '28276746', '2022-04-15 21:53:04', 'Ha registrado el departamento  Farmacia'),
(378, '28276746', '2022-04-15 21:53:14', 'Ha registrado el departamento  Traumatologia'),
(379, '28276746', '2022-04-15 21:53:23', 'Ha registrado el departamento  Psiquiatria'),
(380, '28276746', '2022-04-15 21:53:36', 'Ha registrado el departamento  Medicina General'),
(381, '28276746', '2022-04-15 21:53:48', 'Ha registrado el departamento  Emergencia'),
(382, '28276746', '2022-04-15 21:53:52', 'Ingreso al modulo departamento/sede'),
(383, '28276746', '2022-04-15 21:55:02', 'Ingreso al modulo Region'),
(384, '28276746', '2022-04-15 21:55:31', 'Ha cerrado sesion'),
(385, '28276746', '2022-04-15 22:05:00', 'Inicio Sesion'),
(386, '28276746', '2022-04-15 22:05:13', 'Ingreso al modulo Sede'),
(387, '28276746', '2022-04-15 22:05:29', 'Ingreso al modulo Departamento'),
(388, '28276746', '2022-04-15 22:05:33', 'Ingreso al modulo departamento/sede'),
(389, '28276746', '2022-04-15 22:05:38', 'Ingreso al modulo Region'),
(390, '28276746', '2022-04-15 22:05:52', 'Ingreso al modulo actividad'),
(391, '28276746', '2022-04-15 22:05:59', 'Ingreso al modulo Bitacora'),
(392, '28276746', '2022-04-15 22:06:46', 'Ha cerrado sesion'),
(393, '28276746', '2022-04-17 15:52:58', 'Inicio Sesion'),
(394, '28276746', '2022-04-17 15:53:05', 'Ingreso al modulo Servicio'),
(395, '28276746', '2022-04-17 15:54:20', 'Ingreso al modulo Usuario'),
(396, '28276746', '2022-04-17 15:54:31', 'Ha cerrado sesion'),
(397, '28276746', '2022-04-17 15:54:53', 'Inicio Sesion'),
(398, '28276746', '2022-04-17 15:54:58', 'Ingreso al modulo Sede'),
(399, '28276746', '2022-04-17 15:55:01', 'Ingreso al modulo departamento/sede'),
(400, '28276746', '2022-04-17 15:55:02', 'Ingreso al modulo Servicio'),
(401, '28276746', '2022-04-17 15:55:10', 'Ingreso al modulo Sede'),
(402, '28276746', '2022-04-17 15:55:15', 'Ingreso al modulo Region'),
(403, '28276746', '2022-04-17 15:55:17', 'Ingreso al modulo Departamento'),
(404, '28276746', '2022-04-17 15:55:21', 'Ha cerrado sesion'),
(405, '28276746', '2022-04-17 16:01:43', 'Inicio Sesion'),
(406, '28276746', '2022-04-17 16:01:49', 'Ingreso al modulo Servicio'),
(407, '28276746', '2022-04-17 16:02:43', 'Ha cerrado sesion'),
(408, '28276746', '2022-04-17 16:06:48', 'Inicio Sesion'),
(409, '28276746', '2022-04-17 16:06:55', 'Ingreso al modulo PC'),
(410, '28276746', '2022-04-17 16:07:00', 'Ha cerrado sesion'),
(411, '28276746', '2022-04-17 16:07:56', 'Inicio Sesion'),
(412, '28276746', '2022-04-17 16:08:11', 'Ingreso al modulo Servicio'),
(413, '28276746', '2022-04-17 16:09:18', 'Ha cerrado sesion'),
(414, '28276746', '2022-04-17 16:26:05', 'Inicio Sesion'),
(415, '28276746', '2022-04-17 16:30:27', 'Ingreso al modulo Servicio'),
(416, '28276746', '2022-04-17 16:36:04', 'Ha cerrado sesion'),
(417, '28276746', '2022-04-17 18:38:05', 'Inicio Sesion'),
(418, '28276746', '2022-04-17 18:38:08', 'Ingreso al modulo departamento/sede'),
(419, '28276746', '2022-04-17 18:38:11', 'Ingreso al modulo Servicio'),
(420, '28276746', '2022-04-17 18:39:46', 'Ha cerrado sesion'),
(421, '28276746', '2022-04-17 18:40:39', 'Inicio Sesion'),
(422, '28276746', '2022-04-17 18:40:54', 'Ingreso al modulo Servicio'),
(423, '28276746', '2022-04-17 18:48:08', 'Ha cerrado sesion'),
(424, '28276746', '2022-04-17 19:00:57', 'Inicio Sesion'),
(425, '28276746', '2022-04-17 19:00:59', 'Ingreso al modulo Servicio'),
(426, '28276746', '2022-04-17 19:21:37', 'Ha cerrado sesion'),
(427, '28276746', '2022-04-24 17:41:08', 'Inicio Sesion'),
(428, '28276746', '2022-04-24 17:41:12', 'Ingreso al modulo actividad'),
(429, '28276746', '2022-04-24 17:41:22', 'Ha deshabilitadola actividad Actualizacion de Software'),
(430, '28276746', '2022-04-24 17:41:55', 'Ha cerrado sesion'),
(431, '28276746', '2022-04-24 17:50:55', 'Inicio Sesion'),
(432, '28276746', '2022-04-24 17:50:57', 'Ingreso al modulo actividad'),
(433, '28276746', '2022-04-24 17:51:03', 'Ha deshabilitadola actividad Actualizacion de Software'),
(434, '28276746', '2022-04-24 17:51:45', 'Ha cerrado sesion'),
(435, '28276746', '2022-04-24 18:07:59', 'Inicio Sesion'),
(436, '28276746', '2022-04-24 18:08:01', 'Ingreso al modulo actividad'),
(437, '28276746', '2022-04-24 18:08:06', 'Ha deshabilitadola actividad Actualizacion de Software'),
(438, '28276746', '2022-04-24 18:08:32', 'Ha cerrado sesion'),
(439, '28276746', '2022-04-24 18:12:21', 'Inicio Sesion'),
(440, '28276746', '2022-04-24 18:12:23', 'Ingreso al modulo actividad'),
(441, '28276746', '2022-04-24 18:12:27', 'Ha deshabilitadola actividad Actualizacion de Software'),
(442, '28276746', '2022-04-24 18:13:10', 'Ha cerrado sesion'),
(443, '28276746', '2022-04-24 18:13:56', 'Inicio Sesion'),
(444, '28276746', '2022-04-24 18:14:02', 'Ingreso al modulo actividad'),
(445, '28276746', '2022-04-24 18:14:08', 'Ha deshabilitadola actividad Actualizacion de Software'),
(446, '28276746', '2022-04-24 18:17:25', 'Ha cerrado sesion'),
(447, '28276746', '2022-04-24 18:25:54', 'Inicio Sesion'),
(448, '28276746', '2022-04-24 18:26:09', 'Ha cerrado sesion'),
(449, '28276746', '2022-04-24 18:37:35', 'Inicio Sesion'),
(450, '28276746', '2022-04-24 18:37:40', 'Ingreso al modulo actividad'),
(451, '28276746', '2022-04-24 18:37:43', 'Ha deshabilitadola actividad Actualizacion de Software'),
(452, '28276746', '2022-04-24 18:37:50', 'Ingreso al modulo Servicio'),
(453, '28276746', '2022-04-24 18:38:05', 'Ingreso al modulo actividad'),
(454, '28276746', '2022-04-24 18:38:09', 'Ha habiliadola actividad Actualizacion de Software'),
(455, '28276746', '2022-04-24 18:38:12', 'Ha deshabilitadola actividad Mantenimiento Preventivo'),
(456, '28276746', '2022-04-24 18:38:16', 'Ingreso al modulo Servicio'),
(457, '28276746', '2022-04-24 18:38:28', 'Ingreso al modulo actividad'),
(458, '28276746', '2022-04-24 18:38:32', 'Ha habiliadola actividad Mantenimiento Preventivo'),
(459, '28276746', '2022-04-24 18:38:36', 'Ha cerrado sesion'),
(460, '28276746', '2022-04-24 19:00:41', 'Inicio Sesion'),
(461, '28276746', '2022-04-24 19:00:44', 'Ingreso al modulo actividad'),
(462, '28276746', '2022-04-24 19:00:47', 'Ingreso al modulo Servicio'),
(463, '28276746', '2022-04-24 19:00:55', 'Ingreso al modulo Usuario'),
(464, '28276746', '2022-04-24 19:00:59', 'Ha cerrado sesion'),
(465, '28276746', '2022-04-24 20:12:30', 'Inicio Sesion'),
(466, '28276746', '2022-04-24 20:12:36', 'Ingreso al modulo departamento/sede'),
(467, '28276746', '2022-04-24 20:12:50', 'Ingreso al modulo Servicio'),
(468, '28276746', '2022-04-24 20:13:11', 'Ingreso al modulo Departamento'),
(469, '28276746', '2022-04-24 20:13:19', 'Ha cerrado sesion'),
(470, '28276746', '2022-04-24 20:32:17', 'Inicio Sesion'),
(471, '28276746', '2022-04-24 20:32:22', 'Ingreso al modulo departamento/sede'),
(472, '28276746', '2022-04-24 20:32:35', 'Ha Habilito el departamento/sede HJDPEME'),
(473, '28276746', '2022-04-24 20:32:40', 'Ha Habilito el departamento/sede HJDPENF'),
(474, '28276746', '2022-04-24 20:32:42', 'Ha Habilito el departamento/sede HJDPFAR'),
(475, '28276746', '2022-04-24 20:32:44', 'Ha Habilito el departamento/sede HJDPHM'),
(476, '28276746', '2022-04-24 20:32:46', 'Ha Habilito el departamento/sede HJDPMG'),
(477, '28276746', '2022-04-24 20:32:48', 'Ha Habilito el departamento/sede HJDPPSI'),
(478, '28276746', '2022-04-24 20:32:51', 'Ha Habilito el departamento/sede HJDPRH'),
(479, '28276746', '2022-04-24 20:32:53', 'Ha Habilito el departamento/sede HJDPTRA'),
(480, '28276746', '2022-04-24 20:34:36', 'Ingreso al modulo Servicio'),
(481, '28276746', '2022-04-24 20:35:14', 'Ha cerrado sesion'),
(482, '28276746', '2022-04-24 20:45:34', 'Inicio Sesion'),
(483, '28276746', '2022-04-24 20:45:51', 'Ingreso al modulo Servicio'),
(484, '28276746', '2022-04-24 20:45:53', 'Ingreso al modulo PC'),
(485, '28276746', '2022-04-24 20:45:57', 'Ha cerrado sesion'),
(486, '28276746', '2022-04-24 20:46:40', 'Inicio Sesion'),
(487, '28276746', '2022-04-24 20:46:53', 'Ingreso al modulo Servicio'),
(488, '28276746', '2022-04-24 20:47:13', 'Ingreso al modulo departamento/sede'),
(489, '28276746', '2022-04-24 20:47:20', 'Ha Deshabilito el departamento/sede HJDPTRA'),
(490, '28276746', '2022-04-24 20:47:25', 'Ingreso al modulo Servicio'),
(491, '28276746', '2022-04-24 20:48:26', 'Ha cerrado sesion'),
(492, '28276746', '2022-04-24 21:03:28', 'Inicio Sesion'),
(493, '28276746', '2022-04-24 21:08:24', 'Ha cerrado sesion'),
(494, '28276746', '2022-04-25 15:43:26', 'Inicio Sesion'),
(495, '28276746', '2022-04-25 15:43:30', 'Ingreso al modulo actividad'),
(496, '28276746', '2022-04-25 15:43:33', 'Ingreso al modulo Servicio'),
(497, '28276746', '2022-04-25 15:43:36', 'Ingreso al modulo departamento/sede'),
(498, '28276746', '2022-04-25 15:43:47', 'Ha Habilito el departamento/sede HJDPTRA'),
(499, '28276746', '2022-04-25 15:43:49', 'Ingreso al modulo departamento/sede'),
(500, '28276746', '2022-04-25 15:43:52', 'Ingreso al modulo Region'),
(501, '28276746', '2022-04-25 15:43:55', 'Ingreso al modulo Sede'),
(502, '28276746', '2022-04-25 15:44:50', 'Ingreso al modulo Departamento'),
(503, '28276746', '2022-04-25 15:44:59', 'Ha cerrado sesion'),
(504, '28276746', '2022-04-25 16:52:16', 'Inicio Sesion'),
(505, '28276746', '2022-04-25 16:53:03', 'Ingreso al modulo Departamento'),
(506, '28276746', '2022-04-25 16:53:12', 'Ha cerrado sesion'),
(507, '28276746', '2022-04-25 17:01:43', 'Inicio Sesion'),
(508, '28276746', '2022-04-25 17:01:46', 'Ingreso al modulo Departamento'),
(509, '28276746', '2022-04-25 17:01:50', 'Ha Habilito la actividad Emergencia'),
(510, '28276746', '2022-04-25 17:01:53', 'Ha Habilito la actividad Medicina General'),
(511, '28276746', '2022-04-25 17:01:55', 'Ha Habilito la actividad Psiquiatria'),
(512, '28276746', '2022-04-25 17:02:02', 'Ha Habilito la actividad Historias Medicas'),
(513, '28276746', '2022-04-25 17:02:05', 'Ha Habilito la actividad Farmacia'),
(514, '28276746', '2022-04-25 17:02:07', 'Ha Habilito la actividad Traumatologia'),
(515, '28276746', '2022-04-25 17:02:11', 'Ingreso al modulo departamento/sede'),
(516, '28276746', '2022-04-25 17:02:24', 'Ingreso al modulo Departamento'),
(517, '28276746', '2022-04-25 17:04:20', 'Ingreso al modulo departamento/sede'),
(518, '28276746', '2022-04-25 17:04:28', 'Ingreso al modulo Departamento'),
(519, '28276746', '2022-04-25 17:04:31', 'Ha Deshabilito la actividad Historias Medicas'),
(520, '28276746', '2022-04-25 17:04:35', 'Ha Deshabilito la actividad Farmacia'),
(521, '28276746', '2022-04-25 17:04:37', 'Ha Deshabilito la actividad Traumatologia'),
(522, '28276746', '2022-04-25 17:04:39', 'Ha Deshabilito la actividad Psiquiatria'),
(523, '28276746', '2022-04-25 17:04:42', 'Ha Deshabilito la actividad Medicina General'),
(524, '28276746', '2022-04-25 17:04:44', 'Ha Deshabilito la actividad Emergencia'),
(525, '28276746', '2022-04-25 17:04:46', 'Ingreso al modulo departamento/sede'),
(526, '28276746', '2022-04-25 17:07:15', 'Ha Deshabilito el departamento/sede HJDPTRA'),
(527, '28276746', '2022-04-25 17:07:18', 'Ha Deshabilito el departamento/sede HJDPRH'),
(528, '28276746', '2022-04-25 17:07:21', 'Ha Habilito el departamento/sede HJDPRH'),
(529, '28276746', '2022-04-25 17:07:24', 'Ha Habilito el departamento/sede HJDPTRA'),
(530, '28276746', '2022-04-25 17:07:28', 'Ingreso al modulo Region'),
(531, '28276746', '2022-04-25 17:07:34', 'Ingreso al modulo Region'),
(532, '28276746', '2022-04-25 17:07:35', 'Ingreso al modulo Departamento'),
(533, '28276746', '2022-04-25 17:07:37', 'Ingreso al modulo departamento/sede'),
(534, '28276746', '2022-04-25 17:07:41', 'Ingreso al modulo Region'),
(535, '28276746', '2022-04-25 17:07:43', 'Ingreso al modulo Sede'),
(536, '28276746', '2022-04-25 17:07:55', 'Ingreso al modulo Region'),
(537, '28276746', '2022-04-25 17:07:58', 'Ha cerrado sesion'),
(538, '28276746', '2022-04-25 17:10:34', 'Inicio Sesion'),
(539, '28276746', '2022-04-25 17:10:37', 'Ingreso al modulo Region'),
(540, '28276746', '2022-04-25 17:10:41', 'Ingreso al modulo Sede'),
(541, '28276746', '2022-04-25 17:10:46', 'Ingreso al modulo departamento/sede'),
(542, '28276746', '2022-04-25 17:10:50', 'Ha cerrado sesion'),
(543, '28276746', '2022-04-25 17:11:10', 'Inicio Sesion'),
(544, '28276746', '2022-04-25 17:11:13', 'Ingreso al modulo departamento/sede'),
(545, '28276746', '2022-04-25 17:11:14', 'Ingreso al modulo PC'),
(546, '28276746', '2022-04-25 17:11:18', 'Ha cerrado sesion'),
(547, '28276746', '2022-04-25 17:17:01', 'Inicio Sesion'),
(548, '28276746', '2022-04-25 17:17:05', 'Ingreso al modulo Departamento'),
(549, '28276746', '2022-04-25 17:17:19', 'Ha cerrado sesion'),
(550, '28276746', '2022-04-25 17:20:07', 'Inicio Sesion'),
(551, '28276746', '2022-04-25 17:20:14', 'Ingreso al modulo Sede'),
(552, '28276746', '2022-04-25 17:20:25', 'Ha cerrado sesion'),
(553, '28276746', '2022-04-25 17:21:04', 'Inicio Sesion'),
(554, '28276746', '2022-04-25 17:21:15', 'Ingreso al modulo departamento/sede'),
(555, '28276746', '2022-04-25 17:21:19', 'Ingreso al modulo Sede'),
(556, '28276746', '2022-04-25 17:21:23', 'Ingreso al modulo Servicio'),
(557, '28276746', '2022-04-25 17:21:44', 'Ha cerrado sesion'),
(558, '28276746', '2022-04-25 17:32:21', 'Inicio Sesion'),
(559, '28276746', '2022-04-25 17:32:23', 'Ingreso al modulo Servicio'),
(560, '28276746', '2022-04-25 17:32:38', 'Ha cerrado sesion'),
(561, '28276746', '2022-04-25 17:39:37', 'Inicio Sesion'),
(562, '28276746', '2022-04-25 17:39:40', 'Ingreso al modulo Sede'),
(563, '28276746', '2022-04-25 17:39:43', 'Ingreso al modulo Region'),
(564, '28276746', '2022-04-25 17:39:46', 'Ingreso al modulo Servicio'),
(565, '28276746', '2022-04-25 17:39:58', 'Ha cerrado sesion'),
(566, '28276746', '2022-04-25 17:45:17', 'Inicio Sesion'),
(567, '28276746', '2022-04-25 17:45:20', 'Ingreso al modulo Servicio'),
(568, '28276746', '2022-04-25 17:45:32', 'Ingreso al modulo actividad'),
(569, '28276746', '2022-04-25 17:45:52', 'Ingreso al modulo Servicio'),
(570, '28276746', '2022-04-25 17:46:15', 'Ingreso al modulo Servicio'),
(571, '28276746', '2022-04-25 17:46:53', 'Ingreso al modulo Sede'),
(572, '28276746', '2022-04-25 17:47:16', 'Ha cerrado sesion'),
(573, '28276746', '2022-04-25 17:48:02', 'Inicio Sesion'),
(574, '28276746', '2022-04-25 17:48:08', 'Ingreso al modulo Servicio'),
(575, '28276746', '2022-04-25 17:49:54', 'Ingreso al modulo Servicio'),
(576, '28276746', '2022-04-25 17:49:56', 'Ingreso al modulo Departamento'),
(577, '28276746', '2022-04-25 17:50:00', 'Ingreso al modulo Usuario'),
(578, '28276746', '2022-04-25 17:50:04', 'Ha cerrado sesion'),
(579, '28276746', '2022-04-25 18:00:44', 'Inicio Sesion'),
(580, '28276746', '2022-04-25 18:00:46', 'Ingreso al modulo Sede'),
(581, '28276746', '2022-04-25 18:00:51', 'Ingreso al modulo Departamento'),
(582, '28276746', '2022-04-25 18:00:55', 'Ingreso al modulo departamento/sede'),
(583, '28276746', '2022-04-25 18:00:58', 'Ingreso al modulo Region'),
(584, '28276746', '2022-04-25 18:01:03', 'Ha cerrado sesion'),
(585, '28276746', '2022-04-25 18:59:19', 'Inicio Sesion'),
(586, '28276746', '2022-04-25 18:59:23', 'Ingreso al modulo actividad'),
(587, '28276746', '2022-04-25 18:59:28', 'Ha deshabilitadola actividad Actualizacion de Software'),
(588, '28276746', '2022-04-25 18:59:30', 'Ingreso al modulo Bitacora'),
(589, '28276746', '2022-04-25 19:00:14', 'Ingreso al modulo Region'),
(590, '28276746', '2022-04-25 19:00:21', 'Ha Habilito la region occidente'),
(591, '28276746', '2022-04-25 19:00:55', 'Ha cerrado sesion'),
(592, '28276746', '2022-04-25 19:07:44', 'Inicio Sesion'),
(593, '28276746', '2022-04-25 19:08:52', 'Ingreso al modulo Region'),
(594, '28276746', '2022-04-25 19:08:55', 'Ha Habilito la region occidente'),
(595, '28276746', '2022-04-25 19:12:26', 'Ha cerrado sesion'),
(596, '28276746', '2022-04-25 19:14:54', 'Inicio Sesion'),
(597, '28276746', '2022-04-25 19:14:57', 'Ingreso al modulo Region'),
(598, '28276746', '2022-04-25 19:15:00', 'Ha Habilito la region occidente'),
(599, '28276746', '2022-04-25 19:15:04', 'Ha Deshabilito la region occidente'),
(600, '28276746', '2022-04-25 19:15:07', 'Ha Habilito la region occidente'),
(601, '28276746', '2022-04-25 19:15:10', 'Ingreso al modulo Bitacora'),
(602, '28276746', '2022-04-25 19:15:29', 'Ha cerrado sesion'),
(603, '28276746', '2022-04-25 20:27:11', 'Inicio Sesion'),
(604, '28276746', '2022-04-25 20:29:33', 'Ingreso al modulo Sede'),
(605, '28276746', '2022-04-25 20:39:48', 'Ha cerrado sesion'),
(606, '28276746', '2022-04-25 20:40:35', 'Inicio Sesion'),
(607, '28276746', '2022-04-25 20:40:38', 'Ingreso al modulo Sede'),
(608, '28276746', '2022-04-25 20:40:50', 'Ha cerrado sesion'),
(609, '28276746', '2022-04-25 20:43:26', 'Inicio Sesion'),
(610, '28276746', '2022-04-25 20:43:52', 'Ingreso al modulo Sede'),
(611, '28276746', '2022-04-25 20:50:50', 'Ha cerrado sesion'),
(612, '28276746', '2022-04-25 21:24:32', 'Inicio Sesion'),
(613, '28276746', '2022-04-25 21:27:55', 'Ingreso al modulo Sede'),
(614, '28276746', '2022-04-25 21:27:59', 'Ha Habilitadola sede Hospital Juan Daza Periera'),
(615, '28276746', '2022-04-25 21:29:53', 'Ha cerrado sesion'),
(616, '28276746', '2022-04-25 21:31:48', 'Inicio Sesion'),
(617, '28276746', '2022-04-25 21:31:53', 'Ingreso al modulo Sede'),
(618, '28276746', '2022-04-25 21:32:00', 'Ha Habilitadola sede Hospital Juan Daza Periera'),
(619, '28276746', '2022-04-25 21:32:04', 'Ha Habilitadola sede Hospital Pastor Oropeza'),
(620, '28276746', '2022-04-25 21:32:06', 'Ha Habilitadola sede Hospital Sanidad de Barrio Union'),
(621, '28276746', '2022-04-25 21:32:11', 'Ha cerrado sesion'),
(622, '28276746', '2022-04-26 21:21:38', 'Inicio Sesion'),
(623, '28276746', '2022-04-26 21:21:43', 'Ingreso al modulo Servicio'),
(624, '28276746', '2022-04-26 21:23:02', 'Ha registrado el reporte de actividad numero= 0'),
(625, '28276746', '2022-04-26 21:24:00', 'Ha cerrado sesion'),
(626, '28276746', '2022-04-26 21:36:56', 'Inicio Sesion'),
(627, '28276746', '2022-04-26 21:37:04', 'Ingreso al modulo Servicio'),
(628, '28276746', '2022-04-26 21:37:27', 'Ha registrado el reporte de actividad numero= 2'),
(629, '28276746', '2022-04-26 21:38:02', 'Ha cerrado sesion'),
(630, '28276746', '2022-04-26 22:02:49', 'Inicio Sesion'),
(631, '28276746', '2022-04-26 22:02:54', 'Ingreso al modulo Servicio'),
(632, '28276746', '2022-04-26 22:05:14', 'Ha cerrado sesion'),
(633, '28276746', '2022-04-26 22:07:01', 'Inicio Sesion'),
(634, '28276746', '2022-04-26 22:07:09', 'Ingreso al modulo Servicio'),
(635, '28276746', '2022-04-26 22:08:11', 'Ha registrado el reporte de actividad numero= 3'),
(636, '28276746', '2022-04-26 22:21:42', 'Ingreso al modulo PC'),
(637, '28276746', '2022-04-26 22:21:48', 'Ha cerrado sesion'),
(638, '28276746', '2022-04-26 22:27:30', 'Inicio Sesion'),
(639, '28276746', '2022-04-26 22:27:33', 'Ingreso al modulo Bitacora'),
(640, '28276746', '2022-04-26 22:27:37', 'Ingreso al modulo Sede'),
(641, '28276746', '2022-04-26 22:27:39', 'Ingreso al modulo Departamento'),
(642, '28276746', '2022-04-26 22:27:47', 'Ha Habilito el departamento Recursos Humanos'),
(643, '28276746', '2022-04-26 22:27:49', 'Ha Habilito el departamento Enfermeria'),
(644, '28276746', '2022-04-26 22:27:51', 'Ha Habilito el departamento Historias Medicas'),
(645, '28276746', '2022-04-26 22:27:53', 'Ha Habilito el departamento Farmacia'),
(646, '28276746', '2022-04-26 22:27:55', 'Ha Habilito el departamento Psiquiatria'),
(647, '28276746', '2022-04-26 22:27:57', 'Ha Habilito el departamento Traumatologia'),
(648, '28276746', '2022-04-26 22:27:59', 'Ha Habilito el departamento Emergencia'),
(649, '28276746', '2022-04-26 22:28:01', 'Ha Habilito el departamento Medicina General'),
(650, '28276746', '2022-04-26 22:35:40', 'Ingreso al modulo Departamento'),
(651, '28276746', '2022-04-26 22:35:46', 'Ingreso al modulo departamento/sede'),
(652, '28276746', '2022-04-26 22:35:54', 'Ingreso al modulo departamento/sede'),
(653, '28276746', '2022-04-26 22:35:57', 'Ingreso al modulo Region'),
(654, '28276746', '2022-04-26 22:36:01', 'Ingreso al modulo Servicio'),
(655, '28276746', '2022-04-26 22:36:14', 'Ha cerrado sesion'),
(656, '28276746', '2022-04-26 23:30:23', 'Inicio Sesion'),
(657, '28276746', '2022-04-26 23:30:26', 'Ingreso al modulo PC'),
(658, '28276746', '2022-04-26 23:30:30', 'Ingreso al modulo Sede'),
(659, '28276746', '2022-04-26 23:30:32', 'Ingreso al modulo Servicio'),
(660, '28276746', '2022-04-26 23:30:36', 'Ha cerrado sesion'),
(661, '28276746', '2022-04-27 19:27:12', 'Inicio Sesion'),
(662, '28276746', '2022-04-27 19:27:15', 'Ingreso al modulo Servicio'),
(663, '28276746', '2022-04-27 19:27:26', 'Ha cerrado sesion'),
(664, '28276746', '2022-04-27 19:29:46', 'Inicio Sesion'),
(665, '28276746', '2022-04-27 19:29:48', 'Ingreso al modulo Servicio'),
(666, '28276746', '2022-04-27 19:30:27', 'Ha cerrado sesion'),
(667, '28276746', '2022-04-27 19:34:22', 'Inicio Sesion'),
(668, '28276746', '2022-04-27 19:34:23', 'Ingreso al modulo Servicio'),
(669, '28276746', '2022-04-27 19:35:48', 'Ha cerrado sesion'),
(670, '28276746', '2022-04-27 19:36:46', 'Inicio Sesion'),
(671, '28276746', '2022-04-27 19:36:48', 'Ingreso al modulo Servicio'),
(672, '28276746', '2022-04-27 19:39:34', 'Ha cerrado sesion'),
(673, '28276746', '2022-04-27 19:40:09', 'Inicio Sesion'),
(674, '28276746', '2022-04-27 19:40:51', 'Ingreso al modulo Servicio'),
(675, '28276746', '2022-04-27 19:41:29', 'Ha cerrado sesion'),
(676, '28276746', '2022-04-27 19:43:03', 'Inicio Sesion'),
(677, '28276746', '2022-04-27 19:43:05', 'Ingreso al modulo Servicio'),
(678, '28276746', '2022-04-27 19:43:28', 'Ha cerrado sesion'),
(679, '28276746', '2022-04-27 19:46:21', 'Inicio Sesion'),
(680, '28276746', '2022-04-27 19:46:24', 'Ingreso al modulo Servicio'),
(681, '28276746', '2022-04-27 19:46:48', 'Ingreso al modulo Sede'),
(682, '28276746', '2022-04-27 19:46:50', 'Ingreso al modulo Servicio'),
(683, '28276746', '2022-04-27 19:49:57', 'Ha cerrado sesion'),
(684, '28276746', '2022-04-27 19:53:04', 'Inicio Sesion'),
(685, '28276746', '2022-04-27 19:53:05', 'Ingreso al modulo Servicio'),
(686, '28276746', '2022-04-27 19:54:05', 'Ha cerrado sesion'),
(687, '28276746', '2022-04-27 20:26:50', 'Inicio Sesion'),
(688, '28276746', '2022-04-27 20:26:51', 'Ingreso al modulo Servicio'),
(689, '28276746', '2022-04-27 20:27:09', 'Ha cerrado sesion'),
(690, '28276746', '2022-04-27 20:28:41', 'Inicio Sesion'),
(691, '28276746', '2022-04-27 20:28:43', 'Ingreso al modulo Servicio'),
(692, '28276746', '2022-04-27 20:30:10', 'Ha cerrado sesion'),
(693, '28276746', '2022-04-27 20:48:13', 'Inicio Sesion'),
(694, '28276746', '2022-04-27 20:48:15', 'Ingreso al modulo Servicio'),
(695, '28276746', '2022-04-27 20:48:27', 'Ha cerrado sesion'),
(696, '28276746', '2022-04-27 20:55:36', 'Inicio Sesion'),
(697, '28276746', '2022-04-27 20:55:37', 'Ingreso al modulo Servicio'),
(698, '28276746', '2022-04-27 21:00:20', 'Ha cerrado sesion'),
(699, '28276746', '2022-04-28 07:09:54', 'Inicio Sesion'),
(700, '28276746', '2022-04-28 07:09:57', 'Ingreso al modulo Servicio'),
(701, '28276746', '2022-04-28 07:11:07', 'Ha cerrado sesion'),
(702, '28276746', '2022-04-28 07:12:23', 'Inicio Sesion'),
(703, '28276746', '2022-04-28 07:12:25', 'Ingreso al modulo Servicio'),
(704, '28276746', '2022-04-28 07:12:58', 'Ha cerrado sesion'),
(705, '28276746', '2022-04-28 07:13:55', 'Inicio Sesion'),
(706, '28276746', '2022-04-28 07:13:58', 'Ingreso al modulo Servicio'),
(707, '28276746', '2022-04-28 07:14:16', 'Ha Actualizado el reporte de actividad numero= 3'),
(708, '28276746', '2022-04-28 07:16:48', 'Ha cerrado sesion'),
(709, '28276746', '2022-04-28 07:17:08', 'Inicio Sesion'),
(710, '28276746', '2022-04-28 07:17:09', 'Ingreso al modulo Servicio'),
(711, '28276746', '2022-04-28 07:17:21', 'Ha Actualizado el reporte de actividad numero= 2'),
(712, '28276746', '2022-04-28 07:17:56', 'Ha Actualizado el reporte de actividad numero= 2'),
(713, '28276746', '2022-04-28 07:18:59', 'Ha Actualizado el reporte de actividad numero= 3'),
(714, '28276746', '2022-04-28 07:19:28', 'Ha Actualizado el reporte de actividad numero= 3'),
(715, '28276746', '2022-04-28 07:19:44', 'Ha cerrado sesion'),
(716, '28276746', '2022-04-28 13:29:50', 'Inicio Sesion'),
(717, '28276746', '2022-04-28 13:29:54', 'Ingreso al modulo Servicio'),
(718, '28276746', '2022-04-28 13:42:28', 'Ha Actualizado el reporte de actividad numero= 3'),
(719, '28276746', '2022-04-28 13:43:45', 'Ha cerrado sesion'),
(720, '28276746', '2022-04-28 13:49:26', 'Inicio Sesion'),
(721, '28276746', '2022-04-28 13:49:28', 'Ingreso al modulo Servicio'),
(722, '28276746', '2022-04-28 13:49:35', 'Ha Actualizado el reporte de actividad numero= 3'),
(723, '28276746', '2022-04-28 13:49:47', 'Ha cerrado sesion'),
(724, '28276746', '2022-04-28 14:03:06', 'Inicio Sesion'),
(725, '28276746', '2022-04-28 14:05:34', 'Ingreso al modulo Servicio'),
(726, '28276746', '2022-04-28 14:06:28', 'Ha cerrado sesion'),
(727, '28276746', '2022-04-28 15:04:22', 'Inicio Sesion'),
(728, '28276746', '2022-04-28 15:04:47', 'Ingreso al modulo Servicio'),
(729, '28276746', '2022-04-28 15:05:05', 'Ha cerrado sesion'),
(730, '28276746', '2022-04-28 15:10:12', 'Inicio Sesion'),
(731, '28276746', '2022-04-28 15:10:17', 'Ingreso al modulo Servicio');
INSERT INTO `bitacora` (`idBit`, `Usuario`, `Fecha_h`, `descr`) VALUES
(732, '28276746', '2022-04-28 15:10:50', 'Ha cerrado sesion'),
(733, '28276746', '2022-04-28 15:30:59', 'Inicio Sesion'),
(734, '28276746', '2022-04-28 15:31:08', 'Ingreso al modulo Servicio'),
(735, '28276746', '2022-04-28 15:32:25', 'Ha cerrado sesion'),
(736, '28276746', '2022-04-28 16:25:42', 'Inicio Sesion'),
(737, '28276746', '2022-04-28 16:25:45', 'Ingreso al modulo Servicio'),
(738, '28276746', '2022-04-28 16:27:12', 'Ha cerrado sesion'),
(739, '28276746', '2022-04-29 00:17:18', 'Inicio Sesion'),
(740, '28276746', '2022-04-29 00:17:21', 'Ingreso al modulo Servicio'),
(741, '28276746', '2022-04-29 00:18:16', 'Ingreso al modulo Sede'),
(742, '28276746', '2022-04-29 00:18:17', 'Ingreso al modulo Servicio'),
(743, '28276746', '2022-04-29 00:19:50', 'Ha cerrado sesion'),
(744, '28276746', '2022-04-29 00:20:14', 'Inicio Sesion'),
(745, '28276746', '2022-04-29 00:20:15', 'Ingreso al modulo Servicio'),
(746, '28276746', '2022-04-29 00:20:38', 'Ha cerrado sesion'),
(747, '28276746', '2022-04-29 00:37:24', 'Inicio Sesion'),
(748, '28276746', '2022-04-29 00:37:28', 'Ingreso al modulo Servicio'),
(749, '28276746', '2022-04-29 00:37:51', 'Ha cerrado sesion'),
(750, '28276746', '2022-04-29 11:10:05', 'Inicio Sesion'),
(751, '28276746', '2022-04-29 11:10:08', 'Ingreso al modulo Servicio'),
(752, '28276746', '2022-04-29 11:10:57', 'Ha cerrado sesion'),
(753, '28276746', '2022-04-29 22:25:48', 'Inicio Sesion'),
(754, '28276746', '2022-04-29 22:26:41', 'Ingreso al modulo Departamento'),
(755, '28276746', '2022-04-29 22:33:42', 'Ingreso al modulo Sede'),
(756, '28276746', '2022-04-29 22:33:46', 'Ingreso al modulo Sede'),
(757, '28276746', '2022-04-29 22:35:37', 'Ingreso al modulo Departamento'),
(758, '28276746', '2022-04-29 22:44:01', 'Ingreso al modulo Servicio'),
(759, '28276746', '2022-04-29 22:46:02', 'Ha cerrado sesion'),
(760, '28276746', '2022-04-29 23:42:46', 'Inicio Sesion'),
(761, '28276746', '2022-04-29 23:42:50', 'Ingreso al modulo Servicio'),
(762, '28276746', '2022-04-29 23:51:59', 'Ingreso al modulo Servicio'),
(763, '28276746', '2022-04-29 23:52:01', 'Ingreso al modulo Sede'),
(764, '28276746', '2022-04-29 23:52:04', 'Ingreso al modulo Servicio'),
(765, '28276746', '2022-04-29 23:52:12', 'Ha cerrado sesion'),
(766, '28276746', '2022-04-29 23:56:23', 'Inicio Sesion'),
(767, '28276746', '2022-04-29 23:56:26', 'Ingreso al modulo Servicio'),
(768, '28276746', '2022-04-29 23:57:45', 'Ha cerrado sesion'),
(769, '28276746', '2022-04-29 23:58:16', 'Inicio Sesion'),
(770, '28276746', '2022-04-29 23:58:17', 'Ingreso al modulo Servicio'),
(771, '28276746', '2022-04-30 00:01:54', 'Ha cerrado sesion'),
(772, '28276746', '2022-04-30 00:15:03', 'Inicio Sesion'),
(773, '28276746', '2022-04-30 00:15:05', 'Ingreso al modulo Servicio'),
(774, '28276746', '2022-04-30 00:15:17', 'Ha cerrado sesion'),
(775, '28276746', '2022-04-30 00:18:15', 'Inicio Sesion'),
(776, '28276746', '2022-04-30 00:18:17', 'Ingreso al modulo Servicio'),
(777, '28276746', '2022-04-30 00:38:45', 'Inicio Sesion'),
(778, '28276746', '2022-04-30 00:38:49', 'Ingreso al modulo Servicio'),
(779, '28276746', '2022-04-30 06:44:45', 'Inicio Sesion'),
(780, '28276746', '2022-04-30 06:44:48', 'Ingreso al modulo Servicio'),
(781, '28276746', '2022-04-30 06:50:09', 'Ha cerrado sesion'),
(782, '28276746', '2022-04-30 06:52:18', 'Inicio Sesion'),
(783, '28276746', '2022-04-30 06:52:20', 'Ingreso al modulo Servicio'),
(784, '28276746', '2022-04-30 06:53:20', 'Ha cerrado sesion'),
(785, '28276746', '2022-04-30 06:59:56', 'Inicio Sesion'),
(786, '28276746', '2022-04-30 06:59:58', 'Ingreso al modulo Servicio'),
(787, '28276746', '2022-04-30 07:02:19', 'Ha cerrado sesion'),
(788, '28276746', '2022-04-30 07:03:03', 'Inicio Sesion'),
(789, '28276746', '2022-04-30 07:03:06', 'Ingreso al modulo Servicio'),
(790, '28276746', '2022-04-30 07:05:08', 'Ha cerrado sesion'),
(791, '28276746', '2022-04-30 07:06:35', 'Inicio Sesion'),
(792, '28276746', '2022-04-30 07:06:38', 'Ingreso al modulo Servicio'),
(793, '28276746', '2022-04-30 07:07:04', 'Ha cerrado sesion'),
(794, '28276746', '2022-04-30 07:08:44', 'Inicio Sesion'),
(795, '28276746', '2022-04-30 07:08:47', 'Ingreso al modulo Servicio'),
(796, '28276746', '2022-04-30 07:09:04', 'Ha cerrado sesion'),
(797, '28276746', '2022-04-30 07:12:38', 'Inicio Sesion'),
(798, '28276746', '2022-04-30 07:12:40', 'Ingreso al modulo Servicio'),
(799, '28276746', '2022-04-30 07:13:05', 'Ha cerrado sesion'),
(800, '28276746', '2022-04-30 07:13:19', 'Inicio Sesion'),
(801, '28276746', '2022-04-30 07:13:21', 'Ingreso al modulo Servicio'),
(802, '28276746', '2022-04-30 07:23:01', 'Ha cerrado sesion'),
(803, '28276746', '2022-04-30 07:24:38', 'Inicio Sesion'),
(804, '28276746', '2022-04-30 07:24:39', 'Ingreso al modulo Servicio'),
(805, '28276746', '2022-04-30 07:25:03', 'Ha cerrado sesion'),
(806, '28276746', '2022-04-30 07:25:42', 'Inicio Sesion'),
(807, '28276746', '2022-04-30 07:25:45', 'Ingreso al modulo Servicio'),
(808, '28276746', '2022-04-30 07:26:03', 'Ha cerrado sesion'),
(809, '28276746', '2022-04-30 07:26:27', 'Inicio Sesion'),
(810, '28276746', '2022-04-30 07:26:29', 'Ingreso al modulo Servicio'),
(811, '28276746', '2022-04-30 07:27:03', 'Ha cerrado sesion'),
(812, '28276746', '2022-04-30 07:34:54', 'Inicio Sesion'),
(813, '28276746', '2022-04-30 07:35:00', 'Ingreso al modulo Servicio'),
(814, '28276746', '2022-04-30 07:35:36', 'Ha cerrado sesion'),
(815, '28276746', '2022-04-30 07:46:12', 'Inicio Sesion'),
(816, '28276746', '2022-04-30 07:46:14', 'Ingreso al modulo Servicio'),
(817, '28276746', '2022-04-30 07:46:34', 'Ha cerrado sesion'),
(818, '28276746', '2022-04-30 07:47:47', 'Inicio Sesion'),
(819, '28276746', '2022-04-30 07:47:48', 'Ingreso al modulo Servicio'),
(820, '28276746', '2022-04-30 07:48:34', 'Ha cerrado sesion'),
(821, '28276746', '2022-04-30 07:51:13', 'Inicio Sesion'),
(822, '28276746', '2022-04-30 07:51:14', 'Ingreso al modulo Servicio'),
(823, '28276746', '2022-04-30 07:51:41', 'Ha cerrado sesion'),
(824, '28276746', '2022-04-30 07:52:20', 'Inicio Sesion'),
(825, '28276746', '2022-04-30 07:52:23', 'Ingreso al modulo Servicio'),
(826, '28276746', '2022-04-30 07:52:36', 'Ha cerrado sesion'),
(827, '28276746', '2022-04-30 07:53:21', 'Inicio Sesion'),
(828, '28276746', '2022-04-30 07:53:22', 'Ingreso al modulo Servicio'),
(829, '28276746', '2022-04-30 07:53:32', 'Ha cerrado sesion'),
(830, '28276746', '2022-04-30 07:57:32', 'Inicio Sesion'),
(831, '28276746', '2022-04-30 07:57:39', 'Ingreso al modulo Servicio'),
(832, '28276746', '2022-04-30 07:58:13', 'Ha cerrado sesion'),
(833, '28276746', '2022-04-30 07:59:21', 'Inicio Sesion'),
(834, '28276746', '2022-04-30 07:59:23', 'Ingreso al modulo PC'),
(835, '28276746', '2022-04-30 07:59:25', 'Ingreso al modulo Servicio'),
(836, '28276746', '2022-04-30 08:00:01', 'Ha cerrado sesion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `computador`
--

CREATE TABLE `computador` (
  `id_compu` int(11) NOT NULL,
  `id_sed_dep` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `computador`
--

INSERT INTO `computador` (`id_compu`, `id_sed_dep`, `nombre`) VALUES
(1, 'HJDPHM', 'HJDPHM04'),
(2, 'HJDPRH', 'HJDPRH05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id_dep` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id_dep`, `nombre`, `activo`) VALUES
(1, 'Recursos Humanos', 1),
(2, 'Enfermeria', 1),
(3, 'Historias Medicas', 1),
(4, 'Farmacia', 1),
(5, 'Traumatologia', 1),
(6, 'Psiquiatria', 1),
(7, 'Medicina General', 1),
(8, 'Emergencia', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depsed`
--

CREATE TABLE `depsed` (
  `id_dep_sed` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_dep` int(11) NOT NULL,
  `id_sed` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `depsed`
--

INSERT INTO `depsed` (`id_dep_sed`, `id_dep`, `id_sed`, `activo`) VALUES
('HJDPEME', 8, 1, 1),
('HJDPENF', 2, 1, 1),
('HJDPFAR', 4, 1, 1),
('HJDPHM', 3, 1, 1),
('HJDPMG', 7, 1, 1),
('HJDPPSI', 6, 1, 1),
('HJDPRH', 1, 1, 1),
('HJDPTRA', 5, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id_pregunta` int(11) NOT NULL,
  `pregunta` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recuperar`
--

CREATE TABLE `recuperar` (
  `cedula` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `pregunta` int(2) NOT NULL,
  `respuesta` text COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

CREATE TABLE `region` (
  `id_region` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `region`
--

INSERT INTO `region` (`id_region`, `nombre`, `activo`) VALUES
('OCC', 'occidente', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `id_sede` int(11) NOT NULL,
  `id_region` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`id_sede`, `id_region`, `nombre`, `activo`) VALUES
(1, 'OCC', 'Hospital Juan Daza Periera', 1),
(2, 'OCC', 'Hospital Pastor Oropeza', 1),
(3, 'OCC', 'Hospital Sanidad de Barrio Union', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_report` int(11) NOT NULL,
  `id_compu` int(11) NOT NULL,
  `Fecha_i` date NOT NULL,
  `fecha_f` date NOT NULL,
  `descrip` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_Usuario` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_actividad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id_report`, `id_compu`, `Fecha_i`, `fecha_f`, `descrip`, `id_Usuario`, `id_actividad`) VALUES
(2, 1, '2022-04-26', '2022-04-26', 'asssdadad', '28276746', 2),
(3, 2, '2022-04-08', '2022-04-09', 'reparacion de redff', '28276746', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `clave` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_acceso` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `clave`, `id_acceso`, `activo`) VALUES
('28276746', 'Jose Timaure', '5ab27c63429eb991cecc32129c1ed11e', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD PRIMARY KEY (`id_acceso`);

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`idBit`),
  ADD KEY `Usuario` (`Usuario`);

--
-- Indices de la tabla `computador`
--
ALTER TABLE `computador`
  ADD PRIMARY KEY (`id_compu`),
  ADD KEY `id_sed_dep` (`id_sed_dep`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_dep`);

--
-- Indices de la tabla `depsed`
--
ALTER TABLE `depsed`
  ADD PRIMARY KEY (`id_dep_sed`),
  ADD KEY `id_dep` (`id_dep`),
  ADD KEY `id_sed` (`id_sed`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id_pregunta`);

--
-- Indices de la tabla `recuperar`
--
ALTER TABLE `recuperar`
  ADD KEY `cedula` (`cedula`),
  ADD KEY `pregunta` (`pregunta`);

--
-- Indices de la tabla `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id_region`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`id_sede`),
  ADD KEY `id_region` (`id_region`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_report`),
  ADD KEY `id_compu` (`id_compu`),
  ADD KEY `id_Usuario` (`id_Usuario`),
  ADD KEY `id_actividad` (`id_actividad`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `id_acceso` (`id_acceso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id_actividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `idBit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=837;

--
-- AUTO_INCREMENT de la tabla `computador`
--
ALTER TABLE `computador`
  MODIFY `id_compu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_dep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id_pregunta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sede`
--
ALTER TABLE `sede`
  MODIFY `id_sede` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_report` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`Usuario`) REFERENCES `usuario` (`cedula`);

--
-- Filtros para la tabla `computador`
--
ALTER TABLE `computador`
  ADD CONSTRAINT `computador_ibfk_1` FOREIGN KEY (`id_sed_dep`) REFERENCES `depsed` (`id_dep_sed`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `depsed`
--
ALTER TABLE `depsed`
  ADD CONSTRAINT `depsed_ibfk_1` FOREIGN KEY (`id_dep`) REFERENCES `departamento` (`id_dep`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `depsed_ibfk_2` FOREIGN KEY (`id_sed`) REFERENCES `sede` (`id_sede`);

--
-- Filtros para la tabla `recuperar`
--
ALTER TABLE `recuperar`
  ADD CONSTRAINT `recuperar_ibfk_1` FOREIGN KEY (`pregunta`) REFERENCES `preguntas` (`id_pregunta`),
  ADD CONSTRAINT `recuperar_ibfk_2` FOREIGN KEY (`cedula`) REFERENCES `usuario` (`cedula`);

--
-- Filtros para la tabla `sede`
--
ALTER TABLE `sede`
  ADD CONSTRAINT `sede_ibfk_1` FOREIGN KEY (`id_region`) REFERENCES `region` (`id_region`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `servicio_ibfk_2` FOREIGN KEY (`id_compu`) REFERENCES `computador` (`id_compu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `servicio_ibfk_3` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_acceso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
