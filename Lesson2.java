import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {

        int[] array1 = {1, 0, 0, 1, 1, 1, 0};
        System.out.println("Task 1: \n" + Arrays.toString(array1));
        for (int i = 0; i < 7; i++) {
            switch (array1[i]) {
                case 1:
                    array1[i] = 0;
                    break;
                default:
                    array1[i] = 1;
            }
           /* Java уже сообщила мне, что использовать switch тут не особо осмысленно,
           но надо же было его хоть куда-нибудь приткнуть. Но с if я тоже сделала:
           if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            } */
        }
        System.out.println(Arrays.toString(array1) + "\n");


        int arr2Len = 8;
        int[] array2 = new int[arr2Len];
        for (int i = 0; i < arr2Len; i++) {
            array2[i] = i * 3;
        }
        System.out.println("Task 2: \n" + Arrays.toString(array2) + "\n");


        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Task 3: \n" + Arrays.toString(array3));
        for (int i = 0; i < 12; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array3) + "\n");


        int arr4Len = 5;
        int[][] array4 = new int[arr4Len][arr4Len];
        for (int i = 0; i < arr4Len; i++) {
            Arrays.fill(array4[i], 0);
        }
        for (int i = 0; i < arr4Len; i++) {
            for (int j = 0; j < arr4Len; j++) {
                if (i == j || i + j == arr4Len - 1) {
                    array4[i][j] = 1;
                }
            }
        }
        System.out.println("Task 4:");
        for (int i = 0; i < arr4Len; i++) {
            System.out.println(Arrays.toString(array4[i]));
        }
        System.out.println("\n");


        int min = array3[0];
        int max = array3[0];
        for (int i = 0; i < 12; i++) {
            if (array3[i] < min) {
                min = array3[i];
            }
            if (array3[i] > max) {
                max = array3[i];
            }
        }
        System.out.println("Task 5: \n" + "Array: " + Arrays.toString(array3));
        System.out.println("Minimum value in array is " + min);
        System.out.println("Maximum value in array is " + max + "\n");


        int[] array5 = {1, 2, 0, 1, 2};
        int[] array6 = {9, 0, 1, 2, 3, 1, 1, 1};
        int[] array7 = {1, 2, 0, 1, 9};
        System.out.println("Task 6: \n" + "Array: " + Arrays.toString(array5) + " " + isEqual(array5));
        System.out.println("Array: " + Arrays.toString(array6) + " " + isEqual(array6));
        System.out.println("Array: " + Arrays.toString(array7) + " " + isEqual(array7) + "\n");


        int[] array8 = {1, 2, 3, 4, 5};
        moveArray(array8, 2);
        System.out.println("Task 7: \n" + Arrays.toString(array8));
        int[] array9 = {1, 2, 3, 4, 5};
        moveArray(array9, -2);
        System.out.println(Arrays.toString(array9));
        int[] array10 = {1, 2, 3, 4, 5};
        moveArray(array10, 0);
        System.out.println(Arrays.toString(array10) + "\n");

        System.out.println("Extra task:");
        makeSpiral(10, 10);



    }

    public static boolean isEqual(int[] arr) {
        int left = arr[0];
        int right = 0;
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            right = right + arr[i];
        }
        while (left < right && index < arr.length) {
            left = left + arr[index];
            right = right - arr[index];
            index++;
        }
        return left == right;
    }

    public static void moveArray(int[] arr, int n) {
        if (n > 0) {
            moveArrayRight(arr, n);
        } else {
            moveArrayLeft(arr, n);
        }

    }

    public static void moveArrayLeft(int[] arr, int n) {
        n = n * -1;
        for (int i = 0; i < n; i++) {
            int first = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = first;
        }
    }

    public static void moveArrayRight(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int last = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }
    }

    public static void makeSpiral (int h, int w) {
        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(arr[i], 0);
        }
        arr[0][0] = 1;
        int previous = 1;
        int hor = 0;
        int vert = 0;
        int state = 0;
        while (previous < h * w) {
           switch (state) {
               case 0:
                   vert++;
                   break;
               case 1:
                   hor++;
                   break;
               case 2:
                   vert--;
                   break;
               case 3:
                   hor--;
                   break;
           }
           if (vert > h - 1 || hor > w - 1 || vert < 0 || hor < 0 || arr[vert][hor] != 0) {
               switch (state) {
                   case 0:
                       vert--;
                       break;
                   case 1:
                       hor--;
                       break;
                   case 2:
                       vert++;
                       break;
                   case 3:
                       hor++;
                       break;
               }
               state++;
               state = state % 4;
           } else {
               arr[vert][hor] = previous;
               previous++;
           }

            for (int i = 0; i < h; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println();
        }
        arr[0][0] = 0;
        for (int i = 0; i < h; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}
