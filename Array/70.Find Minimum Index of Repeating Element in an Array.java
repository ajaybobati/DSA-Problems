package Array;

import java.util.HashSet;
import java.util.Set;
 
class findMinIn
{
    public static int findMinIndex(int[] A)
    {
        int minIndex = A.length;
 
        Set<Integer> set = new HashSet<>();
 
        for (int i = A.length - 1; i >= 0; i--)
        {
            if (set.contains(A[i])) {
                minIndex = i;
            }
            else {
                set.add(A[i]);
            }
        }
 
        if (minIndex == A.length) {
            return -1;
        }
        return minIndex;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 5, 6, 3, 4, 3, 6, 4 };
 
        int minIndex = findMinIndex(A);
 
        if (minIndex != A.length) {
            System.out.print("The minimum index of the repeating element is " +
                    minIndex);
        }
        else {
            System.out.print("Invalid Input");
        }
    }
}

