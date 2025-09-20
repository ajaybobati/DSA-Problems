package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
class indDistinctCo
{
    public static int findDistinctCount(List<Integer> input)
    {
        Set<Integer> set = new HashSet<>();
        for (int i: input) {
            set.add(Math.abs(i));
        }
 
        return set.size();
    }
 
    public static void main(String[] args)
    {
        List<Integer> input = Arrays.asList(-1, -1, 0, 1, 1, 1);
 
        System.out.println("The total number of distinct absolute values is "
                                + findDistinctCount(input));
    }
}