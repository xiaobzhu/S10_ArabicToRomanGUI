import javax.swing.*;

/**
 * This is the main method of the GUI, that used to run the whole project. In this project, It should use the main
 * constructor to run the other file. In the CalculationGUI file to create the GUI part, and use this file's keylistener
 * to do the get user input and put the user input into the Calculation file, and use the method in the Calculation
 * methods to do the translation. Then set the output in the other textField
 */
public class ArabicToRomanGUI {
    /**
     * This method is the constructor of the calculation GUI class, which is used to to run other class at here
     * gui class
     *
     * @param args args is the statement, it can be change to any other things
     */
    public static void main(String[] args) {//this is the main method of the project
        /**
         * this is the construtor used to run the Calculation in this class, it will easy to use the method in calculation
         * in the following part
         */
        CalculationGUI calculation = new CalculationGUI();//this is the constructor of the Calculation method, use this constructor to make me call the function in Calculation
        /**
         * the setDefaultCloseOperation is used to set the way that gui close
         */
        calculation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this line is used to set the how the gui close
        /**
         * this setSize is used to set the gui size
         */
        calculation.setSize(400, 200);//this line is used to set the size of gui
        /**
         * this setVisible is used to set the gui visible
         */
        calculation.setVisible(true);//this line is used to set the gui visible
    }
}