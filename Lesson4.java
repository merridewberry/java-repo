import java.util.Arrays;
import java.util.Scanner;

public class Lesson4 {

    public static final char CH_HUMAN = 'x';
    public static final char CH_AI = 'o';
    public static final char CH_EMPTY = '•';
    public static final String EMPTY = "  ";
    public static final String FIRST_EMPTY = "   ";
    public static final String YET_ANOTHER_EMPTY = " ";
    public static final Scanner input = new Scanner(System.in);
    public static int size;
    public static char[][] map;
    public static char[][] mapCheck;
    public static char[][] mapCheck2;
    public static int[] mapCheckIndex = {0, 0};
    public static int chWin;


    public static void main(String[] args) {

        playGame();


    }


    private static void initMap() {
        map = new char[size][size];
        mapCheck = new char[size][size];
        mapCheck2 = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(map[i], CH_EMPTY);
        }
    }

    private static void printFirstRow() {
        System.out.print(FIRST_EMPTY);
        for (int i = 0; i < size; i++) {
            System.out.print( (i + 1) + EMPTY);
        }
        System.out.println();
    }

    private static void printMapRows() {
        for (int i = 0; i < size; i++) {
            if (i > 8) {
                System.out.print( (i + 1) + YET_ANOTHER_EMPTY);
            } else {
                System.out.print( (i + 1) + EMPTY);
            }
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMap() {
        printFirstRow();
        printMapRows();
        System.out.println();
    }

    private static boolean isCellNotValid (int row, int col) {
        return (row < 1) || (row > size) || (col < 1) || (col > size);
    }

    private static boolean isCellNotEmpty (int row, int col) {
        return map[row - 1][col - 1] != CH_EMPTY;
    }

    private static void humanTurn() {
        System.out.println("Your turn. Choose a cell.");
        int col, row;
        while (true) {
            System.out.print("Choose row: ");
            row = input.hasNextInt() ? input.nextInt() : 0;
            System.out.print("Choose column: ");
            col = input.hasNextInt() ? input.nextInt() : 0;

            if (isCellNotValid(row, col)) {
                System.out.println("Invalid cell. Please try again.");
            } else if (isCellNotEmpty(row, col)) {
                System.out.println("Cell is already taken. Please try again.");
            } else {
                map[row - 1][col - 1] = CH_HUMAN;
                break;
            }
        }
        printMap();
    }

    private static boolean checkWinHor(char ch, char map[][]) {
        int chCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == ch) {
                    chCount++;
                    if (chCount == chWin) {
                        return true;
                    }
                } else {
                    chCount = 0;
                }
            }
            chCount = 0;
        }
        return false;
    }

    private static boolean checkWinVert(char ch, char map[][]) {
        int chCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[j][i] == ch) {
                    chCount++;
                    if (chCount == chWin) {
                        return true;
                    }
                } else {
                    chCount = 0;
                }
            }
            chCount = 0;
        }
        return false;
    }
    
    private static boolean checkWinDia(char ch, char map[][]) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == ch) {
                    if ( checkFallDia(i, j, ch, map) || checkRisingDia(i, j, ch, map) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkFallDia(int row, int col, char ch, char map[][]) {
        int chCount = 1;
        for (int i = 1; i < chWin; i++) {
            if ( (row + i < size) && (col + i < size) && (map[row + i][col + i] == ch) ) {
               chCount++;
                if (chCount == chWin) {
                    return true;
                }
            } else if ( (row + i < size) && (col + i < size) && (map[row + i][col + i] != ch) ) {
                chCount = 0;
            }
        }
        return false;
    }

    private static boolean checkRisingDia(int row, int col, char ch, char map[][]) {
        int chCount = 1;
        for (int i = 1; i < chWin; i++) {
            if ( (row + i < size) && (col - i >= 0) && (map[row + i][col - i] == ch) ) {
                chCount++;
                if (chCount == chWin) {
                    return true;
                }
            } else if ( (row + i < size) && (col - i >= 0) && (map[row + i][col - i] != ch) ) {
                chCount = 0;
            }
        }
        return false;
    }

    private static boolean checkWin(char ch, char map[][]) {
        return checkWinHor(ch, map) || checkWinVert(ch, map) || checkWinDia(ch, map);
    }

    private static boolean checkFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == CH_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkHuman() {
        if (checkWin(CH_HUMAN, map)) {
            System.out.println("You won!");
        }
        if (checkFull()) {
            System.out.println("It's a tie.");
        }
        return checkFull() || checkWin(CH_HUMAN, map);
    }

    private static boolean aiMoveCheck (char ch) {
        for (int i = 0; i < size; i++) {
            copyMap(mapCheck2, mapCheck);
            for (int j = 0; j < size; j++) {
                copyMap(mapCheck2, mapCheck);
                if (mapCheck[i][j] == CH_EMPTY) {
                    mapCheck2[i][j] = ch;
                    if (checkWin(ch, mapCheck2)) {
                        mapCheckIndex[0] = i;
                        mapCheckIndex[1] = j;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void copyMap(char[][] mapCheck, char[][] map) {
        for (int i = 0; i < size; i++) {
            mapCheck[i] = Arrays.copyOf(map[i], size);
        }
    }

    private static boolean aiCheck1 (char ch) {
        for (int i = 0; i < size; i++) {
            copyMap(mapCheck, map);
            for (int j = 0; j < size; j++) {
                copyMap(mapCheck, map);
                if (mapCheck[i][j] == CH_EMPTY) {
                    mapCheck[i][j] = ch;
                    if (checkWin(ch, mapCheck)) {
                        mapCheckIndex[0] = i;
                        mapCheckIndex[1] = j;
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private static boolean aiCheck2 (char ch) {
        for (int i = 0; i < size; i++) {
            copyMap(mapCheck, map);
            for (int j = 0; j < size; j++) {
                copyMap(mapCheck, map);
                if (mapCheck[i][j] == CH_EMPTY) {
                    mapCheck[i][j] = ch;
                    if (aiMoveCheck(ch)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static void aiTurn () {
        if (aiCheck1(CH_AI)) {
            map[mapCheckIndex[0]][mapCheckIndex[1]] = CH_AI;
            printMap();
        } else if (aiCheck1(CH_HUMAN)) {
            map[mapCheckIndex[0]][mapCheckIndex[1]] = CH_AI;
            printMap();
        } else if (aiCheck2(CH_HUMAN)) {
            map[mapCheckIndex[0]][mapCheckIndex[1]] = CH_AI;
            printMap();
        } else if (aiCheck2(CH_AI)) {
            map[mapCheckIndex[0]][mapCheckIndex[1]] = CH_AI;
            printMap();
        } else {
            while (true) {
                int row = (int) (Math.random() * size);
                int col = (int) (Math.random() * size);
                if (map[row][col] == CH_EMPTY) {
                    map[row][col] = CH_AI;
                    printMap();
                    break;
                }
            }
        }
    }

    private static boolean checkAI() {
        if (checkWin(CH_AI, map)) {
            System.out.println("You lose.");
        }
        if (checkFull()) {
            System.out.println("It's a tie.");
        }
        return checkFull() || checkWin(CH_AI, map);
    }

    private static void startGame () {
        System.out.println("Choose gaming field size.");

        while (true) {
            System.out.print("Type number between 3 and 15: ");
            size = input.hasNextInt() ? input.nextInt() : 0;
            if (size >= 3 && size <= 15) {
                break;
            }
            input.nextLine();
        }
        System.out.println();
        if (size <= 5) {
            chWin = 3;
        } else if (size <= 10) {
            chWin = 4;
        } else {
            chWin = 5;
        }
        System.out.println("Field size is " + size + "x" + size + ". In order to win you need to fill " + chWin + " cells in a row.\n");
    }

    private static void checkReplay() {
        System.out.println();
        System.out.print("Would you like to play again? y/n ");
        while (true) {
            String answer = input.next();
            System.out.println();
            if (answer.equals("y")) {
                playGame();
            } else if (answer.equals("n")) {
                System.exit(0);
            } else {
                System.out.print("You can only use \'y\' and \'n\' this time. Try again: ");
            }
        }
    }

    private static void playGame() {
        startGame();
        initMap();
        printMap();

        while (true){
            humanTurn();
            if (checkHuman()) {
                checkReplay();
            }
            System.out.println("My turn:\n");
            aiTurn();
            if (checkAI()) {
                checkReplay();
            }
        }
    }

}
