package Array;
import java.util.Arrays;
 
class findMinTripletPro
{
    
    public static int findMinTripletProduct(int[] A)
    {
        int n = A.length;
        if (n <= 2) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(A);
 
        return Integer.min(A[n-1] * A[n-2] * A[0], A[0] * A[1] * A[2]);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 4, -1, 3, 5, 9 };
 
        int min = findMinTripletProduct(A);
 
        if (min == Integer.MAX_VALUE) {
            System.out.print("No triplet exists since the list has less than " +
                    "3 elements");
        }
        else {
            System.out.print("The minimum product is " + min);
        }
    }
}

