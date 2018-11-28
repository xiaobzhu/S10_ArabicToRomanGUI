import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * this class is used to create the gui for the translator, in this method it extends from the JFrame, because it used
 * many things from the JFrame things, like the JPanel
 */
public class CalculationGUI extends JFrame {//this class is used to create the gui for the translator
    /**
     * The JTextField amount is the length of the JTextField arabic
     */
    private JTextField arabic = new JTextField(10);//this line is used to create the JTextField that max length is 10
    /**
     * The JTextField amount is the length of the JTextField roman
     */
    private JTextField roman = new JTextField(10);//this line is used to create the JTextField that max lengh is 10

    /**
     * The Constructor if the CalculationGUi, is used to setup the GUI setting, and use this constructor to do the
     * actionlistener of the GUI
     */
    public CalculationGUI() {
        /**
         * this super is set the title of the GUI;
         */
        super("ArabicToRomanGUI");
        /**
         * this constructor is used run the keyhandler to used for add the action listener on the button
         */
        KeyHandler keyHandler = new KeyHandler();//this constructor is used to run the keyHandler in this part, because I need to add the Keylistener to the exactly key or button

        //create main panel for user input
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2));// this line is used to set up the layout way of the panel, this is the first gui, so I dont know how to use the layout, so I just choose one random, I know the grid layout is seprate the panel into many small grid

        //add key listener
        arabic.addKeyListener(keyHandler);//this line is used to add keylistener
        roman.addKeyListener(keyHandler);

        mainPanel.add(arabic);
        mainPanel.add(roman);

        add(mainPanel);//add main panel to the window
    }

    /**
     * this class is used to build up the keylistener that will be use get the user operation
     */
    private class KeyHandler implements KeyListener {//this part is used to set up the keylistener, In this part I choose the keyrelease, that catch the use


        @Override
        public void keyTyped(KeyEvent e) {
        }


        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * this method is used to get the user operation,and it is override the Keyreleased function
         *
         * @param e is the action event
         */
        @Override
        public void keyReleased(KeyEvent e) {//this method is used to setup the keyrelased function
            if (e.getSource() == arabic) {
                String arabicString = arabic.getText();
                boolean flag = true;
                if (arabicString.equals("")) {//this if is used to like when the textField is empty, the other textField will also be empty
                    roman.setText("");
                }
                if (Character.isDigit(arabicString.charAt(0)) == flag) {//This if statement is used to check the value of the user input is a number or is a char.
                    int arabicNumber;
                    try {
                        arabicNumber = Integer.parseInt(arabicString);
                    } catch (NumberFormatException c) {//This is used to when the user input the the special char, the code will throw out a error exception
                        roman.setText("Invalid input");
                        throw new IllegalArgumentException("Invalid input");
                    }
                    if (arabicNumber > 3999 || arabicNumber < 1) {//this if is used to set the limit of the arabicNumber, that limit it lower than 3900, higher than 1
                        roman.setText("Invalid input");
                        throw new IllegalArgumentException("Invalid input");
                    }


                    Calculation text1 = new Calculation(arabicNumber);//this is the constructor of the Calculation, that used to do the translate work
                    roman.setText(text1.roman);
                } else {
                    String romanString = arabic.getText();
                    romanString = romanString.toUpperCase();
                    for (int i = 0; i < romanString.length(); i++) {// this part is used to limit the input of the romanChar
                        boolean inputInvalid = false;
                        if (romanString.charAt(i) == 'I' || romanString.charAt(i) == 'V' || romanString.charAt(i) == 'X' || romanString.charAt(i) == 'L' || romanString.charAt(i) == 'C' || romanString.charAt(i) == 'D' || romanString.charAt(i) == 'M') {
                            inputInvalid = true;
                        }
                        if (!inputInvalid) {
                            roman.setText("invalid roman input");
                            throw new IllegalArgumentException("invalid input");
                        }
                    }
                    Calculation text = new Calculation(romanString);//this is another way to do the check of the roman char is correct or not
                    Calculation text2 = new Calculation(text.count);
                    boolean inputInvalid1 = false;
                    if (text2.roman.equals(romanString)) {
                        inputInvalid1 = true;
                    }
                    if (!inputInvalid1) {
                        roman.setText("invalid roman input");
                        throw new IllegalArgumentException("invalid input");
                    }
                    if(text.count > 3999){
                        roman.setText("Invalid input");
                        throw new IllegalArgumentException("Invalid input");
                    }else{
                        roman.setText(String.valueOf(text.count));
                    }

                }
            } else if (e.getSource() == roman) {//this part is the else part of the if above, but the content is similar, just because in different source, so I repeated to do the check
                String romanString = roman.getText();
                boolean flag = true;
                if (romanString.equals("")) {
                    arabic.setText("");
                }
                if (Character.isLetter(romanString.charAt(0)) == flag) {
                    romanString = romanString.toUpperCase();

                    for (int i = 0; i < romanString.length(); i++) {
                        boolean inputInvalid = false;
                        if (romanString.charAt(i) == 'I' || romanString.charAt(i) == 'V' || romanString.charAt(i) == 'X' || romanString.charAt(i) == 'L' || romanString.charAt(i) == 'C' || romanString.charAt(i) == 'D' || romanString.charAt(i) == 'M') {
                            inputInvalid = true;
                        }
                        if (!inputInvalid) {
                            arabic.setText("invalid roman input");
                            throw new IllegalArgumentException("invalid input");
                        }
                    }
                    Calculation text = new Calculation(romanString);
                    Calculation text2 = new Calculation(text.count);
                    boolean inputInvalid1 = false;
                    if (text2.roman.equals(romanString)) {
                        inputInvalid1 = true;
                    }
                    if (!inputInvalid1) {
                        arabic.setText("invalid roman input");
                        throw new IllegalArgumentException("invalid input");
                    }
                    if(text.count > 3999){
                        arabic.setText("invalid input");
                        throw new IllegalArgumentException("invalid input");
                    }else{
                        arabic.setText(String.valueOf(text.count));
                    }

                } else {
                    String arabicString = roman.getText();
                    int arabicNumber;
                    try {
                        arabicNumber = Integer.parseInt(arabicString);
                    } catch (NumberFormatException c) {
                        arabic.setText("Invalid input");
                        throw new IllegalArgumentException("Invalid input");
                    }
                    if (arabicNumber > 3999 || arabicNumber < 1) {
                        arabic.setText("Invalid input");
                        throw new IllegalArgumentException("Invalid input");
                    }


                    Calculation text1 = new Calculation(arabicNumber);
                    arabic.setText(text1.roman);
                }
            }
        }

    }


}

