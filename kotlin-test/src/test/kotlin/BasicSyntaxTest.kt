import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class BasicSyntaxTest {

    @Test
    fun printTest() {
        println("Hello World");
    }

    @Test
    fun functionTest() {
        val a = 3;
        val b = 9;
        println("sum1 returns ${sum1(a, b)}");
        println("sum2 returns ${sum2(a, b)}");
        printSum(a, b);
    }

    fun sum1(a: Int, b: Int): Int {
        printSum(a, b);
        return a + b;
    }

    fun sum2(a: Int, b: Int) = a + b;

    // Unit 타입은 Java의 Void 와 같다.
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}");
    }
}