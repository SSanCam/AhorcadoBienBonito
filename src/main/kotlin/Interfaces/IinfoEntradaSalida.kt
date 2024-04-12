interface IinfoEntradaSalida {

    // Pide un número entero.
    fun pedirOpcion(): Int?

    // Pide un dato que devuelve como tipo String
    fun pedirCadena(): String

    // Sustituye la función println()
    fun imprimirInfo(mensaje: Any) : String

    // Limpia la terminal de salida del IDE
    fun limpiar()
}