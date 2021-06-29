import kotlin.test.Test

internal class ScopeFunctionsTest {

    val empty = "test".let {
        println("let $it")
        it.isEmpty()
        println(this) // run과 다르게 주소값이 나온다.
    }

    @Test
    fun letTest1() {
        println(" is empty : $empty")
    }

    /**
     * let과 비슷하게 쓰이지만, 내부적으로 this란 개념이 존재
     */
    @Test
    fun runTest1() {
        val string = "abcdefg"
        string.run {
            println(isEmpty())
            println(this) // let과 다르게 상수값이 나온다.
            println(length)
        }
    }

    @Test
    fun withTest1() {
        val withTest = WithTest();
        println("println : ${withTest.host}${withTest.uri}")

        with(withTest) {
            println("with funtion: ${withTest.host}${withTest.uri}")
            println("with funtion: $host$uri")
        }
    }

    class WithTest() {
        val host = "http://localhost:8080"
        val uri = "/hello"
    }

    @Test
    fun applyTest1() {
        val tom = Person("Gabriel", 100, "Angel")

        val whoIsTom = tom.apply {
            name = "Tom"
            age = 35
            desc = "Web developer"
        }

        println(whoIsTom.name)
        println(whoIsTom.age)
        println(whoIsTom.desc)
    }

    @Test
    fun alsoTest1() {
        val person = Person("Gabriel", 100, "Angel")
            .also {
                println(it)
                println("${it.name}, ${it.age}, ${it.desc}")
            }
        println("${person.name}, ${person.age}, ${person.desc}")

    }

    class Person(name: String, age: Int, desc: String) {
        var name: String = name
        var age: Int = age
        var desc: String = desc
    }
}