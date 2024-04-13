import Utilidades.Consola

fun main() {
    val consola = Consola()
    val generadorSerie = GestorGenerarSerie(TipoSerie.CRECIENTE, consola)

    generadorSerie.generarSerie()
}