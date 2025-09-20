package Array;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
 
class printArr
{
    public static void printArray(int[] A, int i, int j)
    {
        System.out.println(IntStream.rangeClosed(i, j)
                .mapToObj(k -> A[k])
                .collect(Collectors.toList()));
    }
 
    public static int partition(int[] A)
    {
        for (int i = 0; i < A.length; i++)
        {
            int left_sum = 0;
            for (int j = 0; j < i; j++) {
                left_sum += A[j];
            }
 
            int right_sum = 0;
            for (int j = i; j < A.length; j++) {
                right_sum += A[j];
            }
 
            if (left_sum == right_sum) {
                return i;
            }
        }
 
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 6, -4, -3, 2, 3 };
 
        int i = partition(A);
 
        if (i != -1)
        {
            printArray(A, 0, i - 1);
 
            printArray(A, i, A.length - 1);
        }
        else {
            System.out.print("The array can't be partitioned");
        }
    }
}