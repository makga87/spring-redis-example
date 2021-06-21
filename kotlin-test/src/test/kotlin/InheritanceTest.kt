import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class InheritanceTest {

    open class Person {
        open fun say() {
            println("WOW!");
        }
    }

    class Korean : Person() {
        override fun say() {
            println("We are korean");
        }
    }

    @Test
    fun inHeritanceTest() {
        val person : Person = Korean();
        person.say();
    }
}