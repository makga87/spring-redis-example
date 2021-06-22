import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class PropertiesTest {

    class TestVo {
        var testString1: String = "abc"

        var testString2: String = "It"
            get() = field
            set(value: String) {
                field = "$field $value"
            }
        val testString3: String = "Hello"
            get() = "$field world"
    }

    @Test
    fun testGetterSetter() {
        val testVo = TestVo()

        println(testVo.testString1)
        println(testVo.testString2)
        testVo.testString2 = "is getter setter test"
        println(testVo.testString2)
        println(testVo.testString3)
    }

}