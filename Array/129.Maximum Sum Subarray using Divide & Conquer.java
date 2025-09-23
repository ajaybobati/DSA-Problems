package Array;
class  findMaximu
  {
    public static int findMaximumSum(int[] nums)
    {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
 
        for (int i = 0; i < nums.length; i++)
        {
            sum = 0;    
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
 
        return maxSum;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, -4, 1, 9, -6, 7, -3 };
        System.out.println("The maximum sum of the subarray is " + findMaximumSum(nums));
    }
}

