package controlflow

fun main() {

    // when 은 case문과 동일한가?
    val obj = "Hello"
    when (obj) {
        "1" -> println("one")
        "Hello" -> println("Greeting")
        else -> println("unknown")
    }

}