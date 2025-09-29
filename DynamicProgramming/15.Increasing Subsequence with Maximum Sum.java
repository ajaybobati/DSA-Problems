package DynamicProgramming;


class Main
{
    public static int MSIS(int[] nums, int i, int prev, int sum)
    {
        if (i == nums.length) {
            return sum;
        }
        int excl = MSIS(nums, i + 1, prev, sum);
 
        int incl = sum;
        if (nums[i] > prev) {
            incl = MSIS(nums, i + 1, nums[i], sum + nums[i]);
        }
 
        return Integer.max(incl, excl);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
 
        System.out.println("The maximum sum of the increasing subsequence is " +
                        MSIS(nums, 0, Integer.MIN_VALUE, 0));
    }
}

