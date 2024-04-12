interface IGenerarSerie {

    // Genera el primer rango aleatorio.
    fun generarRangoAleatorio()

    // Genera la serie de forma ascendente o descendente, según el tipo.
    fun generarSerie(tipo: TipoSerie)

    // Genera la serie creciente.
    fun serieCreciente()

    // Genera la serie decreciente.
    fun serieDecreciente()

}