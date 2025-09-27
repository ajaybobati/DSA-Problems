package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
 
 class findLarges
{
    public static String findLargestNumber(List<Integer> nums)
    {
        // sort using a custom function object
        Collections.sort(nums, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
        return nums.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
 
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10, 68, 97, 9, 21, 12);
 
        String largestNumber = findLargestNumber(numbers);
        System.out.println("The largest number is " + largestNumber);
    }
}

