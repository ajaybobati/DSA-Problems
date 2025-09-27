package Array;
import java.util.HashMap;
import java.util.Map;
 
class  findMaxSubarrayLen
{
    public static int findMaxSubarrayLength(int[] X, int[] Y)
    {
        Map<Integer, Integer> map = new HashMap<>();
 
       
        map.put(0, -1);
 
       
        int result = 0;
 
       
        int sum_x = 0, sum_y = 0;
 
       
        for (int i = 0; i < X.length; i++)
        {
            sum_x += X[i];
            sum_y += Y[i];
            int diff = sum_x - sum_y;
 
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }
 
            
            else {
                result = Integer.max(result, i - map.get(diff));
            }
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] X = { 0, 0, 1, 1, 1, 1 };
        int[] Y = { 0, 1, 1, 0, 1, 0 };
 
        System.out.println("The length of the longest continuous sequence " +
                        "with the same sum is " + findMaxSubarrayLength(X, Y));
    }
}