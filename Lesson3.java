import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {

    protected static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        chooseGame();

    }

    public static void chooseGame() {
        while (true) {
            String answer = "y";
            System.out.println("\nIf you would like to play the Number Game, type 1." + "\nIf you would like to play " +
                    "the Word Game, type 2.");
            int a = input.hasNextInt() ? input.nextInt() : 0;
            if (a == 1) {
                while (answer.equals("y")) {
                    numberGame();
                    System.out.println("Would you like to play again? y/n");
                    answer = input.next();
                }
            } else if (a == 2) {
                while (answer.equals("y")) {
                    wordGame();
                    System.out.println("Would you like to play again? y/n");
                    answer = input.next();
                }
            } else {
                input.nextLine();
                System.out.println("Your number is incorrect, please try again.");
            }
        }
    }


    public static void numberGame() {
        int number = (int) (Math.random() * 10);
        System.out.println("\nI've picked a number between 0 and 9. Guess what it is.");
        boolean a = false;
        for (int i = 0; i < 3; i++) {
            int numGuess = input.hasNextInt() ? input.nextInt() : 0;
            if (numGuess == number) {
                System.out.println("Correct!");
                a = true;
                break;
            } else if (numGuess < number) {
                System.out.println("My number is higher.");
            } else {
                System.out.println("My number is lower.");
            }
        }
        if (!a) {
            System.out.println("You lose. My number was " + number);
        }
    }

    public static void wordGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int index = (int) (Math.random() * words.length);
        System.out.println("\nI picked one of the following words:\n" + Arrays.toString(words) + "\nGuess what it is" +
                ".\n\nIf you want to give up, type \"stop\".");
        String wordGuess = input.next();
        wordCheck(wordGuess, words[index]);
    }

    public static void wordCheck(String guess, String word) {
        char[] hint = new char[15];
        Arrays.fill(hint, '#');
        while (!(guess.equals(word))) {
            if (guess.equals("stop")) {
                chooseGame();
            }
            System.out.println("Nope! Here's a hint for you:");
            editHint(hint, guess, word);
            guess = input.next();
        }
        if (guess.equals(word)) {
            System.out.println("Correct!");
        }
    }

    public static void editHint(char[] hint, String guess, String word) {
        int checkLen = (Math.min(guess.length(), word.length()));
        for (int i = 0; i < checkLen; i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                hint[i] = guess.charAt(i);
            }
        }
        System.out.println(Arrays.toString(hint));
    }


}
