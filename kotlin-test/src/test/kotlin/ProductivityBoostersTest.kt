import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class ProductivityBoostersTest {

    @Test
    fun destructuringDeclarationsTest1() {
        val (x, y, z) = arrayOf(5, 10, 15)
        println("$x, $y, $z")

        val map = mapOf("Alice" to 21, "Bob" to 25)
        for ((name, age) in map) {
            println("$name is $age years old")
        }
    }
}