package Array;

class searc
{
    public static int searchElement(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
 
        while (left <= right)
        {
            int mid = (left + right) / 2;
 
            if (nums[mid] == target) {
                return mid;
            }
            else if (mid - 1 >= left && nums[mid - 1] == target) {
                return mid - 1;
            }
            else if (mid + 1 <= right && nums[mid + 1] == target) {
                return mid + 1;
            }
            else if (target > nums[mid]) {
                left = mid + 2;
            }
            else {
                right = mid - 2;
            }
        }
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 1, 3, 5, 4, 7, 6, 8, 9 };
        int target = 5;
 
        int index = searchElement(nums, target);
 
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}

