public class Employee {

    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name != null ? name.toUpperCase() : null;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("\nName: " + name + ", position: " + position + "\nEmail: " + email + "; phone number: "
                + phoneNumber + "; salary: " + salary + "; age: " + age);
    }

    public int getAge() {
        return age;
    }
}
