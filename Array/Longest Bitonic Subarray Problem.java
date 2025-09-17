package Array;

class findBitonicSub
{
    
    public static void findBitonicSubarray(int[] A)
    {
        int n = A.length;
        if (n == 0) {
            return;
        }
 
        int end_index = 0, max_len = 1, i = 0;
 
        while (i + 1 < n)
        {
            
            int len = 1;
 
           
            while (i + 1 < n && A[i] < A[i + 1]) {
                i++;
                len++;
            }
 
           
            while (i + 1 < n && A[i] > A[i + 1]) {
                i++;
                len++;
            }
 
           
            while (i + 1 < n && A[i] == A[i + 1]) {
                i++;
            }
 
           
            if (len > max_len) {
                max_len = len;
                end_index = i;
            }
        }
 
        
        System.out.println("The length of the longest bitonic subarray is " + max_len);
        System.out.println("The longest bitonic subarray indices is [" +
                        (end_index - max_len + 1) + ", " + end_index + "]");
    }
 
    public static void main(String[] args)
    {
        int[] A = { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 };
 
        findBitonicSubarray(A);
    }
}