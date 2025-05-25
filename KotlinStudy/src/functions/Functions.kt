package functions

fun main() {

    println({text : String -> text.uppercase()} ("hello"))

    println(listOf(1,2,3).fold(1){x, y -> x + y})
}