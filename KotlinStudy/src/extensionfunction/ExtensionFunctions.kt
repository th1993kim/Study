package extensionfunction



fun main() {
    val readOnlyShapes = listOf("traingle", "square", "circle")
    println("The First Item In The List is: ${readOnlyShapes.first()}")

    val test = "test"

    // 이미 존재하는 클래스에 함수를 확장
    fun String.bold(): String = "<b>$this</b>"

    val hi = "reaction"
    println(hi.bold());


    fun HttpClient.get(url: String, multiValueMap: Map<String, String>): extensionfunction.HttpClient.HttpResponse = request(method = "GET", url = "test", multiValueMap = emptyMap())
}

class HttpClient {

    fun request(method: String, url: String, multiValueMap: Map<String, String>): HttpResponse {
        return HttpResponse()
    }

    class HttpResponse {

    }
}