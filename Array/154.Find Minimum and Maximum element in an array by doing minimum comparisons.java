package Array;
class Pair
{
    public int max, min;
 
    public Pair(int max, int min)
    {
        this.max = max;
        this.min = min;
    }
}
 
class mandmax
{
    public static void findMinAndMax(int[] nums, int left, int right, Pair p)
    {
        if (left == right)                  
        {
            if (p.max < nums[left]) {          
                p.max = nums[left];
            }
 
            if (p.min > nums[right]) {         
                p.min = nums[right];
            }
 
            return;
        }
        if (right - left == 1)              
        {
            if (nums[left] < nums[right])         
            {
                if (p.min > nums[left]) {      
                    p.min = nums[left];
                }
 
                if (p.max < nums[right]) {     
                    p.max = nums[right];
                }
            }
            else {
                if (p.min > nums[right]) {     
                    p.min = nums[right];
                }
 
                if (p.max < nums[left]) {     
                    p.max = nums[left];
                }
            }
 
            return;
        }
        int mid = (left + right) / 2;
        findMinAndMax(nums, left, mid, p);
        findMinAndMax(nums, mid + 1, right, p);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 7, 2, 9, 3, 1, 6, 7, 8, 4 };
        Pair p = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
        findMinAndMax(nums, 0, nums.length - 1, p);
 
        System.out.println("The minimum array element is " + p.min);
        System.out.println("The maximum array element is " + p.max);
    }
}


