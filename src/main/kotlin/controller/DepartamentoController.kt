package controller

import models.Departamento
import repository.DepartamentoRepository

class DepartamentoController(
    private val departamentoRepository: DepartamentoRepository
) {


    fun getDepartamentos(): MutableList<Departamento> {
        return departamentoRepository.readAll()
    }

    fun createDepartamento(departamento: Departamento): Departamento {
        return departamentoRepository.create(departamento)
    }

    fun getDepartamentoById(id: Int): Departamento? {
        return departamentoRepository.findById(id)
    }

    fun updateDepartamento(departamento: Departamento): Departamento {
        return departamentoRepository.update(departamento)
    }

    fun deleteDepartamento(id: Int) {
        departamentoRepository.delete(id)
    }

    fun deleteAllDepartamentos() {
        departamentoRepository.deleteAllDepartamentos()
    }
}