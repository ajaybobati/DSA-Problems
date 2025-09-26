package Sorting;

import java.util.Arrays;
 
class Main
{
    
    public static void countsort(int[] arr, int k)
    {
        int[] output = new int[arr.length];
        int[] freq = new int[k + 1];
 
        for (int i: arr) {
            freq[i]++;
        }
        int total = 0;
        for (int i = 0; i < k + 1; i++)
        {
            int oldCount = freq[i];
            freq[i] = total;
            total += oldCount;
        }
 
        for (int i: arr)
        {
            output[freq[i]] = i;
            freq[i]++;
        }
        Arrays.setAll(arr, i -> output[i]);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 10, 10, 1, 4, 2, 1, 10 };
 
        int k = 10;
 
        countsort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}