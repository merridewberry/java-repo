package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {


    static class Window extends JFrame {
        String guess = "";
        Wordgame game = new Wordgame();
        boolean finished;

        public Window() {
            setTitle("hint Game");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(100, 100, 700, 400);
            this.getContentPane().setBackground(Color.LIGHT_GRAY);
            setLayout(null);

            printRules();
            JTextArea hint = printHint();
            JTextArea result = printResult();
            JTextField field = createTextField();

            JButton close = new JButton("Exit");
            close.setBounds(550, 300, 100, 30);
            add(close);

            JButton restart = new JButton("Restart");
            restart.setBounds(50, 300, 100, 30);
            add(restart);
            
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guess = field.getText();
                    field.setText(null);
                    game.game(guess);
                    if (field.getText().equals("")) {
                        hint.setText(game.game(guess));

                    }
                    if (game.isFinished(guess)) {
                        result.setText(null);
                        hint.setText("Correct!");
                    } else {
                        result.setText("Here's a hint:");
                    }
                }
            });

            close.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            restart.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    game.start();
                    guess = "";
                    hint.setText(game.game(guess));
                    result.setText(null);
                    System.out.println(game.res());

                }
            });

            setVisible(true);

            game.start();
            System.out.println(game.res());


        }

        public JTextArea printResult() {
            JTextArea result = new JTextArea();
            result.setBounds(200, 180, 300, 40);
            result.setBackground(Color.LIGHT_GRAY);
            Font font = new Font("Helvetica", Font.PLAIN, 16);
            result.setFont(font);
            add(result);
            return result;
        }

        public JTextArea printHint() {
            JTextArea hint = new JTextArea();
            hint.setBounds(200, 220, 300, 40);
            Font font = new Font("Helvetica", Font.BOLD, 20);
            hint.setFont(font);
            hint.setText(game.game(guess));
            add(hint);
            return hint;
        }

        public void printRules() {
            JTextArea rules = new JTextArea();
            rules.setBounds(40, 20, 600, 150);
            rules.setText(game.printRules());
            rules.setEditable(false);
            rules.setBackground(Color.LIGHT_GRAY);
            Font font = new Font("Helvetica", Font.PLAIN, 16);
            rules.setFont(font);
            rules.setLineWrap(true);
            rules.setWrapStyleWord(true);
            add(rules);
        }

        public JTextField createTextField() {
            JTextField field = new JTextField();
            field.setBounds(200, 300, 300, 40);
            field.setBackground(Color.WHITE);
            Font font = new Font("Helvetica", Font.BOLD, 20);
            field.setFont(font);
            add(field);
            return field;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Window();
    }


}
