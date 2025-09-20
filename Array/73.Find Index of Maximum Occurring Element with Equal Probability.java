package Array;

import java.util.*;
 
class Maxim
{
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
    public static int findIndex(int[] nums)
    {
       
        Map<Integer, Integer> count = new HashMap<>();
        for (int i: nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
 
        int max_occurring = nums[0];
        for (int i: nums)
        {
            if (count.get(max_occurring) < count.get(i)) {
                max_occurring = i;
            }
        }
        int k = rand(1, count.get(max_occurring));
 
        int index = 0;
        while (k != 0 && index < nums.length)
        {
            if (nums[index] == max_occurring) {
                k--;
            }
            index++;
        }
 
        return index - 1;
    }
 
    public static void main(String[] args)
    {
        int[] nums = {4, 3, 6, 8, 4, 6, 2, 4, 5, 9, 7, 4};
 
        for (int i = 0; i < 5; i++)
        {
            System.out.println("The index of the maximum occurring element is "
                    + findIndex(nums));
        }
    }
}