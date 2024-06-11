package day4

/*
lvl 2 - Utwórz funkcję rozszerzającą List<T> o nazwie safeGetOrDefault(index: Int, default: T): T,
która zwróci element listy o podanym indeksie, jeśli indeks jest prawidłowy i element nie jest null.
W przeciwnym razie powinna zwrócić podaną wartość domyślną.
 */

fun <T> List<T>.safeGetOrDefault(index: Int, default: T): T =
    takeIf { index in indices }?.get(index = index) ?: default

fun main() {
    val list = listOf("Apple", null, "Banana", "Orange")

    println(list.safeGetOrDefault(1, "Default")) // Wynik: "Default"
    println(list.safeGetOrDefault(2, "Default")) // Wynik: "Banana"
}
