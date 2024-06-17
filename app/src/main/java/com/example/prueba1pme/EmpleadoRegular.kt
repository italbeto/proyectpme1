package com.example.prueba1pme

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val retencion = sueldoBruto * 0.20
        return sueldoBruto - retencion
    }
}
