package Array;

import java.util.Arrays;
 
class rearrang
{
    public static void rearrange(int[] A)
    {
        int[] aux = new int[A.length];
 
        for (int i = 0; i < A.length; i++) {
            aux[A[i]] = i;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = aux[i];
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 1, 3, 4, 2, 0 };
 
        rearrange(A);
 
        System.out.println(Arrays.toString(A));
    }
}

