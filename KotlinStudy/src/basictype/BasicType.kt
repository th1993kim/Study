package basictype

fun main() {
    var number: Int = 0;
    val number2: Int = 10;

    //    number2 = 30; readonly
    number = 15;


    string()
    number()
    array()
    typeChecking()

}

fun typeChecking() {
    val obj = "test"

    if (obj is String) {
        println("Is String $obj")
    }

    test(obj)


    val y = 123
    val x : String = y as String

}

fun test(x: Any) {
    if (x is String) { //암시적 타입 변환 (스마트 캐스트)
        print(x.length)
    }

    if (x !is String || x.length ==0 ) return
}

fun array() {
    println("Array Chapter==================")
    val testArray = arrayOf(1,2,3)
    println(testArray.joinToString())

    val nullArray: Array<Int?> = arrayOfNulls(3)
    println(nullArray.joinToString())

    val emptyArray = emptyArray<String>()
    val emptyArray2: Array<Int> = emptyArray()
    val emptyArray3: Array<Int?> = emptyArray()

    val asc = Array(5) {i -> (i * i)}
    asc.forEach { println(it) }

    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray) //가변 문자 배열, ...와 동일?


    val firstArray = arrayOf("a", "b", "c")
    val secondArray = arrayOf("a", "b", "c")
    val thirdArray = arrayOf("a", "b", "d")

    println(firstArray.contentEquals(secondArray))
    println(firstArray.contentDeepEquals(secondArray))
    println(thirdArray contentEquals secondArray)

    val intArray = IntArray(5)
    val intTypeArray = intArray.toTypedArray()
    intTypeArray.toIntArray()

    println("Array Chapter==================")
}

fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }

}

private fun number() {
    println("Number Chapter==================")
    //nullable객체의 경우 캐싱을 사용한다. 따라서 -128 ~ 127은 ===으로 동일하나 그외는 다르게 나온다.
    var number5: Int? = 10824;
    var number6: Int? = 10824;

    println(number5 === number6);
    println("test ${number5 === number6}");
    if (number5 != null) {
        println("test ${number5.equals(number5)}")
    };

    var number7: Int? = 10824;
    var number8: Long? = 10824;

    if (number7 != null) {
        println(number7?.toLong() == number8)
        println(number7.equals(number8))
        //숫자라고 해서 동등성 검사가 통과하지 않을 수 있다.
    }
    println("Number Chapter==================")
}

private fun string() {
    println("String Chapter==================")
    var number3: Int = 128
    var number4: Int = 128

    //문자열 템플릿 -> 템플릿 표현식 가능 $number3, ${number3}
    println("test ${number3 === number4}")
    println("test ${number3.equals(number4)}")
    println("String Chapter==================")
}