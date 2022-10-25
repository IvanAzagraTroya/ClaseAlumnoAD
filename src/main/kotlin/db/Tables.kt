package db

import models.Departamento
import models.Empleado
import java.time.LocalDate

fun createTableEmpleados() = """
    CREATE TABLE IF NOT EXISTS empleados(
        idEmpleado INTEGER PRIMARY KEY AUTO_INCREMENT,
        nombreEmpleado VARCHAR(255) NOT NULL,
        fechaAdmision DATE NOT NULL,
        idDepartamento INTEGER,
        FOREIGN KEY (idDepartamento) REFERENCES departamentos(idDepartamento)
    )
""".trimIndent()

fun createTableDepartamentos() = """
    CREATE TABLE IF NOT EXISTS departamentos(
        idDepartamento INTEGER PRIMARY KEY AUTO_INCREMENT,
        nombreDepartamento VARCHAR(255) NOT NULL,
        presupuesto DOUBLE NOT NULL
    )
""".trimIndent()

fun createDataBase() = """
    CREATE DATABASE IF NOT EXISTS dataBase
""".trimIndent()

fun createEmpleados() = mutableListOf(
    Empleado(1, "Juan", LocalDate.parse("2022-03-05"), 1),
    Empleado(2, "Luis", LocalDate.parse("2022-01-05"), 2),
    Empleado(3, "Andres", LocalDate.parse("2010-02-05"), 1),
    Empleado(4, "Juan", LocalDate.parse("2022-03-12"), 1),
    Empleado(5, "Luis", LocalDate.parse("2020-01-12"), 3),
    Empleado(6, "Andres", LocalDate.parse("2010-02-12"), 3),
    Empleado(7, "Juan Alberto", LocalDate.parse("2022-03-12"), 4)
)

fun createDepartamentos() = mutableListOf(
    Departamento(1, "Departamento de Compras", 2600.0),
    Departamento(2, "Departamento de Desarrollo", 4600.0),
    Departamento(3, "Departamento de Recursos Humanos", 1600.50),
    Departamento(4, "Departamento de Investigación", 5400.0)
)