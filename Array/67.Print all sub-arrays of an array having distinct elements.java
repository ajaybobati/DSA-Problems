
package Array;

import java.util.HashMap;
import java.util.Map;
 
class printSubarr
{
    public static void printSubarray(int[] A, int i, int j, int n)
    {
        if (i < 0 || i > j || j >= n) { 
            return;
        }
 
        for (int index = i; index < j; index++) {
            System.out.print(A[index] + ", ");
        }
 
        System.out.println(A[j]);
    }
 
    public static void calculate(int[] A)
    {
        int n = A.length;
 
        Map<Integer, Boolean> visited = new HashMap<>();
 
        for (int val: A) {
            visited.put(val, false);
        }
 
        int right = 0, left = 0;
 
        while (right < n)
        {
            while (right < n && !visited.get(A[right]))
            {
                visited.put(A[right], true);
                right++;
            }
 
            printSubarray(A, left, right - 1, n);
 
 
            while (right < n && visited.get(A[right]))
            {
                visited.put(A[left], false);
                left++;
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 5, 2, 3, 5, 4, 3 };
 
        calculate(A);
    }
}