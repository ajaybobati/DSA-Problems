package Array;

import java.util.Arrays;
 
class sortt
{
    private static void sortArray(int[] arr)
    {
        if (arr.length <= 1) {
            return;
        }
 
        int x = -1, y = -1;
        int prev = arr[0];
 
      
        for (int i = 1; i < arr.length; i++)
        {
            
            if (prev > arr[i])
            {
                if (x == -1)
                {
                    x = i - 1;
                    y = i;
                }
                else {
                    y = i;
                }
            }
            prev = arr[i];
        }
 
        swap(arr, x, y);
    }
 
    private static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 
    public static void main(String[] args)
    {
        int[] a = { 3, 5, 6, 9, 8, 7 };
 
        sortArray(a);
        System.out.println(Arrays.toString(a));
    }
}

