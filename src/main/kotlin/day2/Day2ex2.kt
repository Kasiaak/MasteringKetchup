package day2

/*
Pogrupuj studentów według ich ocen, tworząc mapę, gdzie kluczem jest ocena, a wartością lista studentów z tą oceną.
 */
data class Student(val name: String, val grade: Int)

val students = listOf(
    Student("Jan", 4),
    Student("Anna", 5),
    Student("Piotr", 3),
    Student("Ewa", 5),
    Student("Tomasz", 4),
    Student("Kasia", 3)
)

fun main() {
    println(students.groupBy { it.grade }.toSortedMap())
}