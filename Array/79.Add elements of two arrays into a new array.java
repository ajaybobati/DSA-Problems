package Array;
import java.util.ArrayList;
import java.util.List;
 
class pli
{
    public static void split_number(int num, List<Integer> result)
    {
        if (num > 0)
        {
            split_number(num/10, result);
            result.add(num % 10);
        }
    }
 
    public static void add(int[] a, int[] b, List<Integer> result)
    {
        int m = a.length, n = b.length;
 
        int i = 0;
        while (i < m && i < n)
        {
            int sum = a[i] + b[i];
 
            split_number(sum, result);
            i++;
        }
 
        while (i < m) {
            split_number(a[i++], result);
        }
 
        while (i < n) {
            split_number(b[i++], result);
        }
    }
 
    public static void main(String[] args)
    {
        int[] a = { 23, 5, 2, 7, 87 };
        int[] b = { 4, 67, 2, 8 };
 
        List<Integer> result = new ArrayList<>();
        add(a, b, result);
 
        System.out.print(result);
    }
}