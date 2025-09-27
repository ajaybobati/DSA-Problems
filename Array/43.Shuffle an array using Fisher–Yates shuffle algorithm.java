package Array;
import java.util.Arrays;
import java.util.Random;
 
class shuffled
{
   
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
  
    public static void shuffle(int[] A)
    {
        
        for (int i = A.length - 1; i >= 1; i--)
        {
            Random rand = new Random();
 
    
            int j = rand.nextInt(i + 1);
 
           
            swap(A, i, j);
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };
 
        shuffle(A);
 
       
        System.out.println(Arrays.toString(A));
    }
}