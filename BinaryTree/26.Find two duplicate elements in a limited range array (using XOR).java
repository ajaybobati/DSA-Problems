package BinaryTree;

class dupli
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
    public static void findDuplicates(int[] arr, int n)
    {
        int result = arr[0] ^ arr[n + 1];
        for (int i = 1; i <= n; i++) {
            result = result ^ arr[i] ^ i;
        }
        int x = 0, y = 0;
        int k = log(result & -result, 2);
        for (int i = 0; i < n + 2; i++)
        {
            if ((arr[i] & (1 << k)) != 0) {
                x = x ^ arr[i];
            }
            else {
                y = y ^ arr[i];
            }
        }
        for (int i = 1; i <= n; i++)
        {
            if ((i & (1 << k)) != 0) {
                x = x ^ i;
            }
            else {
                y = y ^ i;
            }
        }
 
        System.out.println("The duplicate elements are " + x + " and " + y);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 3, 6, 5, 2, 4, 1, 1 };
        int n = 6;     
 
        findDuplicates(arr, n);
    }
}