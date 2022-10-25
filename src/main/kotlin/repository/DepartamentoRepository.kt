package repository

import db.DataBaseManager
import models.Departamento

class DepartamentoRepository: IDepartamentoRepository {
    private val db: DataBaseManager = DataBaseManager

    override fun deleteAllDepartamentos(): Boolean {
        val query = "DELETE FROM departamentos"
        db.open()
        db.delete(query)
        db.close()
        return true
    }

    override fun create(entity: Departamento): Departamento {
        val query: String = """INSERT INTO departamentos(idDepartamento = ?, nombreDepartamento, presupuesto)
            VALUES (?, ?, ?)""".trimIndent()
        db.open()
        db.insert(query, entity.nombreDepartamento, entity.presupuesto)
        db.close()
        return entity
    }

    override fun readAll(): MutableList<Departamento> {
        val query = "SELECT * FROM departamentos"
        db.open()
        val result = db.select(query)
        val departamentos = mutableListOf<Departamento>()
        result?.let {
            while(result.next()) {
                val departamento = Departamento(
                    idDepartamento = it.getInt("idDepartamento"),
                    nombreDepartamento = it.getString("nombreDepartamento"),
                    presupuesto = it.getDouble("presupuesto")
                    )
                departamentos.add(departamento)
            }
        }
        db.close()
        return departamentos
    }

    override fun update(entity: Departamento): Departamento {
        val query = "UPDATE departamentos SET nombreDepartamento = ?, presupuesto = ?"
        db.open()
        db.update(query)
        db.close()
        return entity
    }

    override fun delete(id: Int): Boolean {
        val query = "DELETE from departamentos WHERE id = ?"
        db.open()
        db.delete(query, id)
        db.close()
        return true
    }

    override fun findById(id: Int): Departamento? {
        val query = "SELECT id FROM departamentos WHERE id = ?"
        db.open()
        val result = db.select(query, id)
        var departamento: Departamento? = null
        result?.let {
            if (result.next()) {
                departamento = Departamento(
                    idDepartamento = it.getInt("idDepartamento"),
                    nombreDepartamento = it.getString("nombreDepartamento"),
                    presupuesto = it.getDouble("presupuesto")

                )
            }
        }
        db.close()
        return departamento
    }
}