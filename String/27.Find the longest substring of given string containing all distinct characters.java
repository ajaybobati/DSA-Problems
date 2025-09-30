package String;


class Main
{
    private static final int CHAR_RANGE = 128;
 
    public static String findLongestSubstring(String str)
    {
        if (str == null || str.length() == 0) {
            return str;
        }
 
        boolean[] window = new boolean[CHAR_RANGE];
        int begin = 0, end = 0;
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            if (window[str.charAt(high)])
            {
                while (str.charAt(low) != str.charAt(high))
                {
                    window[str.charAt(low)] = false;
                    low++;
                }
 
                low++;        
            }
            else {
                window[str.charAt(high)] = true;
 
                if (end - begin < high - low)
                {
                    begin = low;
                    end = high;
                }
            }
        }
        return str.substring(begin, end + 1);
    }
 
    public static void main(String[] args)
    {
        String str = "abbcdafeegh";
 
        System.out.print(findLongestSubstring(str));
    }
}

