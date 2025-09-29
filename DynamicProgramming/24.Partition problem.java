package DynamicProgramming;


import java.util.Arrays;
 
class Main
{
    public static boolean subsetSum(int[] nums, int n, int sum)
    {
        if (sum == 0) {
            return true;
        }
        if (n < 0 || sum < 0) {
            return false;
        }
 
        boolean include = subsetSum(nums, n - 1, sum - nums[n]);
 
        if (include) {
            return true;
        }
 
        boolean exclude = subsetSum(nums, n - 1, sum);
        return exclude;
    }
 
    public static boolean partition(int[] nums)
    {
        int sum = Arrays.stream(nums).sum();
 
        return (sum & 1) == 0 && subsetSum(nums, nums.length - 1, sum/2);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 7, 3, 1, 5, 4, 8 };
 
        if (partition(nums)) {
            System.out.println("Set can be partitioned");
        }
        else {
            System.out.println("Set cannot be partitioned");
        }
    }
}