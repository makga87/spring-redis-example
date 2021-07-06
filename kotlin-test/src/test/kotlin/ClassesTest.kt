import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class ClassesTest {
    data class User(val name: String, val id: Int) {
        override fun equals(other: Any?): Boolean {
            return other is User && other.id == this.id
        }
    }

    @Test
    fun dataClassTest1() {
        val user = User("Alex", 1)
        println(user)

        val secondUser = User("Alex", 1)
        val thirdUser = User("Max", 2)

        println("user == secondUser: ${user == secondUser}")
        println("user == thirdUser: ${user == thirdUser}")

        println(user.hashCode())
        println(secondUser.hashCode())
        println(thirdUser.hashCode())

        println(user.copy())
        println(user === user.copy())
        println(user.copy("Max"))
        println(user.copy(id = 3))

        println("name = ${user.component1()}")
        println("id = ${user.component2()}")
    }

    enum class State {
        IDLE, RUNNING, FINISHED
    }

    @Test
    fun enumClassTest1() {
        val state = State.RUNNING

        val message = when (state) {
            State.IDLE -> "It is idle"
            State.RUNNING -> "It is running"
            State.FINISHED -> "It is finished"
        }

        println(message)
    }

    enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF),
        YELLOW(0xFFFF00);

        fun containsRed() = (this.rgb and 0xFF0000 != 0)
    }

    @Test
    fun enumClassTest2(){
        val red = Color.RED
        println(red)
        println(red.containsRed())
        println(Color.BLUE.containsRed())
        println(Color.YELLOW.containsRed())
    }

    sealed class Mammal(val name:String)

    class Cat(val catName : String) : Mammal(catName)
    class Human(val humanName : String, val job : String) : Mammal(humanName)

    fun greetMammal(mammal : Mammal) : String {
        when (mammal) {
            is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"
            is Cat -> return "Hi ${mammal.name};"
        }
    }

    @Test
    fun sealedClassTest(){
        println(greetMammal(Cat("Miao")))
        println(greetMammal(Human("Mr. Park", "Developer")))
    }
}