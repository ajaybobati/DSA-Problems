package Array;
class findCombinatioo
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
    public static void recur(int[] digits, int i, String str)
    {
        if (i == digits.length)
        {
            System.out.println(str);
            return;
        }
 
        int sum = 0;
        for (int j = i; j <= Integer.min(i + 1, digits.length - 1); j++)
        {
            sum = (sum * 10) + digits[j];
 
            if (sum > 0 && sum <= 26) {
                recur(digits, j + 1, str + alphabet.charAt(sum - 1));
            }
        }
    }
 
    public static void findCombinations(int[] digits)
    {
        // base case
        if (digits == null || digits.length == 0) {
            return;
        }
 
        String str = "";
        recur(digits, 0, str);
    }
 
    public static void main(String[] args)
    {
        int[] digits = { 1, 2, 2 };
 
        findCombinations(digits);
    }
}