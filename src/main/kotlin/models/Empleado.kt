package models

import java.time.LocalDate

data class Empleado(
    val idEmpleado: Int,
    val nombreEmpleado: String,
    val fechaAdmision: LocalDate,
    val depId: Int
    ) {
    override fun toString(): String {
        return "Empleado(nombreEmpleado='$nombreEmpleado', fechaAdmision='$fechaAdmision'" +
                ", departamento='$depId')"
    }
}
