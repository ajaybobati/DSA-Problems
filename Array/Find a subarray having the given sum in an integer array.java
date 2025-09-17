package Array;

class findsu
{
   
    public static void findSubarray(int[] nums, int target)
    {
        
        int windowSum = 0;
 
        
        int high = 0;
 
        
        for (int low = 0; low < nums.length; low++)
        {
            
            while (windowSum < target && high < nums.length)
            {
                windowSum += nums[high];
                high++;
            }
 
            
            if (windowSum == target)
            {
                System.out.printf("Subarray found [%d–%d]", low, high - 1);
                return;
            }
 
            
            windowSum -= nums[low];
        }
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
        int target = 15;
 
        findSubarray(nums, target);
    }
}

