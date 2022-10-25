package controller

import models.Empleado
import repository.EmpleadosRepository

class EmpleadosController(
    private val empleadoRepository: EmpleadosRepository) {


    fun getEmpleados(): MutableList<Empleado> {
        return empleadoRepository.readAll()
    }

    fun createEmpleado(empleado: Empleado): Empleado {
        return empleadoRepository.create(empleado)
    }

    fun getEmpleadoById(id: Int): Empleado? {
        return empleadoRepository.findById(id)
    }

    fun updateEmpleado(empleado: Empleado): Empleado {
        return empleadoRepository.update(empleado)
    }

    fun deleteEmpleado(id: Int) {
        empleadoRepository.delete(id)
    }

    fun deleteAllEmpleados() {
        empleadoRepository.deleteAllEmpleados()
    }
}