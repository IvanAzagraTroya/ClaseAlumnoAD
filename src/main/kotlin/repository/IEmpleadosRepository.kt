package repository

import models.Empleado

interface IEmpleadosRepository: ICRUDRepository<Empleado, Int> {
    fun deleteAllEmpleados(): Boolean
    fun findById(id: Int): Empleado?
}