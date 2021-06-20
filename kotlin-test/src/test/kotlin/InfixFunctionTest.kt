import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class InfixFunctionTest {

    /**
     * Infix는 두 개의 변수 가운데 오는 함수를 의미한다.
     *
     * 반드시 한 개의 파라메터만 갖는 함수로 작성한다.
     */

    @Test
    fun stringAddInfixFunction(): Unit {
        println("Hello" add "World")
    }

    infix fun String.add(str: String): String {
        return this + str;
    }
}