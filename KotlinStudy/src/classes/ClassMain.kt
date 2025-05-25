package classes

fun main() {
    // val 로 선언한 Object는 참조를 변경할 수 없음
    val contact = Contact(1, "taehyun@naver.com")
    val contact2 = Contact(1, "taehyun@naver.com")

    println("contact is $contact , contact2 is $contact2 equal to ${contact == contact2}, ${contact === contact2}")
    println(contact.email)

    contact.email = "test@naver.com"

    println(contact.email)

    // data class는 객체 상태를 변경할 수 없음. copy가 가능함
    val user = User("text", 11)
    val user2 = User("text", 11)
    val user3 = user.copy()

    println("User is $user , User2 is $user2 equal to ${user == user2}, ${user === user2}")

    val person = Person("taehyun", 19)

    person.age = 123
    //  person.name = "test"
    println(person.address?.city)
    println(person.address?.street?: "seoul")

}