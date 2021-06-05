package functional;

import org.junit.jupiter.api.Test;

import java.util.function.*;

public class FunctionApiTest {

    @FunctionalInterface
    public interface FunctionApi {
        void execute(int a, int b);
    }

    @Test
    void FUNTIONAL_INTERFACE_TEST() {
        FunctionApi functionApi = (a, b) -> {
            System.out.println(a + b);
        };

        functionApi.execute(5, 2);
    }

    @Test
    void SUPPLIER_TEST() {
        Supplier<String> supplier = () -> "Supplier는 return 값만 있다.";
        System.out.println(supplier.get());
    }

    @Test
    void CONSUMER_TEST() {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("Consumer는 input 값만 있고, return 값은 없다.");
    }

    @Test
    void FUNCTION_TEST() {
        Function<String, Integer> function = (str) -> str.length();
        System.out.println(function.apply("Function은 1개의 input과 return값을 가진다."));
    }

    @Test
    void PREDICATE_TEST() {
        Predicate<String> predicate = (str) -> str.contains("a");
        System.out.println(predicate.test("Predicate는 1개의 input과 boolean 타입의 return값을 가진다."));
    }

    @Test
    void UNARYOPERATOR_TEST() {
        UnaryOperator<String> unaryOperator = (str) -> str + "동일한 타입의 input과 return값을 가진다.";
        System.out.println(unaryOperator.apply("UnaryOperator는"));
    }

    @Test
    void BINARYOPERATOR_TEST() {
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("BinaryOperator는", " 2개의 동일한 타입의 input을 받고, 같은 타입 데이터를 return"));
    }

    @Test
    void BIPREDICATE_TEST() {
        BiPredicate<String, Integer> biPredicate = (str, num) -> str.length() == num;
        System.out.println(biPredicate.test("abcdefg", 7));
    }

    @Test
    void BICONSUMER_TEST() {
        BiConsumer<String, Integer> biConsumer = (str, num) -> System.out.println(str + " " + num);
        biConsumer.accept("BiConsumer는 서로다른 타입의 인자를 2개 받고 void 타입이다.", 100);
    }
}
