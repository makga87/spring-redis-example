import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeLombokTest {


    @Test
    void EqualsAndHashCode_HashSet_비교() {

        EmployeeLombok employee = EmployeeLombok.builder()
                .id(1)
                .dept("개발팀")
                .name("김개발")
                .build();

        HashSet<EmployeeLombok> employees = new HashSet<>();
        employees.add(employee);

        System.out.println(employees.contains(employee));
        employee.setDept("경영팀");

        System.out.println(employees.contains(employee));
    }

    @Test
    void EqualsAndHashCode_ArrayList_비교() {

        EmployeeLombok employee = EmployeeLombok.builder()
                .id(1)
                .dept("개발팀")
                .name("김개발")
                .build();

        ArrayList<EmployeeLombok> employees = new ArrayList<>();
        employees.add(employee);

        System.out.println(employees.contains(employee));
        employee.setDept("경영팀");

        System.out.println(employees.contains(employee));
    }

    @Test
    void EqualsAndHashCode_Hashtable_비교() {

        EmployeeLombok employee = EmployeeLombok.builder()
                .id(1)
                .dept("개발팀")
                .name("김개발")
                .build();

        Hashtable<Integer, EmployeeLombok> employees = new Hashtable<>();
        employees.put(1, employee);

        System.out.println(employees.contains(employee));
        employee.setDept("경영팀");

        System.out.println(employees.contains(employee));
    }

    @Test
    void EqualsAndHashCode_HashMap_비교() {

        EmployeeLombok employee = EmployeeLombok.builder()
                .id(1)
                .dept("개발팀")
                .name("김개발")
                .build();

        HashMap<Integer, EmployeeLombok> employees = new HashMap<>();
        employees.put(1, employee);

        System.out.println(employees.containsValue(employee));
        employee.setDept("경영팀");

        System.out.println(employees.containsValue(employee));
    }

}