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
    createDepartamentos().forEach { e -> dep.createDepartamento(e) }
    createEmpleados().forEach { e -> emp.createEmpleado(e)}
    var cons = Consultas(dep, emp)
    cons.getConsultas()
}
fun initDataBase() {
    DataBaseManager.open()
    DataBaseManager.createTables(createTableDepartamentos())
    DataBaseManager.createTables(createTableEmpleados())
    DataBaseManager.close()
}