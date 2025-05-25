package collection

// 불필요한 import문이 없어짐

fun main() {
    // 불변 array(컬렉션이 존재)
    list()

    set()

    map()

}

private fun map() {
    val readOnlyJuiceMenu = mapOf("apple" to 100, "orange" to 190)
    println(readOnlyJuiceMenu)

    val mutableJuiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "orange" to 190)
    mutableJuiceMenu["melon"] = 200
    mutableJuiceMenu.remove("apple")
}

private fun set() {
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana")
    val fruit2 = fruit

    println("$fruit, $fruit2, ${fruit == fruit2}")
    fruit.remove("apple")
}

private fun list() {
    val readOnlyShapes = listOf("필라", "테스")
    println(readOnlyShapes)
    println(readOnlyShapes[0])
    var test = readOnlyShapes[0];
    test = "테스트";
    println("readOnlyShapes : ${readOnlyShapes[0]} , test : $test")
    println("readOnlyShapes : ${"필라" in readOnlyShapes}")

    val shapes: MutableList<String> = mutableListOf("필라", "테스")
    shapes[0] = "테스트"

    println("shapes : $shapes")
    println("shapes : ${"필라" in shapes}")
    val emptyList: MutableList<String> = mutableListOf()
    // out of index 가 발생할 수 있음.
    // println("emptyList : ${emptyList[0]}")
    // println("emptyList : ${emptyList.first()}")
}