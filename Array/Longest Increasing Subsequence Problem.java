package Array;
class Longest
{
    
    public static int LDS(int[] nums, int i, int prev)
    {
        
        if (i == nums.length) {
            return 0;
        }
 
        
        int excl = LDS(nums, i + 1, prev);
 
        
        int incl = 0;
        if (nums[i] < prev) {
            incl = 1 + LDS(nums, i + 1, nums[i]);
        }
 
        
        return Integer.max(incl, excl);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
 
        System.out.println("The length of the LDS is " +
                    LDS(nums, 0, Integer.MAX_VALUE));
    }
}

