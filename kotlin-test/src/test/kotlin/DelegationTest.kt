import org.junit.jupiter.api.Assertions.*
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

}