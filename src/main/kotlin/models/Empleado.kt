package models

import java.time.LocalDate
import java.util.*

data class Empleado(
    val idEmpleado: UUID = UUID.randomUUID(),
    var nombreEmpleado: String,
    var fechaAdmision: LocalDate,
    var depId: Int? = null
    ) {
    override fun toString(): String {
        return "Empleado(id='$idEmpleado', nombreEmpleado='$nombreEmpleado', fechaAdmision='$fechaAdmision'" +
                ", departamento='$depId')"
    }
}
