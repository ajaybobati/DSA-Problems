package Array;

class findSubb
{
    
    public static void findSubarray(int[] A)
    {
        int leftIndex = -1, rightIndex = -1;
 
     
        int max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++)
        {
            if (max_so_far < A[i]) {
                max_so_far = A[i];
            }
 
            
            if (A[i] < max_so_far) {
                rightIndex = i;
            }
        }
 
       
        int min_so_far = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i--)
        {
            if (min_so_far > A[i]) {
                min_so_far = A[i];
            }
 
           
            if (A[i] > min_so_far) {
                leftIndex = i;
            }
        }
 
        if (leftIndex == -1) {
            System.out.print("Array is already sorted");
            return;
        }
 
        System.out.print("Sort array from index " + leftIndex + " to " + rightIndex);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 3, 2, 7, 5, 6, 4, 8 };
        findSubarray(A);
    }
}
