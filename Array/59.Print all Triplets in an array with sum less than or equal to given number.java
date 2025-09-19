package Array;

import java.util.Arrays;
 
class mainit
{
    public static void printAllTriplets(int[] nums, int sum)
    {
        Arrays.sort(nums);
 
        for (int i = 0; i <= nums.length - 3; i++)
        {
            int low = i + 1, high = nums.length - 1;
 
            while (low < high)
            {
                if (nums[i] + nums[low] + nums[high] > sum) {
                    high--;
                }
                else {
                    
                    for (int x = low + 1; x <= high; x++)
                    {
                        System.out.println("(" + nums[i] + ", " + nums[low] + ", "
                                        + nums[x] + ")");
                    }
 
                    low++;       
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 7, 4, 9, 5, 1, 3 };
        int sum = 10;
 
        printAllTriplets(nums, sum);
    }
}
