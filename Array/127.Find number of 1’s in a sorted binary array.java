
package Array;
class numer1
{
    public static int count(int[] nums, int left, int right)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }
 
        if (nums[right] == 0) {
            return 0;
        }
        if (nums[left] == 1) {
            return (right - left + 1);
        }
        int mid = (left + right) / 2;
        return count(nums, left, mid) + count(nums, mid + 1, right);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 0, 0, 0, 0, 1, 1, 1 };
 
        System.out.println("The total number of 1's present is "
                                    + count(nums, 0, nums.length - 1));
    }
}