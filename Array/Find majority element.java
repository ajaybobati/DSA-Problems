package Array;
import java.util.HashMap;
import java.util.Map;
 
class findMajorityEle
{
    
    public static int findMajorityElement(int[] nums)
    {
        
        Map<Integer, Integer> map = new HashMap<>();
 
       
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
 
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if (entry.getValue() > nums.length/2) {
                return entry.getKey();
            }
        }
 
        
        return -1;
    }
 
    public static void main (String[] args)
    {
       
        int[] nums = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
 
        int result = findMajorityElement(nums);
        if (result != -1) {
            System.out.println("The majority element is " + result);
        }
        else {
            System.out.println("The majority element doesn't exist");
        }
    }
}