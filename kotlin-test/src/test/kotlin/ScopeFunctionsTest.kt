import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class ScopeFunctionsTest {

    val empty = "test".let {
        println("let $it")
        it.isEmpty()
    }

    @Test
    fun letTest1() {
        println(" is empty : $empty")
    }
}