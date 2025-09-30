package String;


import java.util.Arrays;
import java.util.List;
 
class Main
{
    public static boolean validateSentence(char[] chars)
    {
        int index = 0;
        if (Character.isLowerCase(chars[index])) {                  
            return false;
        }
 
        while (index < chars.length)
        {
            if (Character.isUpperCase(chars[index]))
            {
                if (Character.isUpperCase(chars[index + 1])) {     
                    return false;
                }
 
                if (index - 1 >= 0 && chars[index - 1] != ' ') {    
                    return false;
                }
            }
 
            if (chars[index] == ' ' && chars[index + 1] == ' ') {   
                return false;
            }
 
            index++;
        }
 
        if (chars[index - 2] == ' ' || chars[index - 1] != '.') {   
            return false;
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        List<String> sentences = Arrays.asList(
                "This sentence is syntactically correct.",
 
                "This sentence is syntactically  incorrect as two " +
                    "continuous spaces are not allowed.",
 
                "This sentence is syntactically correct Y.",
 
                "This sentence is syntactically incorRect as uppercase " +
                    "character is not allowed midway of the String.",
 
                "THis sentence is syntactically incorrect as two " +
                    "continuous uppercase characters are not allowed.",
 
                "This sentence is syntactically incorrect as it doesn't " +
                    "end with a full stop"
        );
 
        System.out.println("The valid sentences are:");
        for (String sentence: sentences)
        {
            if (validateSentence(sentence.toCharArray())) {
                System.out.println(sentence);
            }
        }
    }
}


