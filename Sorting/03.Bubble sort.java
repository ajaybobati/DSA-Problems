package Sorting;

import java.util.Arrays;
 
class Main
{
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    public static void bubbleSort(int[] arr)
    {
        for (int k = 0; k < arr.length - 1; k++)
        {
            for (int i = 0; i < arr.length - 1 - k; i++)
            {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
 
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 3, 5, 8, 4, 1, 9, -2 };
 
        bubbleSort(arr);
 
        System.out.println(Arrays.toString(arr));
    }
}

