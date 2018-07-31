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
        return s.isEmpty();                                  //Check if the string is empty
    }

    private boolean isFirstLetterCapital(){
        return s.matches("(^[A-Z].*)");
    }

    private boolean hasEvenQuotes(){
        int quote = 0;                                       //Counter for quotes

        for (int i =0; i < s.length(); i++){                 //Iterate through the string
            if (s.charAt(i) == '"')                          //Increase count when quotation is discovered
                quote++;
        }
        return (quote % 2) != 1;
    }

    private boolean endsWithPeriod(){                         //Check if the string ends with a period.
        return s.endsWith(".");
    }

    private boolean containsNoOther(){                        //check period count for length-1
        int period = 0;

        for (int i = 0; i < (s.length()-1); i++) {            //Iterate through the string
            if (s.charAt(i) == '.' )                          //Increase count when period is discovered
                period++;
        }
        return (period == 0);
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
        if (this.isFirstLetterCapital() == false) {
            System.out.println("Fail 2- not a capital letter");
            return false;
        }
        if (this.hasEvenQuotes() == false){
            System.out.println("Fail 3- Odd quote count");
            return false;
        }
        if (this.endsWithPeriod() == false){
            System.out.println("Fail 4- does not end with period");
            return false;
        }
        if (this.containsNoOther() == false){
            System.out.println("Fail 5- Contains other period");
            return false;
        }
        if (this.numberCheck() == true){
            System.out.println("Fail 6- Digits below 13");
            return false;
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
        int fail = 0;

        if (string1.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string2.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string3.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string4.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string5.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string6.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string7.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }
        if (string8.sentenceTest() == true){
            pass++;
        }
        else{
            fail++;
        }

        System.out.println("----Test Results----");
        System.out.println("Total Tests " + (fail + pass));
        System.out.println("Expected results - 4 pass / 4 fails");
        System.out.println("Passed tests - " + pass);
        System.out.println("Failed tests - " + fail);

    }
}
