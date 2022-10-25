package models

import java.util.*

data class Departamento(
    val idDepartamento: Int,
    var nombreDepartamento: String,
    var presupuesto: Double,
) {
    override fun toString(): String {
        return "Departamento(idDepartamento= '$idDepartamento', nombreDepartamento='$nombreDepartamento', presupuesto='$presupuesto')"
    }
}
