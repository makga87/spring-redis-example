package stream;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
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

    @Test
    void Optional_값변환() {
        Employee employee = new Employee("개발팀", "김갑돌", 50);
        String name1 = Optional.ofNullable(employee)
                .map(Employee::getName)
                .orElse("없음");

        System.out.println(name1);

        String name2 = Optional.ofNullable(employee)
                .map(Employee::getName)
                .filter(name -> name.equals("김순돌"))
                .orElse("없음");

        System.out.println(name2);

    }
}