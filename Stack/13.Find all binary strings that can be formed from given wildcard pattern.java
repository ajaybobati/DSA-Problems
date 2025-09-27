package Stack;

class Main
{
    private static void printAllCombinations(char[] pattern, int i)
    {
        if (pattern == null || pattern.length == 0) {
            return;
        }
        if (i == pattern.length)
        {
            System.out.println(pattern);
            return;
        }
        if (pattern[i] == '?')
        {
            for (char ch = '0'; ch <= '1'; ch++)
            {
                pattern[i] = ch;
 
                printAllCombinations(pattern, i + 1);
 
                pattern[i] = '?';
            }
        }
        else {
            printAllCombinations(pattern, i + 1);
        }
    }
 
    public static void main(String[] args)
    {
        char[] pattern = "1?11?00?1?".toCharArray();
        printAllCombinations(pattern, 0);
    }
}
