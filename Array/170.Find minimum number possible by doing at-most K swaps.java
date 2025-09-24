package Array;
class numberp
{
    private static void swap(char[] digits, int i, int j)
    {
        char digit = digits[i];
        digits[i] = digits[j];
        digits[j] = digit;
    }
    public static String findMin(char[] digits, int k, String min_so_far)
    {
        String curr = new String(digits);
        if (curr.compareTo(min_so_far) < 0) {
            min_so_far = curr;
        }
        if (k < 1) {
            return min_so_far;
        }
        for (int i = 0; i < digits.length - 1; i++)
        {
            for (int j = i + 1; j < digits.length; j++)
            {
                if (digits[i] > digits[j])
                {
                    swap(digits, i, j);
                    min_so_far = findMin(digits, k - 1, min_so_far);
 
                    swap(digits, i, j);
                }
            }
        }
        return min_so_far;
    }
    public static String findMinimum(String s, int k)
    {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] digits = s.toCharArray();
        return findMin(digits, k, s);
    }
 
    public static void main(String[] args)
    {
        String s = "934651";
        int k = 2;
 
        String min = findMinimum(s, k);
 
        System.out.println("The minimum number formed by doing at-most "
                + k + " swaps is " + min);
    }
}

