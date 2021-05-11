package test;

import org.junit.jupiter.api.Test;
import stream.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTest {

    @Test
    public void 리스트_문자열_인트형으로_변환() {

        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> integerList = stringList.stream()
                .map(data -> {
                    return Integer.parseInt(data);
                })
                .peek(data -> System.out.println(data.getClass().getName() + " : " + data))
                .collect(Collectors.toList());

    }

    @Test
    public void 리스트_필터링() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        integerList.stream()
                .peek(data -> System.out.println("인입된 데이터 : " + data))
                .filter(data -> data % 2 == 0)
                .peek(data -> System.out.println("출력된 데이터 : " + data))
                .collect(Collectors.toList());
    }

    @Test
    public void 리스트_DISTINCT() {

        List<String> stringList = Arrays.asList("A", "a", "B", "B", "C", "C", "c");

        System.out.println("== DISTINCT ==");

        stringList.stream()
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("== TO_UPPERCASE DISTINCT ==");

        stringList.stream()
                .map(data -> data.toUpperCase())
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    @Test
    public void 리스트_GROUP_BY() {

        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        Map<String, List<Employee>> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupByDept.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}