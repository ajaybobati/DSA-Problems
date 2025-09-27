package Sorting;


 
class Main
{
    private static void swap(char[] chars, int i, int j)
    {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
 
    private static void reverse(char[] chars, int start)
    {
        for (int i = start, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }
    public static boolean next_permutation(char[] chars)
    {
        int i = chars.length - 1;
        while (chars[i - 1] >= chars[i])
        {
            if (--i == 0) {
                return false;
            }
        }
        int j = chars.length - 1;
        while (j > i && chars[j] <= chars[i - 1]) {
            j--;
        }
        swap(chars, i - 1, j);
        reverse(chars, i);
 
        return true;
    }
    public static void permutations(String str)
    {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str.length() == 1) {
            System.out.print(str);
            return;
        }
        char[] chars = str.toCharArray();
 
        while (true)
        {
            System.out.print(new String(chars) + " ");
 
            if (!next_permutation(chars)) {
                break;
            }
        }
    }
 
    public static void main(String[] args)
    {
        String str = "BADC";
        permutations(str);
    }
}



