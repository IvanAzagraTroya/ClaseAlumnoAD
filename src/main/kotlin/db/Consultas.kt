package db

import controller.DepartamentoController
import controller.EmpleadosController

class Consultas(
    val departamentoController: DepartamentoController,
    val empleadosController: EmpleadosController
) {
    fun getConsultas() {

//        todo meter la inicialización de los empleados y departamentos

        var empleadosPorFecha = empleadosController.getEmpleados()
            .sortedBy { it.fechaAdmision }

        var empleadosPorDep = empleadosController.getEmpleados()
            .sortedBy { it.fechaAdmision }.sortedBy { it.depId}

        var empleadoMenorVeterania = empleadosPorFecha.minBy { it.fechaAdmision }
        var empleadoMayorVeterania = empleadosPorFecha.maxBy { it.fechaAdmision}
        println("Empleado menor: $empleadoMenorVeterania")
        println("Empleado mayor: $empleadoMayorVeterania")
        var empleadoMenorVeteraniaDep = empleadosPorDep.minBy { it.fechaAdmision }
        var empleadoMayorVeteraniaDep = empleadosPorDep.maxBy { it.fechaAdmision }
        println("empleado menor por departamento: $empleadoMenorVeteraniaDep")
        println("empleado mayor por departamento: $empleadoMayorVeteraniaDep")

        var departamentos = departamentoController.getDepartamentos()
            .sortedBy { it.idDepartamento}
        var mediaPresupuesto = departamentos.map { it.presupuesto }.sum().div(departamentos.size)
        println("media: $mediaPresupuesto")
//        todo número de empleados que tiene cada departamento
        var empleadosDepartamento = empleadosPorDep.groupBy { it.depId }.count()
        println("Número de empleados por departamento: $empleadosDepartamento")
//        todo empleados que trabajan en el departamento con más presupuesto
        var depPresupuesto = departamentos.sortedBy { it.idDepartamento }.maxOf { it.presupuesto }
        var empleadosDepPresupuesto = empleadosPorDep.groupBy { depPresupuesto}
        println("Número de empleados en el departamento con mayor presupuesto: $empleadosDepPresupuesto")
    }
}