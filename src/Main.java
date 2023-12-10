import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Main {

//    public static final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
        Rules for Valid Sentence:
        String starts with a capital letter.
        String has an even number of quotation marks.
        String end with one of the following sentence termination Characters: ".", ",", "?", "!"
        String has no period characters other than the last character.
        Numbers below 13 are spelled out("one", "two", "three", etc..).
         */

        /*
        Pesudo Code:
        Step 1: Create a variable of the origional String.
        Step 2: Loop through the array, and save the indivisual charcter in a variable.
        Step 3:

        Guide Link:
        https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase

        https://www.w3schools.com/java/java_regex.asp
        https://duckduckgo.com/?q=regex+java+cheat+sheet&t=ffab&atb=v406-4__&ia=web
         */

        /*
        Checking number String from one to twelve string for rule where numbers from 1-12 begin words.
         */
        String[] stringNumberCheck = {"One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve" };

        String checkValidString = "One lazy dog is too few, thirteen is too many.";
        System.out.println(checkValidString);

        /*
        Calls all the methods and checks each conditions, all condition will have to be true for a string to be valid.
         */
        if (hasCapital(checkValidString) && endsWithSpecialChar(checkValidString) && hasEvenQuotes(checkValidString)
                && isValidNumber(checkValidString) && noPeriodInsideString(checkValidString)){
            System.out.println("This is valid string.");
        } else {
            System.out.println("This is not a valid string");
        }

        /*
        This is just a testing for each indivisual methods to make sure each method does what it is designed for.
         */
        String checkValidStringTest = "One lazy dog is too few, 13 is too many.";
        System.out.println(checkValidStringTest);
        if (noPeriodInsideString(checkValidStringTest)){
            System.out.println("This is valid string.");
        } else {
            System.out.println("This is not a valid string");
        }

    }

    /*
    This method uses endWith built in method to check that last string index and matches with one of the special
    character and if its finds it, then it returns True else false.
     */

    public static boolean endsWithSpecialChar(String checkedString){
        return checkedString.endsWith(".") || checkedString.endsWith("!") || checkedString.endsWith("?");
    }

    @Test
    public void testValidLastChar(){
        String validStringEnd = "This is a valid string.";
        assertTrue("Expected the string to be valid" , Main.endsWithSpecialChar(validStringEnd));
    }

    @Test
    public void testValidLastCharQuestioMark(){
        String validStringEnd = "This is a valid string?";
        assertTrue("Expected the string to be valid" , Main.endsWithSpecialChar(validStringEnd));
    }

    @Test
    public void testValidLastCharExlamMark(){
        String validStringEnd = "This is a valid string!";
        assertTrue("Expected the string to be valid" , Main.endsWithSpecialChar(validStringEnd));
    }

    @Test
    public void testIValidLastChar(){
        String validStringEnd = "One lazy dog is too few, 12 is too many.";
        assertTrue("Expected the string to be valid" , Main.endsWithSpecialChar(validStringEnd));
    }

    @Test
    public void testIValidLastSpecialChar(){
        String validStringEnd = "This is a not valid string *****";
        assertFalse("Expected the string to be valid" , Main.endsWithSpecialChar(validStringEnd));
    }

    /*
    This method splits the strings and addes to the array. and use for-each loop to check if it finds a . in
    middile of the string if it does than it returns false and another if statemnt for , in middle of string.
     */
    public static boolean noPeriodInsideString(String checkInsideString){
        String[] spiltString = checkInsideString.split("\\s+");
        for (String split : spiltString) {
            if (split.contains(".")) {
                return false;
            } else if (split.contains(",")){
                return  true;
            }
        }
        return  true;
    }

    @Test
    public void testCommaExaString(){
        String validString = "This is a, valid string!";
        assertTrue("Expected string to be valid.", Main.noPeriodInsideString(validString));
    }
    @Test
    public void testInFullStropString(){
        String inValidString = "This is not a. valid string!";
        assertFalse("Expected string to be invalid.", Main.noPeriodInsideString(inValidString));
    }
    public static boolean hasCapital(String checkCapital) {
        return Character.isUpperCase(checkCapital.charAt(0));
    }

    @Test
    public void testCapValidLetter(){
        String validCapString = "This is correct.";
        assertTrue("Expected the String to be valid", Main.hasCapital(validCapString));
    }

    @Test
    public void testInCapValidLetter(){
        String inValidCapString = "this is not correct";
        assertFalse("Expected the String to be Invalid", Main.hasCapital(inValidCapString));
    }

    /*
    This method is checking for even number of "", it has a int variable to keep track of the "" and uses for
    loop to to go through the character Array of the origional string and if it finds it then it adds to the variable.
    and uses moduler % to check if the number can be divided by 2 = 0, if true then there are even quotes else false.
     */

    public static boolean hasEvenQuotes(String checkQutos){
        int quoteCount = 0;
        for (char quot :checkQutos.toCharArray()){
            if (quot == '\"'){
                quoteCount++;
            }
        }
        return quoteCount % 2 == 0;
    }

    /*
    Check if it has even numbers of quotes
     */
    @Test
    public void testEvenQuotes(){
        String validString = "This has a even number of \"Mr\" quotes.";
        assertTrue("Expected String to be valid", Main.hasEvenQuotes(validString));
    }

    /*
    Checks odd number of quotes
     */
    @Test
    public void testOddQuotes(){
        String validString = "This has a even number of \" \"Mr\" quotes.";
        assertFalse("Expected String to be Invalid", Main.hasEvenQuotes(validString));
    }

    /*
    This method uses String arrays which has the number in string and checks if it iss in
    the valid string, if it is then it returns true else false. it also conversts the string array to lower case.
     */
    public static boolean hasStringNum(String stringNum, String[]stringsCheck){
        return Arrays.stream(stringsCheck).map(String::toLowerCase).anyMatch(stringNum::contains);
    }

    @Test
    public void testValidStringNum() {
        String validNumber = "This is String with two as a number.";
        String[] numString = {"Two"};
        assertTrue("Expected the number to be valid.", Main.hasStringNum(validNumber,numString));
    }

    @Test
    public void testValidStringNumUpperCase() {
        String validNumber = "This is String with Two as a number.";
        String[]  validStringNum = {"Two"};
        assertFalse("Expected the String to be Invalid.", Main.hasStringNum(validNumber,validStringNum));
    }

    @Test
    public void testInValidStringNum() {
        String validNumber = "This is String with Two as a number.";
        String[]  InvalidStringNum = {"three"};
        assertFalse("Expected the String to be Invalid.", Main.hasStringNum(validNumber,InvalidStringNum));
    }

    /*
    This below method is for checking if string has number from 1 to 12 using regex.
    And it returns true if it does find number from 1-12.
    In the if statement I will make it NOT equal so that as long it finds 1-12 it will say invalid string.
     */
    public static boolean isValidNumber(String validNumber) {
        return !validNumber.matches(".*\\b(?:[1-9]|1[0-2])\\b.*");
    }

    @Test
    public void testValidNum() {
        String validNumber = "This is String with 12 as a number.";
        assertFalse("Expected the number to be Invalid.", Main.isValidNumber(validNumber));
    }

    @Test
    public void testInvalidNum() {
        String validNumber = "This is String with 13 as a number.";
        assertTrue("Expected the number to be Invalid.", Main.isValidNumber(validNumber));
    }

    @Test
    public void testInvalidString() {
        String validNumber = "This is String with number.";
        assertTrue("Expected the number to be Invalid.", Main.isValidNumber(validNumber));
    }

    @Test
    public void testingEmptyString() {
        String validNumber = "";
        assertTrue("Expected the String to be Invalid.", Main.isValidNumber(validNumber));
    }

}
