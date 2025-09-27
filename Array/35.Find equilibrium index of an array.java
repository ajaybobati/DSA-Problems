package Array;

import java.util.ArrayList;
import java.util.List;
 
class findEquilibrium
{
    
    public static void findEquilibriumIndex(int A[])
    {
        
        int left[] = new int[A.length];
 
        left[0] = 0;
 
        
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] + A[i - 1];
        }
 
        
        int right = 0;
 
        
        List<Integer> indices = new ArrayList<>();
 
       
        for (int i = A.length - 1; i >= 0; i--)
        {
            
 
            if (left[i] == right) {
                indices.add(i);
            }
 
            right += A[i];
        }
 
        System.out.println("Equilibrium Index found at " + indices);
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, -3, 5, -4, -2, 3, 1, 0 };
 
        findEquilibriumIndex(A);
    }
}