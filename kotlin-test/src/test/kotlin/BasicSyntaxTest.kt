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

    @Test
    fun collectionTest() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        /**
         * 처음 걸리는 조건에 대해서만 출력을 한다.
         */
        when {
            1 in numbers -> println("number one")
            2 in numbers -> println("number two")
        }

        numbers
            .filter { num -> num % 2 == 0 }
            .map { num -> num * 10 }
            .forEach { num -> println(num) }
    }

    @Test
    fun takingFunctionAsParameter() {
        val test1 = calculate(4, 6, ::sum)
        println(test1)
        val test2 = calculate(4, 6) { a, b -> a * b }
        println(test2)
    }

    fun sum(x: Int, y: Int) = x + y;

    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }
}