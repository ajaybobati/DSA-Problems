
package Array;
import java.util.Arrays;
 
class findTr
{
   
    public static void findTriplet(int[] A)
    {
        Arrays.sort(A);
        int n = A.length;
 
        if (n <= 2) {
            System.out.print("No triplet exists. The array has less than 3 elements.");
        }
 
        if (A[n-1] * A[n-2] * A[n-3] > A[0] * A[1] * A[n-1]) {
            System.out.printf("Triplet is (%d, %d, %d)", A[n-1], A[n-2], A[n-3]);
        }
        else {
            System.out.printf("Triplet is (%d, %d, %d)", A[0], A[1], A[n-1]);
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { -4, 1, -8, 9, 6 };
        findTriplet(A);
    }
}

