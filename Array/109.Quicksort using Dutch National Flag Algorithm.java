package Array;

import java.util.Arrays;
 
class Pair
{
    private int x;
    private int y;
 
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
 
    public int getX() { return x; }
    public int getY() { return y; }
}
 
class Main
{
    public static void swap (int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
 
    public static Pair partition(int[] nums, int start, int end)
    {
        int mid = start;
        int pivot = nums[end];
 
        while (mid <= end)
        {
            if (nums[mid] < pivot)
            {
                swap(nums, start, mid);
                ++start;
                ++mid;
            }
            else if (nums[mid] > pivot)
            {
                swap(nums, mid, end);
                --end;
            }
            else {
                ++mid;
            }
        }
 
        return new Pair(start - 1, mid);
    }
    public static void quicksort(int[] nums, int start, int end)
    {
        if (start >= end) {
            return;
        }
        Pair pivot = partition(nums, start, end);
        quicksort(nums, start, pivot.getX());
        quicksort(nums, pivot.getY(), end);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 6, 5, 2, 6, 8, 6, 1, 2, 6 };
 
        quicksort(nums, 0, nums.length - 1);
 
        System.out.println(Arrays.toString(nums));
    }
}