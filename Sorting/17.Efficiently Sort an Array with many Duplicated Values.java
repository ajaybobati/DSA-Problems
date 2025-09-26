package Sorting;

import java.util.Arrays;
 
class Main
{
    public static final int RANGE = 100;
 
    public static void customSort(int[] arr)
    {
        int[] freq = new int[RANGE];
 
        for (int i: arr) {
            freq[i]++;
        }
        int k = 0;
        for (int i = 0; i < RANGE; i++)
        {
            while (freq[i]-- > 0) {
                arr[k++] = i;
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 40 };
 
        customSort(arr);
 
        System.out.println(Arrays.toString(arr));
    }
}


