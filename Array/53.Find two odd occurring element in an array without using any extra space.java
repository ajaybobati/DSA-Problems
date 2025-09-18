package Array;
class findtwoodd
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
 
    public static void findOddOccuring(int[] arr)
    {
        int result = 0;
 
        for (int i: arr) {
            result = result ^ i;
        }
        int k = log(result & -result, 2);
 
       
        int x = 0, y = 0;
 
        for (int i: arr)
        {
            if ((i & (1 << k)) != 0) {
                x = x ^ i;
            }
 
            else {
                y = y ^ i;
            }
        }
 
        System.out.println("The odd occurring elements are " + x + " and " + y);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 3, 6, 2, 4, 2, 3, 4, 3, 3 };
        findOddOccuring(arr);
    }
}

