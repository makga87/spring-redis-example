package functional;

import org.junit.jupiter.api.Test;

public class FunctionApiTest {

    @FunctionalInterface
    public interface FunctionApi {
        void execute(int a, int b);
    }

    @Test
    void functionApiTest() {
        FunctionApi functionApi = (a, b) -> {
            System.out.println(a + b);
        };

        functionApi.execute(5, 2);
    }
}
