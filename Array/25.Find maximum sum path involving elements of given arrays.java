package Array;

class findMax

{
    
    public static int findMaxSum(int[] X, int[] Y)
    {
        int sum = 0;
        int sum_x = 0, sum_y = 0;
 
        int m = X.length, n = Y.length;
 
       
        int i = 0, j = 0;
 
       
        while (i < m && j < n)
        {
            
            while (i < m-1 && X[i] == X[i+1]) {
                sum_x += X[i++];
            }
 
           
            while (j < n-1 && Y[j] == Y[j+1]) {
                sum_y += Y[j++];
            }
 
            
            if (Y[j] < X[i])
            {
                sum_y += Y[j];
                j++;
            }
 
            
            else if (X[i] < Y[j])
            {
                sum_x += X[i];
                i++;
            }
 
            else    
            {
                
                sum += Integer.max(sum_x, sum_y) + X[i];
 
                
                i++;
                j++;
 
               
                sum_x = 0;
                sum_y = 0;
            }
        }
 
        
        while (i < m) {
            sum_x += X[i++];
        }
 
        while (j < n) {
            sum_y += Y[j++];
        }
 
        sum += Integer.max(sum_x, sum_y);
        return sum;
    }
 
    public static void main(String[] args)
    {
        int[] X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int[] Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };
 
        System.out.println("The maximum sum is " + findMaxSum(X, Y));
    }
}