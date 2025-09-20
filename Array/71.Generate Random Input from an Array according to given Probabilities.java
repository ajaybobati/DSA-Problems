package Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
 
class ranm
{
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
 
        return new Random().nextInt(max - min + 1) + min;
    }
 
    public static int random(int[] nums, int[] probability)
    {
        int n = nums.length;
        if (n != probability.length) {
            return -1;      
        }
 
        int[] prob_sum = new int[n];
 
        prob_sum[0] = probability[0];
        for (int i = 1; i < n; i++) {
            prob_sum[i] = prob_sum[i - 1] + probability[i];
        }
 
        int r = rand(1, 100);
 
 
        if (r <= prob_sum[0]) {    
            return nums[0];
        }
 
        for (int i = 1; i < n; i++)
        {
            if (r > prob_sum[i-1] && r <= prob_sum[i]) {
                return nums[i];
            }
        }
 
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] probability = { 30, 10, 20, 15, 25 };
 
        Map<Integer, Integer> freq = new HashMap<>();
 
        for (int i = 0; i < 1000000; i++)
        {
            int val = random(nums, probability);
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
 
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ~ " + freq.get(nums[i]) / 10000.0 + "%");
        }
    }
}


