package Array;

import java.util.Arrays;
 
class decod
{
   
    public static void decode(int[] inp)
    {
        int m = inp.length;
 
        
        if (m == 0 || m == 2) {
            return;
        }
 
        int n = (int)(Math.sqrt(8 * m + 1) + 1) / 2;
 
        int[] A = new int[n];
 
        if (n == 1 || m == 1) {
            A[0] = inp[0];
        }
        else if (n == 2) {
            A[0] = inp[0] - inp[1];
        }
        else {
            A[0] = (inp[0] + inp[1] - inp[n - 1]) / 2;
        }
        for (int i = 1; i < n; i++) {
            A[i] = inp[i - 1] - A[0];
        }
 
        System.out.print(Arrays.toString(A));
    }
 
    public static void main(String[] args)
    {
        int[] inp = { 3, 4, 5, 6, 5, 6, 7, 7, 8, 9 };
        decode(inp);
    }
}