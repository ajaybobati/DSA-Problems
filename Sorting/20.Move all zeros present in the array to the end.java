package Sorting;


import java.util.Arrays;
 
class Main
{
    public static void reorder(int[] A)
    {
        int k = 0;
 
        for (int i: A)
        {
            if (i != 0) {
                A[k++] = i;
            }
        }
        for (int i = k; i < A.length; i++) {
            A[i] = 0;
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };
 
        reorder(A);
        System.out.println(Arrays.toString(A));
    }
}


