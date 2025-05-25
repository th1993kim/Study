package classes


class Person(val name: String?, var age: Int?) {
    var address: Address? = null

    class Address(val street: String, val city: String)
}