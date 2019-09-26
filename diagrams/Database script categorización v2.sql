SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- Database name: `mma_data_sf_bd`
-- jdbc:mysql://localhost:3306/mma_data_sf_bd

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `Empresa`;
DROP TABLE IF EXISTS `Actividad`;
DROP TABLE IF EXISTS `actividadEmpresa`;
DROP TABLE IF EXISTS `GrupoActividad`;
DROP TABLE IF EXISTS `Domicilio`;
DROP TABLE IF EXISTS `Representante`;
DROP TABLE IF EXISTS `Producto`;
DROP TABLE IF EXISTS `Subproducto`;
DROP TABLE IF EXISTS `MateriaPrima`;
DROP TABLE IF EXISTS `Insumo`;
DROP TABLE IF EXISTS `Planta`;
DROP TABLE IF EXISTS `FormacionDePersonal`;
DROP TABLE IF EXISTS `EmisionGaseosa`;
DROP TABLE IF EXISTS `Efluente`;
DROP TABLE IF EXISTS `ResiduoSolido`;
DROP TABLE IF EXISTS `RiesgoPresunto`;
DROP TABLE IF EXISTS `Perito`;
DROP TABLE IF EXISTS `PartidaInmobiliaria`;
DROP TABLE IF EXISTS `Tanque`;
DROP TABLE IF EXISTS `SustanciaAux`;
DROP TABLE IF EXISTS `SustanciaAuxYFluido`;
DROP TABLE IF EXISTS `InmuebleAnexo`;
DROP TABLE IF EXISTS `Servicio`;
DROP TABLE IF EXISTS `Localidad`;
DROP TABLE IF EXISTS `Departamento`;
DROP TABLE IF EXISTS `Nodo`;
SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `Empresa`;
CREATE TABLE IF NOT EXISTS `Empresa` (
    `cuit` BIGINT NOT NULL,
    `razonSocial` VARCHAR(50) NOT NULL,
    `fechaInicioActividades` DATE NOT NULL,
    `tipoPersona` VARCHAR(30) NOT NULL,
    `nroRegistro` INTEGER,
    PRIMARY KEY (`cuit`)
);
DROP TABLE IF EXISTS `Actividad`;
CREATE TABLE IF NOT EXISTS `Actividad` (
    `cuacm` INTEGER NOT NULL,
    `nombreActividad` VARCHAR(100) NOT NULL,
    `estandar` INTEGER NOT NULL,
    `grupo` CHAR NOT NULL,
    PRIMARY KEY (`cuacm`)
);
DROP TABLE IF EXISTS `actividadEmpresa`;
CREATE TABLE IF NOT EXISTS `actividadEmpresa` (
    `cuit` BIGINT NOT NULL,
    `cuacm` INTEGER NOT NULL,
    `prioridad` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`cuit`, `cuacm`)
);
DROP TABLE IF EXISTS `GrupoActividad`;
CREATE TABLE IF NOT EXISTS `GrupoActividad` (
    `idGrupo` CHAR NOT NULL,
    `nombreGrupo` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`idGrupo`)
);
DROP TABLE IF EXISTS `Domicilio`;
CREATE TABLE IF NOT EXISTS `Domicilio` (
    `cuit` BIGINT NOT NULL,
    `tipo` VARCHAR(20) NOT NULL,
    `calle` VARCHAR(50) NOT NULL,
    `numero` VARCHAR(6) NOT NULL,
    `piso` INTEGER,
    `depto` VARCHAR(6),
    `localidad` INTEGER NOT NULL,
    `telefono` INTEGER NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `zonificacion` VARCHAR(50) NOT NULL,
    `idPlanta` INTEGER,
    `nroPartida` VARCHAR(50),
    PRIMARY KEY (`tipo`, `calle`, `numero`)
);
DROP TABLE IF EXISTS `Representante`;
CREATE TABLE IF NOT EXISTS `Representante` (
    `documento` INTEGER NOT NULL,
    `apellido` VARCHAR(50) NOT NULL,
    `nombre` VARCHAR(50) NOT NULL,
    `cargo` VARCHAR(50) NOT NULL,
    `cuit` BIGINT NOT NULL,
    `tipo` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`documento`)
);
DROP TABLE IF EXISTS `Producto`;
CREATE TABLE IF NOT EXISTS `Producto` (
    `idProducto` INTEGER AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `estadoFisico` VARCHAR(20) NOT NULL,
    `produccionAnual` DOUBLE NOT NULL,
    `unidad` VARCHAR(10) NOT NULL,
    `almacenamiento` VARCHAR(100) NOT NULL,
    `clasificacion` VARCHAR(20) NOT NULL,
    `especificacion` VARCHAR(200) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    PRIMARY KEY (`idProducto`)
);
DROP TABLE IF EXISTS `Subproducto`;
CREATE TABLE IF NOT EXISTS `Subproducto` (
    `nombre` VARCHAR(50) NOT NULL,
    `estadoFisico` VARCHAR(20) NOT NULL,
    `produccionAnual` DOUBLE NOT NULL,
    `unidad` VARCHAR(10) NOT NULL,
    `almacenamiento` VARCHAR(100) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idSubProducto` INTEGER AUTO_INCREMENT,
    PRIMARY KEY (`idSubProducto`)
);
DROP TABLE IF EXISTS `MateriaPrima`;
CREATE TABLE IF NOT EXISTS `MateriaPrima` (
    `nombre` VARCHAR(50) NOT NULL,
    `estadoFisico` VARCHAR(20) NOT NULL,
    `consumoAnual` DOUBLE NOT NULL,
    `unidad` VARCHAR(10) NOT NULL,
    `almacenamiento` VARCHAR(100) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idMateriaPrima` INTEGER AUTO_INCREMENT,
    PRIMARY KEY (`idMateriaPrima`)
);
DROP TABLE IF EXISTS `Insumo`;
CREATE TABLE IF NOT EXISTS `Insumo` (
    `nombre` VARCHAR(50) NOT NULL,
    `estadoFisico` VARCHAR(20) NOT NULL,
    `consumoAnual` DOUBLE NOT NULL,
    `unidad` VARCHAR(10) NOT NULL,
    `almacenamiento` VARCHAR(100) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idInsumo` INTEGER AUTO_INCREMENT,
    PRIMARY KEY (`idInsumo`)
);
DROP TABLE IF EXISTS `Planta`;
CREATE TABLE IF NOT EXISTS `Planta` (
    `idPlanta` INTEGER AUTO_INCREMENT,
    `cuit` BIGINT NOT NULL,
    `fueraProv` BOOLEAN NOT NULL,
    `superficieDeposito` DOUBLE,
    `superficieTotalM2` DOUBLE NOT NULL,
    `superficieCubiertaM2` DOUBLE NOT NULL,
    `potenciaInstaladaHP` DOUBLE NOT NULL,
    `dotacionDePersonal` INTEGER NOT NULL,
    `fechaInicioActividades` DATE NOT NULL,
    PRIMARY KEY (`idPlanta`)
);
DROP TABLE IF EXISTS `FormacionDePersonal`;
CREATE TABLE IF NOT EXISTS `FormacionDePersonal` (
    `cantidadObreros` INTEGER NOT NULL,
    `capacitacionObreros` BOOLEAN NOT NULL,
    `cantidadTecnicos` INTEGER NOT NULL,
    `capacitacionTecnicos` BOOLEAN NOT NULL,
    `cantidadProfesionales` INTEGER NOT NULL,
    `capacitacionProfesionales` BOOLEAN NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idFormacionPersonal` INTEGER AUTO_INCREMENT,
    PRIMARY KEY (`idFormacionPersonal`)
);
DROP TABLE IF EXISTS `EmisionGaseosa`;
CREATE TABLE IF NOT EXISTS `EmisionGaseosa` (
    `tipo` VARCHAR(60) NOT NULL,
    `emision` VARCHAR(50) NOT NULL,
    `procesoGenerador` VARCHAR(100) NOT NULL,
    `tratamiento` VARCHAR(100) NOT NULL,
    `componentesRelevantes` VARCHAR(100) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idEmisionGaseosa` INTEGER AUTO_INCREMENT,
    PRIMARY KEY (`idEmisionGaseosa`)
);
DROP TABLE IF EXISTS `Efluente`;
CREATE TABLE IF NOT EXISTS `Efluente` (
    `procesoGenerador` VARCHAR(50) NOT NULL,
    `componentesRelevantes` VARCHAR(100) NOT NULL,
    `volumen` DOUBLE NOT NULL,
    `unidad` VARCHAR(5) NOT NULL,
    `unidadDeTiempo` VARCHAR(10) NOT NULL,
    `gestion` VARCHAR(200) NOT NULL,
    `cuerpoReceptor` VARCHAR(200) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idEfluente` INTEGER AUTO_INCREMENT,
    `tipo` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`idEfluente`)
);
DROP TABLE IF EXISTS `ResiduoSolido`;
CREATE TABLE IF NOT EXISTS `ResiduoSolido` (
    `residuo` VARCHAR(150) NOT NULL,
    `cantidad` DOUBLE NOT NULL,
    `unidad` VARCHAR(10) NOT NULL,
    `periodo` VARCHAR(10) NOT NULL,
    `procesoGenerador` VARCHAR(50) NOT NULL,
    `gestion` VARCHAR(200) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idResiduoSolido` INTEGER AUTO_INCREMENT,
    `tipo` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`idResiduoSolido`)
);
DROP TABLE IF EXISTS `RiesgoPresunto`;
CREATE TABLE IF NOT EXISTS `RiesgoPresunto` (
    `fuentesMoviles` BOOLEAN NOT NULL,
    `aparatosSometidos` BOOLEAN NOT NULL,
    `sustanciasQuimicas` BOOLEAN NOT NULL,
    `explosion` BOOLEAN NOT NULL,
    `incendio` BOOLEAN NOT NULL,
    `otro` BOOLEAN NOT NULL,
    `observaciones` VARCHAR(200) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    `idRiesgoPresunto` INTEGER AUTO_INCREMENT,
    PRIMARY KEY (`idRiesgoPresunto`)
);
DROP TABLE IF EXISTS `Perito`;
CREATE TABLE IF NOT EXISTS `Perito` (
    `nroRegistro` INTEGER NOT NULL,
    `apellido` VARCHAR(50) NOT NULL,
    `nombre` VARCHAR(50) NOT NULL,
    `profesion` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`nroRegistro`)
);
DROP TABLE IF EXISTS `PartidaInmobiliaria`;
CREATE TABLE IF NOT EXISTS `PartidaInmobiliaria` (
    `nroPartida` VARCHAR(50) NOT NULL,
    `latitud` VARCHAR(15) NOT NULL,
    `longitud` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`nroPartida`)
);
DROP TABLE IF EXISTS `Tanque`;
CREATE TABLE IF NOT EXISTS `Tanque` (
    `idTanque` INTEGER AUTO_INCREMENT,
    `cantidad` INTEGER NOT NULL,
    `capacidadTotal` DOUBLE NOT NULL,
    `unidad` VARCHAR(2) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    PRIMARY KEY (`idTanque`)
);
DROP TABLE IF EXISTS `SustanciaAux`;
CREATE TABLE IF NOT EXISTS `SustanciaAux` (
    `idSustancias` INTEGER AUTO_INCREMENT,
    `combustiblesLiquidos` BOOLEAN NOT NULL,
    `aireComprimido` BOOLEAN NOT NULL,
    `gasNatural` BOOLEAN NOT NULL,
    `aceitesYLubricantes` BOOLEAN NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    PRIMARY KEY (`idSustancias`)
);
DROP TABLE IF EXISTS `SustanciaAuxYFluido`;
CREATE TABLE IF NOT EXISTS `SustanciaAuxYFluido` (
    `idSustanciasAux` INTEGER AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `consumoAnual` DOUBLE NOT NULL,
    `unidad` VARCHAR(10) NOT NULL,
    `almacenamiento` VARCHAR(50) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    PRIMARY KEY (`idSustanciasAux`)
);
DROP TABLE IF EXISTS `InmuebleAnexo`;
CREATE TABLE IF NOT EXISTS `InmuebleAnexo` (
    `idInmueble` INTEGER AUTO_INCREMENT,
    `domicilio` VARCHAR(100) NOT NULL,
    `actividad` VARCHAR(100) NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    PRIMARY KEY (`idInmueble`)
);
DROP TABLE IF EXISTS `Servicio`;
CREATE TABLE IF NOT EXISTS `Servicio` (
    `idServicios` INTEGER AUTO_INCREMENT,
    `energiaElectrica` BOOLEAN NOT NULL,
    `cloacas` BOOLEAN NOT NULL,
    `aguaRed` BOOLEAN NOT NULL,
    `gasNatural` BOOLEAN NOT NULL,
    `idPlanta` INTEGER NOT NULL,
    PRIMARY KEY (`idServicios`)
);
DROP TABLE IF EXISTS `Localidad`;
CREATE TABLE IF NOT EXISTS `Localidad` (
    `id` INTEGER NOT NULL,
    `nombre_localidad` VARCHAR(50) NOT NULL,
    `id_departamento` INTEGER NOT NULL,
    `id_nodo` INTEGER NOT NULL,
    `categoria` VARCHAR(50) NOT NULL,
    `codigo_postal` VARCHAR(8) NOT NULL,
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `Departamento`;
CREATE TABLE IF NOT EXISTS `Departamento` (
    `id_departamento` INTEGER NOT NULL,
    `nombre_departamento` VARCHAR(50) NOT NULL,
	PRIMARY KEY(`id_departamento`)
);
DROP TABLE IF EXISTS `Nodo`;
CREATE TABLE IF NOT EXISTS `Nodo` (
    `id_nodo` INTEGER NOT NULL,
    `nombre_nodo` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id_nodo`)
);

