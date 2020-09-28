package Lesson8;

import java.util.Arrays;

public class Wordgame {

    protected String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    protected char[] hint = new char[15];
    protected int index;

    public Wordgame() {
    }

    public String res() {
        return words[index];
    }

    public String printRules() {
        String rules = "I picked one of the following words:\n\n";
        for (int i = 0; i < words.length - 1; i++) {
            rules = rules + words[i] + ", ";
        }
        rules = rules + words[words.length - 1] + ".\n\nGuess what it is.";
        return rules;
    }

    public void start() {
        index = (int) (Math.random() * this.words.length);
        initHint();
    }

    public void initHint() {
        Arrays.fill(this.hint, '#');
    }

    public boolean isFinished(String guess) {
        return wordCheck(guess, words[index]);
    }

    public String game(String guess) {
        if (!wordCheck(guess, words[index]) && checkLegit(guess)) {
            editHint(guess, words[index]);
        }
        String str = "";
        for (int i = 0; i < hint.length; i++) {
            str += hint[i];
        }
        return str;
    }

    public boolean checkLegit(String guess) {
        for (int i = 0; i < words.length; i++) {
            if (guess.equals(words[i])) {
                return true;
            }
        }
        return false;
    }

    public void editHint(String guess, String word) {
        int checkLen = (Math.min(guess.length(), word.length()));
        for (int i = 0; i < checkLen; i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                hint[i] = guess.charAt(i);
            }
        }
    }

    public boolean wordCheck(String guess, String word) {
        return guess.equals(word);
    }

}