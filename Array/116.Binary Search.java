package Array;
class binar
{
    public static int binarySearch(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
 
        while (left <= right)
        {
 
            int mid = (left + right) / 2;
 
            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
 
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 5, 6, 8, 9, 10 };
        int target = 5;
 
        int index = binarySearch(nums, target);
 
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}

