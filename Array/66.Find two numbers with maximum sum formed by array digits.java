package Array;

import java.util.Arrays;
import java.util.Comparator;
 
class findMaxim
{
    public static void findMaximum(Integer[] input)
    {
        if (input.length <= 1) {
            return;
        }
        Arrays.sort(input, Comparator.reverseOrder());
 
        int x = 0;
        for (int i = 0; i < input.length; i = i + 2) {
            x = x * 10 + input[i];
        }
        int y = 0;
        for (int i = 1; i < input.length; i = i + 2) {
            y = y * 10 + input[i];
        }
 
        System.out.println("The two numbers with maximum sum are "
                + x + " and " + y);
    }
 
    public static void main(String[] args)
    {
        Integer[] input = { 4, 6, 2, 7, 9, 8 };
 
        findMaximum(input);
    }
}

