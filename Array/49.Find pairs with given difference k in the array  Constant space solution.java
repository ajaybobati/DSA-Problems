package Array;
import java.util.Arrays;
 
class findPai
{
    public static void findPair(int[] A, int diff)
    {
        Arrays.sort(A);
 
        for (int i = 0; i < A.length; i++)
        {
            while (i < A.length - 1 && A[i] == A[i+1]) {
                i++;
            }
            if (Arrays.binarySearch(A, A[i] - diff) >= 0) {
                System.out.println("(" + A[i] + ", " + (A[i] - diff) + ")");
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;
 
        findPair(A, diff);
    }
}

