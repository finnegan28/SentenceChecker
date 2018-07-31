//Author - Neil Finnegan
// 31/07/2018
// Valid Sentence Checker
// plus tests


public class sentenceChecker {

    private String s;

    public sentenceChecker (String sentence) {
        s = sentence;
    }

    private boolean isNotEmpty(String s) {

        return s.isEmpty();                              //Check if the string is empty
    }

    private boolean isFirstLetterCapital(String s){

        return Character.isUpperCase(s.charAt(0));      //Check if the first character is uppercase
    }

    private boolean hasEvenQuotes(String s){
        int quote = 0;
        for (int i =0; i < s.length(); i++){
            if (s.charAt(i) == '"'){
                quote++;
            }
        }
        if (quote % 2 == 1){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
