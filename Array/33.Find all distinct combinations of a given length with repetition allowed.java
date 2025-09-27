package Array;

import java.util.ArrayDeque;
import java.util.Deque;
 
 class Find 
{
     public static void main(String[] args)
    {
        int[] A = { 1, 2, 1 };
        int k = 2;
 
        Deque<Integer> out = new ArrayDeque<>();
        findCombinations(A, out, k, 0, A.length);
    }
    
    public static void findCombinations(int[] A, Deque<Integer> out,
                            int k, int i, int n)
    {
        
        if (out.size() == k)
        {
            System.out.println(out);
            return;
        }
 
        
        for (int j = i; j < n; j++)
        {
            
            out.addLast(A[j]);
            findCombinations(A, out, k, j, n);
 
            
            out.pollLast();
        }
    }
 
    
}

