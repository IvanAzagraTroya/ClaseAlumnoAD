package models

data class Departamento(
    val idDepartamento: Int,
    val nombreDepartamento: String,
    val presupuesto: Double,
) {
    override fun toString(): String {
        return "Departamento(idDepartamento= '$idDepartamento', nombreDepartamento='$nombreDepartamento', presupuesto='$presupuesto')"
    }
}
