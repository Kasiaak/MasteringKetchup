package day4

/*
lvl 1 - Utwórz funkcję rozszerzającą List<T> o nazwie safeGet(index: Int): T?,
która zwróci element listy o podanym indeksie, jeśli indeks jest prawidłowy i element nie jest null.
W przeciwnym razie powinna zwrócić null.
 */

fun <T> List<T>.safeGet(index: Int): T? = takeIf { index in 0 until size }?.get(index = index)

fun main() {
    val list = listOf("Apple", null, "Banana", "Orange")

    println(list.safeGet(0)) // Wynik: "Apple"
    println(list.safeGet(1)) // Wynik: null
    println(list.safeGet(4)) // Wynik: null
}