package stream;


public class Employee {

    private String department;
    private String name;
    private int age;

    public Employee(String department, String name, int age) {
        this.department = department;
        this.name = name;
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
