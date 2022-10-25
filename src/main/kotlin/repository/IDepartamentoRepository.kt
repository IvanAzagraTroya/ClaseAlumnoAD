package repository

import models.Departamento

interface IDepartamentoRepository: ICRUDRepository<Departamento, Int> {
    fun deleteAllDepartamentos(): Boolean
    fun findById(id: Int): Departamento?
}