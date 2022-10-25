import controller.DepartamentoController
import controller.EmpleadosController
import db.*
import repository.DepartamentoRepository
import repository.EmpleadosRepository
import repository.IEmpleadosRepository

fun main(args: Array<String>) {
    var dep = DepartamentoController(DepartamentoRepository())
    var emp = EmpleadosController(EmpleadosRepository())
    initDataBase()
    createEmpleados().forEach { e -> emp.createEmpleado(e)}
    createDepartamentos().forEach { e -> dep.createDepartamento(e) }
    var cons = Consultas(dep, emp)
    cons.getConsultas()
}
fun initDataBase() {
    DataBaseManager.open()
    DataBaseManager.createTables(createTableEmpleados())
    DataBaseManager.createTables(createTableDepartamentos())
    DataBaseManager.close()
}