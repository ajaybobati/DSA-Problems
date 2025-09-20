package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class Pair
{
    public int x, y;
 
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
 
class findPa
{
    public static void findPairs(int[] nums)
    {
        Map<Integer, List<Pair>> map = new HashMap<>();
 
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                int sum = nums[i] + nums[j];
 
                if (map.containsKey(sum))
                {
                    for (Pair pair: map.get(sum))
                    {
                        int m = pair.x;
                        int n = pair.y;
 
                        if ((m != i && m != j) && (n != i && n != j))
                        {
                            System.out.printf("First Pair (%d, %d)\n", nums[i], nums[j]);
                            System.out.printf("Second Pair (%d, %d)\n", nums[m], nums[n]);
 
                            return;
                        }
                    }
                }
 
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new Pair(i, j));
            }
        }
 
        System.out.println("No non-overlapping pairs present");
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 3, 4, 7, 3, 4 };
 
        findPairs(nums);
    }
}

