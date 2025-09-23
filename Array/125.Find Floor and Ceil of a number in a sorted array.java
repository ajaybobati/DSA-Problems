package Array;

class flor
{
    public static int getCeil(int[] nums, int x)
    {
        int left = 0, right = nums.length - 1;
 
        int ceil = -1;
        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (nums[mid] == x) {
                return nums[mid];
            }
            else if (x < nums[mid])
            {
                ceil = nums[mid];
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
 
        return ceil;
    }
    public static int getFloor(int[] nums, int x)
    {
        int left = 0, right = nums.length - 1;
 
        int floor = -1;
 
        while (left <= right)
        {
            int mid = (left + right) / 2;
 
            if (nums[mid] == x) {
                return nums[mid];
            }
            else if (x < nums[mid]) {
                right = mid - 1;
            }
            else {
                floor = nums[mid];
                left = mid + 1;
            }
        }
 
        return floor;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 1, 4, 6, 8, 9 };
 
        for (int i = 0; i <= 10; i++) {
            System.out.println("Number " + i + " —> ceil is " + getCeil(nums, i)
                    + ", floor is " + getFloor(nums, i));
        }
    }
}


