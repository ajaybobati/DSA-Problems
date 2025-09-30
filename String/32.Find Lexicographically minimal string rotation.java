package String;


class Main
{
    public static String findLexicalMinRotation(String str)
    {
        if (str == null) {
            return null;
        }
        String min = str;
 
        for (int i = 0; i < str.length(); i++)
        {
            str = str.substring(1) + str.charAt(0);
            if (str.compareTo(min) < 0) {
                min = str;
            }
        }
 
        return min;
    }
 
    public static void main(String[] args)
    {
        String str = "bbaaccaadd";
 
        System.out.println("The lexicographically minimal rotation of " + str
                        + " is " + findLexicalMinRotation(str));
    }
}