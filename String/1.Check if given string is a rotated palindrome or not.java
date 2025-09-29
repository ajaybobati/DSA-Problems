package String;


class Main
{
    public static boolean isPalindrome(String str, int low, int high)
    {
        return (low >= high) || (str.charAt(low) == str.charAt(high) &&
                                isPalindrome(str, low + 1, high - 1));
    }
    public static boolean isRotatedPalindrome(String str)
    {
        if (str == null) {
            return false;
        }
        int n = str.length();
 
        for (int i = 0; i < n; i++)
        {
            str = str.substring(1) + str.charAt(0);
 
            if (isPalindrome(str, 0, n - 1)) {
                return true;
            }
        }
        return false;
    }
 
    public static void main(String[] args)
    {
        String str = "ABCDCBA";
 
        str = str.substring(2) + str.substring(0, 2);
 
        if (isRotatedPalindrome(str)) {
            System.out.println("The string is a rotated palindrome");
        }
        else {
            System.out.println("The string is not a rotated palindrome");
        }
    }
}

