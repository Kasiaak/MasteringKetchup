package day3

/*
 * Wyobraź sobie, że tworzysz aplikację do zarządzania zamówieniami w sklepie internetowym. Zaimplementuj następujące struktury:
 *
 * 1. Stwórz`sealed class``Order`z następującymi klasami potomnymi:
 *     - `Confirmed`z polem`orderNumber`
 *     - `Cancelled`z polem`reason`
 * 2. Stwórz`sealed interface``Payment`z następującymi implementacjami:
 *     - `Cash`(bez dodatkowych pól)
 *     - `Card`z polem`cardNumber`
 * 3. Dodaj pole`payment`typu do klasy`Order`.
 * 4. Stwórz funkcję`processOrder`, która przyjmuje instancję`Order`i wykonuje odpowiednie działania w zależności od typu zamówienia i płatności.
 * Na przykład, dla`Order.Confirmed`z płatnością`Cash`, wypisz "Zamówienie potwierdzone, płatność gotówką".
 * 5. Stwórz kilka instancji`Order`z różnymi typami i płatnościami, a następnie wywołaj funkcję`processOrder`dla każdego z nich.
 */

sealed class Order(private val payment: Payment) {
    data class Confirmed(val orderNumber: String, val payment: Payment) : Order(payment = payment)
    data class Cancelled(val reason: String, val payment: Payment) : Order(payment = payment)
}

    sealed interface Payment {
        data object Cash : Payment
        data class Card(val cardNumber: Int) : Payment
    }

    fun processOrder(order: Order) =
        when (order) {
            is Order.Confirmed -> {
                when (order.payment) {
                    is Payment.Cash -> println("Zamówienie potwierdzone, płatność gotówką")
                    is Payment.Card -> println("Zamówienie potwierdzone, płatność kartą")
                }
            }

            is Order.Cancelled -> {
                when (order.payment) {
                    is Payment.Cash -> println("Zamówienie anulowane, powód: ${order.reason}, płatność gotówką")
                    is Payment.Card -> println("Zamówienie anulowane, powód: ${order.reason}, płatność kartą")
                }
            }
        }


fun main() {
    val orders = listOf(
        Order.Confirmed(orderNumber = "a1a2a3a4", Payment.Cash),
        Order.Cancelled(reason = "out of stock", Payment.Card(cardNumber = 121211132)),
        Order.Confirmed(orderNumber = "test", Payment.Cash),
    )

    orders.forEach { processOrder(order = it) }
}

