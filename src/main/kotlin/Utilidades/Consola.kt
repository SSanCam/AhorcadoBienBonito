package Utilidades

import IinfoEntradaSalida

/**
 * Clase Consola implementará métodos útiles que usaremos durante el la ejecición del programa para pedir o recibir datos.
 *
 */
class Consola : IinfoEntradaSalida {

    private var opcion: Int? = null
    override fun pedirOpcion(): Int? {
        try {
            do {
                opcion = pedirDato("Introduce el número de tu opción:")?.toInt()
            } while (opcion.toString().isBlank() || opcion !in 1..<3)

        } catch (e: IllegalArgumentException) {
            imprimirInfo("Ésa opción no está disponible.")
        }
        return opcion
    }

    override fun pedirDato(mensaje: String): String? {
        try {
            if (mensaje.isNotBlank()) {
                imprimirInfo(mensaje)
            }
        }catch (e: Exception){
            imprimirInfo("ERROR al recibir los datos del usuario.")
        }
        return readLine()
    }

    override fun imprimirInfo(mensaje: Any): String {
        return println(mensaje).toString()
    }

    override fun limpiar(lineas: Int) {
        for (linea in 1..lineas) {
            imprimirInfo("")
        }
    }

}
