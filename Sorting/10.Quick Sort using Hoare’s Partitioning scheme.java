package Sorting;

import java.util.Arrays;
 
class Main
{
    public static void swap (int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] a, int low, int high)
    {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;
 
        while (true)
        {
            do {
                i++;
            } while (a[i] < pivot);
 
            do {
                j--;
            } while (a[j] > pivot);
 
            if (i >= j) {
                return j;
            }
 
            swap(a, i, j);
        }
    }
    public static void quicksort(int[] a, int low, int high)
    {
        if (low >= high) {
            return;
        }
        int pivot = partition(a, low, high);
        quicksort(a, low, pivot);
 
        quicksort(a, pivot + 1, high);
    }
 
    public static void main(String[] args)
    {
        int[] a = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
 
        quicksort(a, 0, a.length - 1);
 
        System.out.println(Arrays.toString(a));
    }
}

