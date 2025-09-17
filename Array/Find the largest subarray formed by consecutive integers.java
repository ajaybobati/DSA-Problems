package Array;
import java.lang.Math;
 

class Consecutive
{
    
    private static boolean  isConsecutive(int[] A, int i, int j, int min, int max)
    {
   
        if (max - min != j - i) {
            return false;
        }
 
        boolean visited[] = new boolean[j - i + 1];
 
        for (int k = i; k <= j; k++)
        {
            if (visited[A[k] - min]) {
                return false;
            }
 
          
            visited[A[k] - min] = true;
        }
 
       
        return true;
    }
  
    public static void findMaxSubarray(int[] A)
    {
        int len = 1;
        int start = 0, end = 0;
 
       
        for (int i = 0; i < A.length - 1; i++)
        {
            int min_val = A[i], max_val = A[i];
 
            for (int j = i + 1; j < A.length; j++)
            {
               
                min_val = Math.min(min_val, A[j]);
                max_val = Math.max(max_val, A[j]);
 
        
                if (isConsecutive(A, i, j, min_val, max_val))
                {
                    if (len < max_val - min_val + 1)
                    {
                        len = max_val - min_val + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
 
        
        System.out.println("The largest subarray is [" + start + ", " + end + "]");
    }
 
    public static void main (String[] args)
    {
        int[] A = { 2, 0, 2, 1, 4, 3, 1, 0 };
 
        findMaxSubarray(A);
    }
}