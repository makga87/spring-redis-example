import org.junit.jupiter.api.Assertions.*
import kotlin.reflect.KProperty
import kotlin.test.Test

internal class DelegationTest {

    interface SoundBehavior {
        fun makeSound()
    }

    class ScreamBehavior(val n: String) : SoundBehavior {
        override fun makeSound() = println("$n Scream !!!")
    }

    class RockAndRollBehavior(val n: String) : SoundBehavior {
        override fun makeSound() = println("$n Shout it out !!!")
    }

    class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)

    class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)


    @Test
    fun delegateTest1() {
        val tomAraya = TomAraya("EveryBody")
        tomAraya.makeSound()

        val elvisPresley = ElvisPresley("HelloWorld")
        elvisPresley.makeSound()
    }


    class Example {
        var p: String by Delegate()

        override fun toString() = "Example String"
    }

    class Delegate() {
        operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${prop.name} to me!"
        }

        operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
            println("$value has been assigned to ${prop.name} in $thisRef")
        }
    }

    @Test
    fun delegateTest2() {
        val example = Example()
        println(example.p)
        example.p = "NEW"
    }

    class LazySample {
        init {
            println("created!")
        }

        val lazyStr: String by lazy {
            println("computed!")
            "my lazy"
        }
    }

    @Test
    fun delegateTest3() {
        val sample = LazySample()
        println("lazyStr = ${sample.lazyStr}")
        println(" = ${sample.lazyStr}")
    }

    class User(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int by map
    }

    @Test
    fun delegateTest4() {
        val user = User(
            mapOf(
                "name" to "John Doe",
                "age" to 25
            )
        )
        println("name = ${user.name}, age = ${user.age}")
    }

}