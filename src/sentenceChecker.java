//Author - Neil Finnegan
// 31/07/2018
// Valid Sentence Checker
// plus tests


public class sentenceChecker {

    private String s;

    public sentenceChecker (String sentence) {
        s = sentence;
    }

    private boolean isNotEmpty() {
        return s.isEmpty();                              //Check if the string is empty
    }

    private boolean isFirstLetterCapital(){
        return s.matches("(^[A-Z].*)");
    }

    private boolean hasEvenQuotes(){
        int quote = 0;                                      //Counter for quotes

        for (int i =0; i < s.length(); i++){                //Iterate through the string
            if (s.charAt(i) == '"')                        //Increase count when quotation is discovered
                quote++;
        }
        if ((quote % 2) == 1){                                //Divide total by 2 to check if even or not
            return false;
        }
        else{
            return true;
        }
    }

    private boolean endsWithPeriod(){                          //Check if the string ends with a period.
        return s.endsWith(".");
    }

    private boolean containsNoOther(){
        int period = 0;

        for (int i = 0; i < (s.length()); i++) {               //Iterate through the string
            if (s.charAt(i) == '.' ) {                         //Increase count when period is discovered
                period+= 1;                                    //Break loop as condition has been met
                System.out.println(period);
            }
        }
        if (period - 1 ==  0);{                                 //Check count and return
            return true;
        }
    }

    private boolean numberCheck(){
        return s.matches(".*(?: [0-9] | 1[0-2] ).*");                 //Using regex pattern to find numbers 1-12 in string
    }

    public boolean sentenceTest(){

        System.out.println("Testing started on string : " + s);

        if (this.isNotEmpty() == true){
            System.out.println("Fail 1- Empty string");
            return false;
        }
        else{
            System.out.println("Pass 1- Not empty");
        }

        if (this.isFirstLetterCapital() == false) {
            System.out.println("Fail 2- not a capital letter");
            return false;
        }
        else{
            System.out.println("Pass 2- First is capital");
        }
        if (this.hasEvenQuotes() == false){
            System.out.println("Fail 3- Odd quote count");
            return false;
        }
        else{
            System.out.println("Pass 3- Even quotes");
        }
        if (this.endsWithPeriod() == false){
            System.out.println("Fail 4- does not end with period");
            return false;
        }
        else{
            System.out.println("Pass 4- Ends with period");
        }
        if (this.containsNoOther() == false){
            System.out.println("Fail 5- Contains other period");
            return false;
        }
        else{
            System.out.println("Pass 5- No other period");
        }
        if (this.numberCheck() == true){
            System.out.println("Fail 6- Digits below 13");
            return false;
        }
        else{
            System.out.println("Pass 6- No numbers pass");
        }
        System.out.println("Sentence follows all of our rules");
        return true;
    }

    public static void main(String[] args) {

        sentenceChecker string1 = new sentenceChecker("The quick brown fox said \"hello Mr lazy dog\".");
        sentenceChecker string2 = new sentenceChecker("The quick brown fox said hello Mr lazy dog.");
        sentenceChecker string3 = new sentenceChecker("One lazy dog is too few, 13 is too many.");
        sentenceChecker string4 = new sentenceChecker("One lazy dog is too few, thirteen is too many.");

        sentenceChecker string5 = new sentenceChecker("The quick brown fox said \"hello Mr. lazy dog\".");
        sentenceChecker string6 = new sentenceChecker("the quick brown fox said \"hello Mr lazy dog\".");
        sentenceChecker string7 = new sentenceChecker("\"The quick brown fox said \"hello Mr lazy dog.\"");
        sentenceChecker string8 = new sentenceChecker("One lazy dog is too few, 12 is too many.");

        int pass = 0;

        if (string1.sentenceTest() == true){
            pass++;
        }
        if (string2.sentenceTest() == true){
            pass++;
        }
        if (string3.sentenceTest() == true){
            pass++;
        }
        if (string4.sentenceTest() == true){
            pass++;
        }
        if (string5.sentenceTest() == true){
            pass++;
        }
        if (string6.sentenceTest() == true){
            pass++;
        }
        if (string7.sentenceTest() == true){
            pass++;
        }
        if (string8.sentenceTest() == true){
            pass++;
        }
        System.out.println("----Test Results----");
        System.out.println("Total Tests 8");
        System.out.println("Passed tests - " + pass);

    }
}
