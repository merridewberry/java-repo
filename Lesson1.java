public class Lesson1 {

    public static void main(String[] args) {

        byte byteVal = -5;
        short shortVal = 32000;
        int intVal = 1234567890;
        long longVal = 112233445566778899L;
        float floatVal = 1.2f;
        double doubleVal = 1122334455.66778899;
        char charVal = 'x';
        boolean boolVal = false;
        String strVal = "abc";

        double result = expression(1.0, 2.0, 3.0, 4.0);
        System.out.println(result);

        System.out.println(isBetween10And20(5, 16));

        isPosOrNeg(0);

        System.out.println(isNegative(-5));

        greeting("Ivan");

        isLeap(2020);


    }

    public static double expression(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean isBetween10And20(int a, int b) {
        return 10 <= a + b  && a + b <= 20;
    }

    public static void isPosOrNeg(int a){
        if (a >= 0){
            System.out.println("Number " + a + " is positive.");
        }
            else {
                System.out.println("Number " + a + " is negative.");
            }
    }

    public static boolean isNegative(int a){
        return  a < 0;
    }

    public static void greeting(String a){
        System.out.println("Hi, " + a + "!");
    }

    public static void isLeap(int a){
        if (a % 400 == 0){
            System.out.println(a + " is a leap year.");
        } else if (a % 100 == 0){
            System.out.println(a + " is not a leap year.");
        } else if (a % 4 == 0){
            System.out.println(a + " is a leap year.");
        } else {
            System.out.println(a + " is not a leap year.");
        }
    }

}
