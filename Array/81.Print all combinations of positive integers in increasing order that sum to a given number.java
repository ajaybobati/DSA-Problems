package Array;
import java.util.Arrays;
import java.util.stream.Collectors;
 
class printCombina
{
    public static void printCombinations(int[] nums, int i, int sum, int sum_left)
    {
        int prev_num = (i > 0) ? nums[i - 1] : 1;
        for (int k = prev_num; k <= sum; k++)
        {
            nums[i] = k;
 
            if (sum_left > k) {
                printCombinations(nums, i + 1, sum, sum_left - k);
            }
 
            if (sum_left == k)
            {
                System.out.println(Arrays.stream(nums).limit(i + 1).boxed()
                                .collect(Collectors.toList()));
            }
        }
    }
 
    public static void findCombinations(int sum)
    {
        int[] nums = new int[sum];
 
        int starting_index = 0;
        printCombinations(nums, starting_index, sum, sum);
    }
 
    public static void main(String[] args)
    {
        int sum = 5;
        findCombinations(sum);
    }
}