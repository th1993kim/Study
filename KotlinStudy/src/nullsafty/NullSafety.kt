package nullsafty

fun main() {

    //
    var neverNull: String = "This can't be null"
    //  neverNull = null

    var nullable: String? = "you can be null"
    nullable = null

    var inferredNonNull = "Can't Be Null"
    //  inferredNonNull = null

    fun strLength(nonNull: String): Int {
        return nonNull.length
    }

    println(strLength(neverNull))
    //  println(strLength(nullable))

    // 메서드 내부에서 메서드 정의, 클래스 정의 둘다 가능
    class HiEveryOne(val hi : String)

    val hi = HiEveryOne("hi")

    // null safe Call
    fun describeString(maybeString: String?): Int? {
        fun test() {
            println("test")
        }
        return maybeString?.length;
    }

    print("nullsafecall ${describeString(null)}")

}

