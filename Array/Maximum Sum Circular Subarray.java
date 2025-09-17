package Array;
import java.util.Arrays;
 
class circual
{
    
    public static int kadane(int[] A)
    {
       
        int max_so_far = 0;
 
        
        int max_ending_here = 0;
 
        
        for (int value: A)
        {
            
            max_ending_here = max_ending_here + value;
 
            
            max_ending_here = Integer.max(max_ending_here, 0);
 
            
            max_so_far = Integer.max(max_so_far, max_ending_here);
        }
 
        return max_so_far;
    }
 
   
    public static int runCircularKadane(int[] A)
    {
        
        if (A.length == 0) {
            return 0;
        }
 
       
        int max = Arrays.stream(A).max().getAsInt();
 
        
        if (max < 0) {
            return max;
        }
 
        Arrays.setAll(A, i -> -A[i]);
 
       
        int neg_max_sum = kadane(A);
 
        
        Arrays.setAll(A, i -> -A[i]);
 
       
 
        return Integer.max(kadane(A), Arrays.stream(A).sum() + neg_max_sum);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, 1, -5, 4, -3, 1, -3, 4, -1 };
 
        System.out.println("The sum of the subarray with the largest sum is " +
                runCircularKadane(A));
    }
}

