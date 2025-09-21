package Array;
class findI
{
    public static int findIndexofZero(int[] A)
    {
       
        if (A.length == 1) {
            return (A[0] == 0 ? 0 : -1);
        }
 
        for (int i = 1; i < A.length; i++)
        {
            if (A[i] == 1) {
                A[i] += A[i - 1];
            }
        }
 
        int count = 0;
 
        for (int i = A.length - 1; i >= 0; i--)
        {
            count = Math.max(A[i], count);
 
            if (A[i] != 0) {
                A[i] = count;
            }
            else {
                
                count = 0;
            }
        }
 
        int max_count = 0;      
        int max_index = -1;     
 
        
        for (int i = 0; i < A.length; i++)
        {
           
            if (A[i] == 0)
            {
                
 
                if (i == 0)
                {
                    if (max_count < A[i + 1] + 1)
                    {
                        max_count = A[i + 1] + 1;
                        max_index = i;
                    }
                }
 
                else if (i == A.length - 1)
                {
                    if (max_count < A[i - 1] + 1) {
                        max_count = A[i - 1] + 1;
                        max_index = i;
                    }
                }
 
                else if (max_count < A[i - 1] + A[i + 1] + 1)
                {
                    max_count = A[i - 1] + A[i + 1] + 1;
                    max_index = i;
                }
            }
        }
        for (int i = 1; i < A.length; i++)
        {
            if (A[i] != 0) {
                A[i] = 1;
            }
        }
 
        return max_index;
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
 
        int index = findIndexofZero(A);
 
        if (index != -1) {
            System.out.print("Index to be replaced is " + index);
        }
        else {
            System.out.print("Invalid input");
        }
    }
}

