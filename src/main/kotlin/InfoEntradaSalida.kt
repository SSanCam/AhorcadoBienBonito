class InfoEntradaSalida : IinfoEntradaSalida {
    override fun pedirOpcion(): Int? {
        try{
            do {
                println("Introduce el número de tu opción:")
                var opcion = readLine()
                if (opcion?.toInt() in 1..<3){
                    return opcion?.toInt()
                }
            }while (opcion == null || opcion.toInt() !in 1..<3)
        }catch (e: IllegalArgumentException){
            println("Opción inválida. Inténtalo de nuevo.")
        }
        return null
    }

    override fun pedirCadena() {
        TODO("Not yet implemented")
    }

    override fun imprimirInfo(mensaje: String) {
        return println(mensaje)
    }

}