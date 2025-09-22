package Array;

import java.util.Arrays;
import java.util.Random;
 
class insertio
{
    private static final int N = 10000;
 
    private static final int NUM = 10;
 
    public static void insertionSort(int[] arr, int low, int n)
    {
        for (int i = low + 1; i <= n; i++)
        {
            int value = arr[i];
            int j = i;
            while (j > low && arr[j - 1] > value)
            {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = value;
        }
    }
 
    public static int partition(int[] a, int low, int high)
    {
        int pivot = a[high];
 
        int pIndex = low;
        for (int i = low; i < high; i++)
        {
            if (a[i] <= pivot)
            {
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
 
                pIndex++;
            }
        }
        int temp = a[high];
        a[high] = a[pIndex];
        a[pIndex] = temp;
 
        return pIndex;
    }
 
    public static void quicksort(int[] a, int low, int high)
    {
        if (low >= high) {
            return;
        }
        int pivot = partition(a, low, high);
 
        quicksort(a, low, pivot - 1);
 
        quicksort(a, pivot + 1, high);
    }
 
    public static void optimizedQuicksort(int[] A, int low, int high)
    {
        while (low < high)
        {
            if (high - low < 10)
            {
                insertionSort(A, low, high);
                break;
            }
            else {
                int pivot = partition(A, low, high);
 
                if (pivot - low < high - pivot)
                {
                    optimizedQuicksort(A, low, pivot - 1);
                    low = pivot + 1;
                }
                else {
                    optimizedQuicksort(A, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = new int[N];
 
        long begin, end;
        long t1 = 0, t2 = 0;
 
        for (int i = 0; i < NUM; i++)
        {
            Arrays.fill(arr, new Random().nextInt());
            int[] dup = Arrays.copyOf(arr, N);
 
 
            begin = System.nanoTime();
            quicksort(arr, 0, N - 1);
            end = System.nanoTime();
 
            t1 += (end - begin);
 
            begin = System.nanoTime();
            optimizedQuicksort(dup, 0, N - 1);
            end = System.nanoTime();
 
            t2 += (end - begin);
        }
 
        System.out.println("The average time taken by the non-optimized Quicksort: " +
                t1/NUM + "ns");
        System.out.println("The average time taken by the optimized Quicksort: " +
                t2/NUM + "ns");
    }
}