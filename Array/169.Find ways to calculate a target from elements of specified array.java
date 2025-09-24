package Array;
class countWa
{
    public static int countWays(int[] nums, int i, int target)
    {
        if (target == 0 && i == nums.length) {
            return 1;
        }
        if (i == nums.length) {
            return 0;
        }
        int exclude = countWays(nums, i + 1, target);
 
        int include = countWays(nums, i + 1, target - nums[i]) +
                countWays(nums, i + 1, target + nums[i]);
 
        return exclude + include;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 5, 3, -6, 2 };
        int target = 6;
 
        System.out.println(countWays(nums, 0, target) + " ways");
    }
}
