package Array;

class  searchCirc
{
    public static int searchCircularArray(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
 
        while (left <= right)
        {
            int mid = (left + right) / 2;
 
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] <= nums[right])
            {
                if (target > nums[mid] && target <= nums[right])
                {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;     
                }
            }
            else {
                if (target >= nums[left] && target < nums[mid])
                {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;     
                }
            }
        }
 
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] nums = {9, 10, 2, 5, 6, 8};
        int key = 5;
 
        int index = searchCircularArray(nums, key);
 
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}


