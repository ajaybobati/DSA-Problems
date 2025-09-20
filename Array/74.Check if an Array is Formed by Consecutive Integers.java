package Array;

import java.util.HashSet;
import java.util.Set;
 
class isConsecu
{
    public static boolean isConsecutive(int[] A)
    {
        if (A.length <= 1) {
            return true;
        }
 
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
 
        for (int i: A)
        {
            if (i < min) { min = i; }
            if (i > max) { max = i; }
        }
 
        if (max - min != A.length - 1) {
            return false;
        }
 
        Set<Integer> visited = new HashSet<>();
 
        for (int i: A)
        {
            if (visited.contains(i)) {
                return false;
            }
 
            visited.add(i);
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -1, 5, 4, 2, 0, 3, 1 };
 
        if (isConsecutive(A)) {
            System.out.print("The array contains consecutive integers");
        }
        else {
            System.out.print("The array does not contain consecutive integers");
        }
    }
}

