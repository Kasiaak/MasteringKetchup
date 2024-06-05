package day3

/*
* Wyobraź sobie, że tworzysz aplikację do zarządzania biblioteką. Zaimplementuj następujące klasy i obiekty:
 *
 * 1. Stwórz`data class``Book`z polami`title`,`author`i`publishDate`.
 * 2. Stwórz klasę`Library`z następującymi elementami:
 *     - Właściwość`books`przechowująca listę książek.
 *     - Metodę`addBook`umożliwiającą dodawanie nowej książki do biblioteki.
 *     - Metodę`listBooks`wypisującą wszystkie książki w bibliotece.
 * 3. Stwórz`object``Config`z właściwością`maxBooks`określającą maksymalną liczbę książek, jakie mogą być przechowywane w bibliotece.
 * 4. W klasie`Library`dodaj logikę, która nie pozwoli na dodanie nowej książki, jeśli liczba książek osiągnie`maxBooks`.
 * 5. Stwórz kilka instancji`Book`i dodaj je do`Library`. Następnie wywołaj metodę`listBooks`.
 */

data class Book(
    val title: String,
    val author: String,
    val publishDate: String,
)


class Library(
    private val books: MutableList<Book>
) {
    fun addBook(book: Book): Boolean {
        return if (books.count() < Config.MAX_BOOKS) {
            books.add(book)
            true
        } else false
    }

    fun listBooks() = println(books)

}

object Config {
    const val MAX_BOOKS = 4
}

fun main() {
    val booksToAdd = mutableListOf(
        Book(
            title = "Kotlin w akcji",
            author = "Dmitry Jemerov, Svetlana Isakova",
            publishDate = "2018-11-26"
        ),
        Book(
            title = "Atomowy Kotlin",
            author = "Bruce Eckel, Svetlana Isakova",
            publishDate = "2022-12-14"
        ),
        Book(
            title = "Mastering Kotlin for Android 14. ",
            author = "Harun Wangereka",
            publishDate = "2024-04-05"
        ),
        Book(
            title = "Android UI Development with Jetpack Compose. ",
            author = "Thomas Künneth",
            publishDate = "2023-11-03"
        ),
        Book(
            title = "Thriving in Android Development using Kotlin. ",
            author = "Gema Socorro Rodríguez",
            publishDate = "2024-07-12"
        ),
    )
    val library = Library(books = mutableListOf())
    booksToAdd.forEach {
        library.addBook(book = it)
    }
    println(library.listBooks())
}
