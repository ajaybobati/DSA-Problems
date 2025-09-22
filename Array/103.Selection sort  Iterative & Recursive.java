package Array;

import java.util.Arrays;
 
class selectionSor
{
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr, int i, int n)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[min]) {
                min = j;   
            }
        }
 
        swap(arr, min, i);
 
        if (i + 1 < n) {
            selectionSort(arr, i + 1, n);
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 3, 5, 8, 4, 1, 9, -2 };
 
        selectionSort(arr, 0, arr.length);
 
        System.out.println(Arrays.toString(arr));
    }
}