package day2
/**
 * Stwórz nową listę zawierającą nazwy wszystkich produktów z kategorii "Odzież".
 * Stwórz nową listę zawierającą produkty, których cena jest wyższa niż 100 zł.
 * Oblicz sumę cen wszystkich produktów z kategorii "Elektronika".
 */
data class Product(val name: String, val price: Double, val category: String)


fun main() {

    val produkty = listOf(
        Product("Koszulka", 49.99, "Odzież"),
        Product("Smartfon", 999.99, "Elektronika"),
        Product("Książka", 29.99, "Książki"),
        Product("Buty", 89.99, "Odzież"),
        Product("Laptop", 1499.99, "Elektronika"),
        Product("Kurtka", 149.99, "Odzież")
    )

    //ad1
    val onlyClothes = produkty.filter{ it.category == "Odzież" }
    println(onlyClothes)

    //ad2
    val moreThan100 = produkty.filter { it.price > 100 }
    println(moreThan100)

    //ad3
    val onlyElectronics = produkty.filter { it.category == "Elektronika" }
    val totalPrice: Double = onlyElectronics.sumOf{ it.price }
    println("Total eletronics price: $totalPrice")
}