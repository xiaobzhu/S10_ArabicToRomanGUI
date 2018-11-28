public class Calculation {
    /**
     * This public String is used to store the roman char thing after the translate.
     */
    public String roman = "";
    /**
     * This int value is used to store the arabic amount, both the count and roman will be use in the CalculationGUI class
     * That's the reason why I set it as the Public value, It looks I have no other options
     */
    public int count;

    /**
     * This method is used to transfer the arabic to roman, in this method my thought is use the String roman
     * to be the suppose  output, each time after did the calculation it can add the proper char from the
     * romanChar to the roman String
     *
     * @param num this num is from the CalculationGUI class after get the user input from that class, input at here
     *            to do the calculation at here
     */
    public Calculation(int num) {//this line is used to transfer the arabicNum to the romanChar
        /**
         * this romanChar string array is stored the roman char
         */
        String romanChar[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//this line is used to setup all the char that will be used in the translation
        /**
         * this arabicNum int array is stored the arabic Num
         */
        int arabicNum[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};// this line is used to setup all the special case that will be used to transfer the arabic to roman
        for (int i = 0; i < 13 && num > 0; i++) {// use this for loop to do the translation of the each number that get from the user input
            if (num < arabicNum[i]) {

            } else {
                while (num >= arabicNum[i]) {
                    num -= arabicNum[i];
                    roman += romanChar[i];
                }
            }
        }
    }

    /**
     * This method is used to translate the roman to arabic, in this method, I used a local variable num to do the counter for the for loop
     *
     * @param str this str is a String type, it gets from the Calculation GUI part, get the user input in the text field
     *            in this method the count is the number that user input in the textfield
     */
    public Calculation(String str) {


        final char romanChar[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};//this line is used to setup all the char will be used in the translation
        int arabiNum[] = {1000, 500, 100, 50, 10, 5, 1};

        int num = 0;
        while (num < str.length()) {
            for (int i = 0; i < 7; i++) {// this for loop is used to translation the char to arabic
                if (str.charAt(num) == romanChar[i]) {
                    if ((num < str.length() - 1) && (i >= 2) && (str.charAt(num + 1) == romanChar[i - 2])) {
                        count += -arabiNum[i];
                    } else if ((num < str.length() - 1) && (i >= 1) && (str.charAt(num + 1) == romanChar[i - 1])) {
                        count += -arabiNum[i];
                    } else {
                        count += arabiNum[i];
                    }
                }
            }
            num++;
        }
    }
}