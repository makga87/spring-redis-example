package stream;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalApiTest {

    @Test
    void Optional_NULL_값_체크() {
        Employee employee = null;
        assertThrows(NullPointerException.class, () -> {
            Optional.of(employee);
        });

        Optional<Employee> employee1 = Optional.ofNullable(employee);
        assertFalse(employee1.isPresent());
    }
}