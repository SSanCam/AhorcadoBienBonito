import Utilidades.Consola

class GestorGenerarSerie(private var tipo: TipoSerie, private val consola: Consola) : IGenerarSerie {

    /**
     * Generar rango aleatorio
     * @return Devuelve un rango aleatorio entre 1-100, que tiene al menos 30 números entre el valor máximo y el valor mínimo.
     */
    override fun generarRangoAleatorio(min: Int, max: Int): IntRange {
        var rangoAleatorio: IntRange = min..max
        var numeroAleatorio = (min..max).random()
        if (numeroAleatorio < 30) {
            rangoAleatorio = numeroAleatorio..max
        } else if (numeroAleatorio > 70) {
            rangoAleatorio = min..numeroAleatorio
        }
        return rangoAleatorio
    }

    /**
     * Generar Serie
     * Éste método recibe un rango aleatorio, pide al usuario un número dentro de dicho rango y determina que tipo de serie (creciente o decreciente) debe crear.
     * @return Devuelve una rango Int generado a partir del método generarRangoAleatorio.
     */
    override fun generarSerie() {
        var numeroPedido: Int? = null
        var tipoSerie: TipoSerie = TipoSerie.CRECIENTE
        val rangoSerie = generarRangoAleatorio()
        try {
            do {
                // Pedimos un número que esté dentro del rango aleatorio generado:
                numeroPedido =
                    consola.pedirDato("Ingresa un número entre ${rangoSerie.first}-${rangoSerie.last}")?.toInt()

                // Indentificamos el tipo de serie que vamos a generear, según si el número ingresado se hacerca más al primer número del rango o alg último.
                tipo = if (numeroPedido != null && numeroPedido < (rangoSerie.last / 2)) {
                    TipoSerie.CRECIENTE
                } else {
                    TipoSerie.DECRECIENTE
                }
                // Llamamos a la función encargada de generar la serie según el `TipoSerie`, pasandole por parámetros el rango aleatorio creado
                if (tipoSerie == TipoSerie.CRECIENTE) {
                    consola.imprimirInfo(serieCreciente(rangoSerie))
                } else {
                    consola.imprimirInfo(serieDecreciente(rangoSerie))
                }
            } while (numeroPedido != null || numeroPedido !in rangoSerie)
        } catch (e: IllegalArgumentException) {
            consola.imprimirInfo("**ERROR**")
        } catch (e: NumberFormatException) {
            consola.imprimirInfo("Debes ingresar un número dentro del rango ${rangoSerie.first}-${rangoSerie.last}")
        }
    }

    /**
     * Serie Creciente
     * @param rangoFinal IntRange Es el rango que se ha determinado a raíz de la función `generarSerie()`
     * @return Devuelve una pirámide representada por los números del rango que se van sumando poco a poco.
     */
    override fun serieCreciente(rangoFinal: IntRange) {
        var sumaFinal: Int = 0
        var serie: String = ""

        for ((index,numero) in rangoFinal.withIndex()){
            sumaFinal += numero
            serie += serie + numero
            if (index == 0){
                numero.toString()
            } else{
                serie += "+$numero"
            }
            consola.imprimirInfo("$serie ($index)" )
        }
        consola.imprimirInfo("Suma => $sumaFinal")
    }

    override fun serieDecreciente(rangoFinal: IntRange) {
        TODO("Not yet implemented")
    }
}