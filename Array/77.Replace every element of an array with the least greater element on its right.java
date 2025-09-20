package Array;
import java.util.Arrays;
 
class replac
{
    public static void replace(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int successor = -1;
            int diff = Integer.MAX_VALUE;
 
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] > nums[i] && (nums[j] - nums[i] < diff))
                {
                    successor = nums[j];
                    diff = nums[j] - nums[i];
                }
            }
            nums[i] = successor;
        }
        System.out.println(Arrays.toString(nums));
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6};
 
        replace(nums);
    }
}