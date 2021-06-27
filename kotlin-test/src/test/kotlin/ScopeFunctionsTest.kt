import org.junit.jupiter.api.Assertions.*
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
    fun runTest1(){
        val string = "abcdefg"
        string.run {
            println(isEmpty())
            println(this) // let과 다르게 상수값이 나온다.
            println(length)
        }
    }
}