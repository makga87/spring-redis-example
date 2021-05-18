package stream;

import org.junit.jupiter.api.Test;
import stream.Employee;

import java.util.*;
import java.util.function.Function;
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

    @Test
    public void 리스트_VO로_변환() {

        List<String> nameList = Arrays.asList("김코드", "박개발", "경영만", "최경영");

        List<Employee> employeeList = nameList.stream()
                .map(name -> {
                    Employee employee = new Employee();
                    employee.setName(name);
                    return employee;
                })
                .collect(Collectors.toList());

        employeeList.forEach(e -> {
            System.out.println(e.getName());
        });

    }

    @Test
    public void 리스트_COLLECTORS_TO_MAP_변환() {

        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        // Collectors.toMap의 마지막 인자는 중복키 처리
        Map<String, Employee> deptMap = employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (key1, key2) -> key1));

        deptMap.forEach((key, value) -> {

            StringBuilder sb = new StringBuilder();
            sb.append(key).append(" : ")
                    .append(value.getDepartment()).append(", ")
                    .append(value.getName()).append(", ")
                    .append(value.getAge()).append("\n");

            System.out.print(sb.toString());
        });
    }

    @Test
    public void 리스트_COUNT() {
        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        long count = employees.stream()
                .filter(emp-> emp.getDepartment().startsWith("기술"))
                .count();

        System.out.println(count);
    }
}