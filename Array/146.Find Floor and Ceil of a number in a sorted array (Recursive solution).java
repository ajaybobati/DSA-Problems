package Array;

class findCe
{
    public static int findCeiling(int[] nums, int left, int right, int x)
    {
        if (nums.length == 0) {
            return -1;
        }
        if (x <= nums[left]) {
            return nums[left];
        }
        if (x > nums[right]) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == x) {
            return nums[mid];
        }
        else if (nums[mid] < x) {
            return findCeiling(nums, mid + 1, right, x);
        }
        else {
            return findCeiling(nums, left, mid, x);
        }
    }
    public static int findFloor(int[] nums, int left, int right, int x)
    {
        if (nums.length == 0) {
            return -1;
        }
        if (x < nums[left]) {
            return -1;
        }
        if (x >= nums[right]) {
            return nums[right];
        }
 
        int mid = (left + right) / 2;
        if (mid == left) {
            return nums[left];
        }
        if (nums[mid] == x) {
            return nums[mid];
        }
        else if (nums[mid] < x) {
            return findFloor(nums, mid, right, x);
        }
        else {
            return findFloor(nums, left, mid - 1, x);
        }
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 1, 4, 6, 8, 9 };
 
        for (int i = 0; i <= 10; i++)
        {
            System.out.printf("Number %2d —> ceiling is %2d, floor is %2d\n", i,
                    findCeiling(nums, 0, nums.length - 1, i),
                    findFloor(nums, 0, nums.length - 1, i));
        }
    }
}


