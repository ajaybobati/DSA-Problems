package Array;
import java.util.Map;
import java.util.HashMap;

 
class findLargestSub
{
    
    public static void findLargestSubarray(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();
 
        
        map.put(0, -1);
        int len = 0;
 
        int ending_index = -1;
 
        int sum = 0;
 
        for (int i = 0; i < nums.length; i++)
        {
            
            sum += (nums[i] == 0)? -1: 1;
 
            if (map.containsKey(sum))
            {
                
                if (len < i - map.get(sum))
                {
                    len = i - map.get(sum);
                    ending_index = i;
                }
            }
            
            else {
                map.put(sum, i);
            }
        }
 
        if (ending_index != -1)
        {
            System.out.println("[" + (ending_index - len + 1) + ", " +
                                    ending_index + "]");
        }
        else {
            System.out.println("No subarray exists");
        }
    }
 
    public static void main (String[] args)
    {
        int[] nums = { 0, 0, 1, 0, 1, 0, 0 };
 
        findLargestSubarray(nums);
    }
}