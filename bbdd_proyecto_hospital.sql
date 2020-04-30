-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 30, 2020 at 10:58 AM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `ProyectoIndividual`
--

-- --------------------------------------------------------

--
-- Table structure for table `Campos_Medicos`
--

CREATE TABLE `Campos_Medicos` (
  `id_campo` int(9) NOT NULL,
  `nombre_campo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Campos_Medicos`
--

INSERT INTO `Campos_Medicos` (`id_campo`, `nombre_campo`) VALUES
(1, 'Alergología'),
(2, 'Anestesiología y reanimación'),
(3, 'Cardiología'),
(4, 'Gastroenterología'),
(5, 'Endocrinología'),
(6, 'Geriatria'),
(7, 'Hematología y hemoterapia'),
(8, 'Infectología'),
(9, 'Nefrología'),
(10, 'Neumología'),
(11, 'Neurología'),
(12, 'Nutriología'),
(13, 'Oncología médica'),
(14, 'Oncología radioterápica'),
(15, 'Pediatría'),
(16, 'Oftalmología'),
(17, 'Psiquiatría'),
(18, 'Toxicología'),
(19, 'Traumatología'),
(20, 'Reumatología');

-- --------------------------------------------------------

--
-- Table structure for table `Enfermeros`
--

CREATE TABLE `Enfermeros` (
  `id_enfermero` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `numero_colegiado` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Enfermeros`
--

INSERT INTO `Enfermeros` (`id_enfermero`, `nombre`, `apellido`, `numero_colegiado`) VALUES
(1, 'Carlos', 'Jiménez', 12),
(2, 'Daniel', 'Rodríguez', 3214),
(3, 'Pedro', 'Parra', 783126),
(4, 'Álvaro', 'Gómez', 21358),
(5, 'Alejandro', 'Mártinez', 61235),
(6, 'María', 'Torres', 13784),
(7, 'Ana', 'Fernández', 543768),
(8, 'Ariadna', 'López', 513274),
(9, 'Dolores', 'Cortés', 421386),
(10, 'Alfonso', 'García', 412395),
(11, 'Ginés', 'Reyes', 243187),
(12, 'Juan', 'Garzón', 81254),
(13, 'Fernando', 'de Fuentes', 234567),
(14, 'Julian', 'Pérez', 42356),
(15, 'Roberto', 'Carlos', 2746),
(16, 'Cristian', 'Toma', 726413),
(17, 'Lucía', 'Cano', 162853),
(18, 'Pablo', 'Neruda', 676356),
(19, 'David', 'Hidalgo', 123764),
(20, 'Carla', 'de los Campos', 85623),
(21, 'Gloria', 'Fuertes', 444624),
(23, 'Paula', 'Núñez', 872531);

-- --------------------------------------------------------

--
-- Table structure for table `Enfermero_Paciente`
--

CREATE TABLE `Enfermero_Paciente` (
  `id_enfermero` int(9) DEFAULT NULL,
  `id_paciente` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Enfermero_Paciente`
--

INSERT INTO `Enfermero_Paciente` (`id_enfermero`, `id_paciente`) VALUES
(1, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Habitaciones`
--

CREATE TABLE `Habitaciones` (
  `id_habitacion` int(9) NOT NULL,
  `id_pasillo` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Habitaciones`
--

INSERT INTO `Habitaciones` (`id_habitacion`, `id_pasillo`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(22, 2),
(23, 2),
(24, 2),
(25, 3),
(26, 3),
(27, 3),
(28, 3),
(29, 3),
(30, 3),
(31, 3),
(32, 3),
(33, 3),
(34, 3),
(35, 3),
(36, 3),
(37, 4),
(38, 4),
(39, 4),
(40, 4),
(41, 4),
(42, 4),
(43, 4),
(44, 4),
(45, 4),
(46, 4),
(47, 4),
(48, 4),
(49, 5),
(50, 5),
(51, 5),
(52, 5),
(53, 5),
(54, 5),
(55, 5),
(56, 5),
(57, 5),
(58, 5),
(59, 5),
(60, 5),
(61, 6),
(62, 6),
(63, 6),
(64, 6),
(65, 6),
(66, 6),
(67, 6),
(68, 6),
(69, 6),
(70, 6),
(71, 6),
(72, 6),
(73, 7),
(74, 7),
(75, 7),
(76, 7),
(77, 7),
(78, 7),
(79, 7),
(80, 7),
(81, 7),
(82, 7),
(83, 7),
(84, 7),
(85, 8),
(86, 8),
(87, 8),
(88, 8),
(89, 8),
(90, 8),
(91, 8),
(92, 8),
(93, 8),
(94, 8),
(95, 8),
(96, 8),
(97, 9),
(98, 9),
(99, 9),
(100, 9),
(101, 9),
(102, 9),
(103, 9),
(104, 9),
(105, 9),
(106, 9),
(107, 9),
(108, 9),
(109, 10),
(110, 10),
(111, 10),
(112, 10),
(113, 10),
(114, 10),
(115, 10),
(116, 10),
(117, 10),
(118, 10),
(119, 10),
(120, 10);

-- --------------------------------------------------------

--
-- Table structure for table `Medicos`
--

CREATE TABLE `Medicos` (
  `id_medico` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `numero_colegiado` int(9) DEFAULT NULL,
  `id_campo` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Medicos`
--

INSERT INTO `Medicos` (`id_medico`, `nombre`, `apellido`, `numero_colegiado`, `id_campo`) VALUES
(1, 'Carlos', 'González', 12, 3),
(2, 'David', 'Jiménez', 666, 15),
(3, 'Adrián', 'Mansilla', 69, 4),
(4, 'Alfonso', 'Pérez', 12378, 16),
(5, 'David', 'Sánchez', 61237, 6),
(6, 'Daniel', 'Arellano', 5234168, 18),
(7, 'Dolores', 'Ibarruri', 238645, 11),
(8, 'Jimena', 'Barrios', 23458, 5),
(9, 'Alfredo', 'Hernández', 95234, 7);

-- --------------------------------------------------------

--
-- Table structure for table `Medico_Paciente`
--

CREATE TABLE `Medico_Paciente` (
  `id_medico` int(9) DEFAULT NULL,
  `id_paciente` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Medico_Paciente`
--

INSERT INTO `Medico_Paciente` (`id_medico`, `id_paciente`) VALUES
(2, 8),
(2, 1),
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Pacientes`
--

CREATE TABLE `Pacientes` (
  `id_paciente` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `id_habitacion` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Pacientes`
--

INSERT INTO `Pacientes` (`id_paciente`, `nombre`, `apellido`, `dni`, `id_habitacion`) VALUES
(1, 'Raul', 'Fernández', '12345678A', 1),
(2, 'Mario', 'Pérez', '43527819J', 2),
(3, 'Pedro', 'Almodóvar', '47285991F', 3),
(4, 'Antonio', 'Banderas', '12752234O', 4),
(5, 'Leticia', 'Sabater', '58247753P', 5),
(6, 'María', 'Aguado', '58423698K', 6),
(7, 'Carlos', 'de la Mancha', '67237843G', 7),
(8, 'Nobita', 'Nobi', '66226622N', 8);

-- --------------------------------------------------------

--
-- Table structure for table `Pasillos`
--

CREATE TABLE `Pasillos` (
  `id_pasillo` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Pasillos`
--

INSERT INTO `Pasillos` (`id_pasillo`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Campos_Medicos`
--
ALTER TABLE `Campos_Medicos`
  ADD PRIMARY KEY (`id_campo`);

--
-- Indexes for table `Enfermeros`
--
ALTER TABLE `Enfermeros`
  ADD PRIMARY KEY (`id_enfermero`),
  ADD UNIQUE KEY `numero_colegiado` (`numero_colegiado`);

--
-- Indexes for table `Enfermero_Paciente`
--
ALTER TABLE `Enfermero_Paciente`
  ADD KEY `enfermero_paciente_ibfk_1` (`id_enfermero`),
  ADD KEY `id_paciente_enfermeroPaciente` (`id_paciente`);

--
-- Indexes for table `Habitaciones`
--
ALTER TABLE `Habitaciones`
  ADD PRIMARY KEY (`id_habitacion`),
  ADD KEY `id_pasillo` (`id_pasillo`);

--
-- Indexes for table `Medicos`
--
ALTER TABLE `Medicos`
  ADD PRIMARY KEY (`id_medico`),
  ADD KEY `id_campo_campo_medico` (`id_campo`);

--
-- Indexes for table `Medico_Paciente`
--
ALTER TABLE `Medico_Paciente`
  ADD KEY `id_medico_medico` (`id_medico`),
  ADD KEY `id_paciente_paciente` (`id_paciente`);

--
-- Indexes for table `Pacientes`
--
ALTER TABLE `Pacientes`
  ADD PRIMARY KEY (`id_paciente`),
  ADD KEY `id_habitacion` (`id_habitacion`);

--
-- Indexes for table `Pasillos`
--
ALTER TABLE `Pasillos`
  ADD PRIMARY KEY (`id_pasillo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Campos_Medicos`
--
ALTER TABLE `Campos_Medicos`
  MODIFY `id_campo` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `Enfermeros`
--
ALTER TABLE `Enfermeros`
  MODIFY `id_enfermero` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `Medicos`
--
ALTER TABLE `Medicos`
  MODIFY `id_medico` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `Pacientes`
--
ALTER TABLE `Pacientes`
  MODIFY `id_paciente` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `Pasillos`
--
ALTER TABLE `Pasillos`
  MODIFY `id_pasillo` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Enfermero_Paciente`
--
ALTER TABLE `Enfermero_Paciente`
  ADD CONSTRAINT `enfermero_paciente_ibfk_1` FOREIGN KEY (`id_enfermero`) REFERENCES `Enfermeros` (`id_enfermero`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_paciente_enfermeroPaciente` FOREIGN KEY (`id_paciente`) REFERENCES `Pacientes` (`id_paciente`);

--
-- Constraints for table `Habitaciones`
--
ALTER TABLE `Habitaciones`
  ADD CONSTRAINT `id_pasillo` FOREIGN KEY (`id_pasillo`) REFERENCES `Pasillos` (`id_pasillo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Medicos`
--
ALTER TABLE `Medicos`
  ADD CONSTRAINT `id_campo_campo_medico` FOREIGN KEY (`id_campo`) REFERENCES `Campos_Medicos` (`id_campo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Medico_Paciente`
--
ALTER TABLE `Medico_Paciente`
  ADD CONSTRAINT `id_medico_medico` FOREIGN KEY (`id_medico`) REFERENCES `Medicos` (`id_medico`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_paciente_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `Pacientes` (`id_paciente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Pacientes`
--
ALTER TABLE `Pacientes`
  ADD CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`id_habitacion`) REFERENCES `Habitaciones` (`id_habitacion`);
