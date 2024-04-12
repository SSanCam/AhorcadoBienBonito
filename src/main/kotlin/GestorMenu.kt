class MostrarMenu {
    private fun obtenerOpcion(): Int{
        // TODO pedir entero entre 1..3
    }
    val menu = """
        1. Generar serie.
        2. Jugar ahorcado.
        3. Salir.
        Por favor, selecciona una opción 
    """
    var opcion = obtenerOpcion()

    when(opcion){
        1 -> GenerarSerie()
        2 -> JugarAhorcado()
        3 -> "Saliendo del programa"
        else -> "Opción inválida"
    }
}