package Array;
import java.util.Arrays;
 
class findAllCombi
{
    public static void findAllCombinations(int[] arr, int x, int n)
    {
        if (x > n)
        {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < 2*n; i++)
        {
            if (arr[i] == -1 && (i + x + 1) < 2*n && arr[i + x + 1] == -1)
            {
                arr[i] = x;
                arr[i + x + 1] = x;
                findAllCombinations(arr, x + 1, n);
 
                arr[i] = -1;
                arr[i + x + 1] = -1;
            }
        }
    }
 
    public static void main(String[] args)
    {
        int n = 7;
        int[] arr = new int[2*n];
        Arrays.fill(arr, -1);
 
        int x = 1;
        findAllCombinations(arr, x, n);
    }
}