ALTER TABLE `Actividad` ADD FOREIGN KEY (`grupo`) REFERENCES `GrupoActividad`(`idGrupo`);
ALTER TABLE `actividadEmpresa` ADD FOREIGN KEY (`cuit`) REFERENCES `Empresa`(`cuit`);
ALTER TABLE `actividadEmpresa` ADD FOREIGN KEY (`cuacm`) REFERENCES `Actividad`(`cuacm`);
ALTER TABLE `Domicilio` ADD FOREIGN KEY (`cuit`) REFERENCES `Empresa`(`cuit`);
ALTER TABLE `Domicilio` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `Domicilio` ADD FOREIGN KEY (`localidad`) REFERENCES `Localidad`(`id`);
ALTER TABLE `Representante` ADD FOREIGN KEY (`cuit`) REFERENCES `Empresa`(`cuit`);
ALTER TABLE `Producto` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `Subproducto` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `MateriaPrima` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `Insumo` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `Planta` ADD FOREIGN KEY (`cuit`) REFERENCES `Empresa`(`cuit`);
ALTER TABLE `FormacionDePersonal` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `EmisionGaseosa` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `Efluente` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `ResiduoSolido` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `RiesgoPresunto` ADD FOREIGN KEY (`idPlanta`) REFERENCES `Planta`(`idPlanta`);
ALTER TABLE `Localidad` ADD FOREIGN KEY (`id_departamento`) REFERENCES `Departamento`(`id_departamento`);
ALTER TABLE `Localidad` ADD FOREIGN KEY (`id_nodo`) REFERENCES `Nodo`(`id_nodo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;