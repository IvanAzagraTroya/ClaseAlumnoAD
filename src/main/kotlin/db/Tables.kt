package db

import models.Departamento
import models.Empleado
import java.time.LocalDate

fun createTableEmpleados() = """
    CREATE TABLE IF NOT EXISTS empleados(
        idEmpleado UUID PRIMARY KEY NOT NULL,
        nombreEmpleado VARCHAR(255) NOT NULL,
        fechaAdmision DATE NOT NULL,
        depIdFK INTEGER REFERENCES departamentos(id_dep)
    )
""".trimIndent()

fun createTableDepartamentos() = """
    CREATE TABLE IF NOT EXISTS departamentos(
        id_dep INTEGER PRIMARY KEY,
        nombreDepartamento VARCHAR(255) NOT NULL,
        presupuesto DOUBLE NOT NULL
    )
""".trimIndent()

fun createEmpleados() = mutableListOf(
    Empleado(nombreEmpleado = "Juan", fechaAdmision = LocalDate.parse("2022-03-05"), depId = 1),
    Empleado(nombreEmpleado = "Luis", fechaAdmision = LocalDate.parse("2022-01-05"), depId = 2),
    Empleado(nombreEmpleado = "Andres", fechaAdmision = LocalDate.parse("2010-02-05"), depId = 1),
    Empleado(nombreEmpleado = "Juan", fechaAdmision = LocalDate.parse("2022-03-12"), depId = 1),
    Empleado(nombreEmpleado = "Luis", fechaAdmision = LocalDate.parse("2020-01-12"), depId = 3),
    Empleado(nombreEmpleado = "Andres", fechaAdmision = LocalDate.parse("2010-02-12"), depId = 3),
    Empleado(nombreEmpleado = "Juan Alberto", fechaAdmision = LocalDate.parse("2022-03-12"), depId = 4)
)

fun createDepartamentos() = mutableListOf(
    Departamento(1,nombreDepartamento = "Departamento de Compras", presupuesto = 2600.0),
    Departamento(2, nombreDepartamento = "Departamento de Desarrollo", presupuesto = 4600.0),
    Departamento(3, nombreDepartamento = "Departamento de Recursos Humanos", presupuesto = 1600.50),
    Departamento(4, nombreDepartamento = "Departamento de Investigación", presupuesto = 5400.0)
)