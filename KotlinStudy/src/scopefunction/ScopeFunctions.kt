package scopefunction


class Client() {
    var token: String? = null
    val test: String? = null
    fun connect() {
        println("connected")
    }

    fun authenticate() = println("authenticated")

    fun getData(): String = "Mock Data"
}

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}

fun sendNotification(recipientAddress: String): String {
    println("Yo $recipientAddress!")
    return "Notification sent!"
}

fun getNextAddress(): String {
    return "sebastian@jetbrains.com"
}

fun main() {
    // let 스코프 nullable한 값으로 저장하는 경우, null검사 후 not null 값을 가지는 함수를 호출 할 수 있다.
    val address: String? = getNextAddress()
    if (address != null) {
        sendNotification(address)
    } else {

    }


    // apply 스코프 생성시 범위를 생성하여, 인스턴스를 직접 접근하지 않고, 해당 속성이나 함수에 엑세스 할 수 있다.
    val client = Client()
    client.token = "token"
    client.connect()
    client.authenticate()
    client.getData()

    val client2 = Client().apply {
        token = "token2"
        connect()
        authenticate()
    }

    println("client2 created")
    client2.getData()

    // Run 스코프 인스턴스 내부 로직처리를 실행 결과를 반환해준다. (return type이 있는 경우 마지막 메서드가 retun type이 존재해야한다.)
    val client3 = Client().apply {
        token = "token3"
    }

    val result: String = client3.run {
        connect()
        authenticate()
        getData()
    }

    //also 스코프 stream 연산 중간중간에 추가 적용을 할 수 잇음 (코드 주요 흐름에 영향을 주지않는)
    val medals: List<String> = mutableListOf("Golf", "Silver", "Bronze")

    // it으로 오브젝트에 접근할 수 있음. 람다로 넘긴 변수는 불변이기 때문에 참조 자체를 변경못하나, 객체 필드는 변경 할 수 있음
    val reversed = medals
        .map { it.uppercase() }
        .also { println(it) }
        .filter { it.length > 4 }
        .also { println(it) }
        .reversed()
//        .forEach { text -> text = "1234"  }


    println("medals: $reversed")

    // with 스코프

    val mainMonitorSecondaryBufferBackedCanvas = Canvas()
    with(mainMonitorSecondaryBufferBackedCanvas) {
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        circ(40, 60, 25)
        text(15, 45, "Hello")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)
        text(35, 55, "World")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
        text(50, 70, "Kotlin")
    }
}

