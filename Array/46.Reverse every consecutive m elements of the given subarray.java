package Array;

import java.util.Arrays;
 
class Reverse
{
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void reverse (int[] A, int i, int j)
    {
        if (i >= j) {
            return;
        }
        swap(A, i, j);
 
       
        reverse(A, i + 1, j - 1);
    }
 
    public static void reverse(int[] A, int beg, int end, int m)
    {
        if (m <= 1) {
            return;
        }
        if (m > end - beg + 1) {
            return;
        }
        for (int i = beg; i <= end; i = i + m)
        {
            if (i + m - 1 <= end) {
                reverse(A, i, i + m - 1);
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int m = 3;
        int beg = 1, end = 8;
 
        reverse(A, beg, Math.min(end, A.length - 1), m);
        System.out.println(Arrays.toString(A));
    }
}

