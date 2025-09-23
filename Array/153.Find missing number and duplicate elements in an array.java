package Array;
import java.util.Arrays;
import java.util.stream.Collectors;
 
class findMissingAn
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
    public static void findMissingAndDuplicate(int[] arr)
    {
        int n = arr.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result = result ^ arr[i] ^ i;
        }
        int x = 0, y = 0;
        int k = log(result & -result, 2);
 
        for (int value: arr)
        {
            if ((value & (1 << k)) != 0) {
                x = x ^ value;
            }
            else {
                y = y ^ value;
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
 
        System.out.print("The duplicate and missing elements are ");
 
        if (Arrays.stream(arr).boxed().collect(Collectors.toList()).contains(x)) {
            System.out.println(x + " and " + y);
        }
        else {
            System.out.println(y + " and " + x);
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 3, 6, 5, 2, 4 };
 
        findMissingAndDuplicate(arr);
    }
}

