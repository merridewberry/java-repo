import java.util.Arrays;

public class Lesson5 {

    public static void main(String[] args) {

        Employee id1 = new Employee("Andrew Andrews", "janitor", "aandrews@mail.com",
                "1234567890", 30000, 30);

        Employee[] empArray = new Employee[5];

        empArray[0] = id1;
        empArray[1] = new Employee("Beth Betham", "head janitor", "bbetham@mail.com",
                "0987654321", 40000, 40);
        empArray[2] = new Employee("Clint Clinton", "junior janitor", "cclinton@mail.com",
                "3216549870", 20000, 20);
        empArray[3] = new Employee("Eve Whatshername", "one more janitor", "whateve@mail.com",
                "7894561230", 30000, 45);
        empArray[4] = new Employee("Frank Franklin", "yet another janitor because it's rather messy in here",
                "ffranklin@mail.com", "7777777777", 35000, 50);

        printEmpArray(empArray);
        olderThan40(empArray);

    }

    private static void printEmpArray(Employee[] empArray) {
        System.out.println("Full list of employees:");
        for (int i = 0; i < empArray.length; i++) {
            empArray[i].printInfo();
        }
        System.out.println("\n\n");
    }

    private static void olderThan40(Employee[] empArray) {
        System.out.println("These employees are older than 40 years of age:");
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() >= 40) {
                empArray[i].printInfo();
            }
        }
        System.out.println("\n\n");
    }

}
