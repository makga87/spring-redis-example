package stream;


public class Employee {

    private String department;
    private String name;
    private int age;

    public Employee(){
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("department=").append(this.department).append(",");
        sb.append("name=").append(this.name).append(",");
        sb.append("age=").append(this.age).append("");
        return sb.toString();
    }
}
