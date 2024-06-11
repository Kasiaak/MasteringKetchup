package day4

/*
lvl 3 - (jeśli znasz już typy funkcyjne) Utwórz funkcję rozszerzającą List<T>
o nazwie safeGetOrElse(index: Int, defaultProvider: () -> T): T,
która zwróci element listy o podanym indeksie, jeśli indeks jest prawidłowy i element nie jest null.
W przeciwnym razie powinna wywołać podaną funkcję defaultProvider i zwrócić jej wynik.
 */

fun <T> List<T>.safeGetOrElse(index: Int, defaultProvider: () -> T): T =
    takeIf { index in indices }?.get(index = index) ?: defaultProvider.invoke()

fun main() {
    val list = listOf("Apple", null, "Banana", "Orange")

    println(list.safeGetOrElse(3) { "Grape" }) // Wynik: "Orange"
    println(list.safeGetOrElse(4) { "Grape" }) // Wynik: "Grape"
}