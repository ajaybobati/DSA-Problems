package Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
class mergsper
{
    public static void merge(int[] arr, int[] aux, int low, int mid, int high,
                            Map<Integer, Integer> count)
    {
        int k = low, i = low, j = mid + 1;
        int c = 0;
 
        while (i <= mid && j <= high)
        {
            if (arr[i] > arr[j])
            {
                count.put(arr[i], count.getOrDefault(arr[i], 0) + c);
 
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
                c++;
            }
        }
 
        while (i <= mid)
        {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + c);
            aux[k++] = arr[i++];
        }
        while (low <= high)
        {
            arr[low] = aux[low];
            low++;
        }
    }
    public static void mergesort(int[] arr, int[] aux, int low, int high,
                                Map<Integer, Integer> count)
    {
        if (high <= low) {
            return;
        }
 
        int mid = (low + ((high - low) >> 1));
 
        mergesort(arr, aux, low, mid, count);
        mergesort(arr, aux, mid + 1, high, count);
 
        merge(arr, aux, low, mid, high, count);
    }
 
    public static Map<Integer, Integer> getSurpasserCount(int[] A)
    {
        Map<Integer, Integer> count = new HashMap<>();
 
        int[] aux = Arrays.copyOf(A, A.length);
        int[] arr = Arrays.copyOf(A, A.length);
 
        mergesort(arr, aux, 0, A.length - 1, count);
 
        return count;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 4, 6, 3, 9, 7, 10 };
 
        Map<Integer, Integer> surpasserCount = getSurpasserCount(A);
 
        for (int value: A) {
            System.out.print(surpasserCount.get(value) + " ");
        }
    }
}