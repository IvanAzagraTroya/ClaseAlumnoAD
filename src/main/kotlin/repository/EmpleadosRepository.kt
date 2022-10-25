package repository

import db.DataBaseManager
import models.Empleado
import java.time.LocalDate

class EmpleadosRepository: IEmpleadosRepository {
    private val db: DataBaseManager = DataBaseManager

    override fun deleteAllEmpleados(): Boolean {
        val query = "DELETE * FROM empleados"
        db.delete(query)
        db.close()
        return true
    }

    override fun create(entity: Empleado): Empleado {
        val query: String = """INSERT INTO empleados(idEmpleado = ?, nombreEmpleado, fechaAdmision, depId = ?)
             VALUES (?, ?, ?, ?)""".trimIndent()
        db.open()
        db.insert(query, entity.nombreEmpleado, entity.fechaAdmision)
        db.close()
        return entity
    }

    override fun readAll(): MutableList<Empleado> {
        val query = "SELECT * FROM empleados"
        db.open()
        val result = db.select(query)
        val empleados = mutableListOf<Empleado>()
        result?.let {
            while(result.next()) {
                val empleado = Empleado(
                    idEmpleado = it.getInt("idEmpleado"),
                    nombreEmpleado = it.getString("nombreEmpleado"),
                    fechaAdmision = LocalDate.parse(it.getObject("fechaAdmision").toString()),
                    depId = it.getInt("depId")
                )
                empleados.add(empleado)
            }
        }
        db.close()
        return empleados
    }

    override fun update(entity: Empleado): Empleado {
        val query = "UPDATE empleados SET nombreEmpleado = ?, fechaAdmision = ?, depId = ? WHERE id = ?"
        db.open()
        db.update(query, entity)
        db.close()
        return entity
    }

    override fun delete(id: Int): Boolean {
        val query = "DELETE FROM empleados WHERE id =?"
        db.delete(query)
        db.close()
        return true
    }

    override fun findById(id: Int): Empleado? {
        val query = "SELECT * FROM empleados WHERE id = ?"
        db.open()
        val result = db.select(query, id)
        var empleado: Empleado? = null
        result?.let {
            if(result.next()) {
                empleado  = Empleado(
                    idEmpleado = it.getInt("idEmpleado"),
                    nombreEmpleado = it.getString("nombreEmpleado"),
                    fechaAdmision = LocalDate.parse(it.getObject("fechaAdmision").toString()),
                    depId = it.getInt("depId")
                )
            }
        }
        db.close()
        return empleado
    }
}