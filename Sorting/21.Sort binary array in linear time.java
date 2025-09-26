package Sorting;

import java.util.Arrays;
 
class Main
{
    public static void sort(int[] A)
    {
        int zeros = 0;
        for (int value: A)
        {
            if (value == 0) {
                zeros++;
            }
        }
        int k = 0;
        while (zeros-- != 0) {
            A[k++] = 0;
        }
 
        while (k < A.length) {
            A[k++] = 1;
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
 
        sort(A);
 
        System.out.println(Arrays.toString(A));
    }
}