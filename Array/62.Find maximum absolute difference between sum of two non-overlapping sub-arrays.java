package Array;

class findMaxSumS
{
    public static void findMaxSumSubarray(int[] A, int[] aux, int i, int j,
                                                            int diff)
    {
        int max_so_far = A[i];
        int max_ending_here = A[i];
        aux[i] = A[i];
 
        for (int k = i + diff; k != j; k += diff)
        {
            max_ending_here = Integer.max(A[k], max_ending_here + A[k]);
 
            max_so_far = Integer.max(max_so_far, max_ending_here);
            aux[k] = max_so_far;
        }
    }
 
    public static void fillArrays(int[] A, int[] left_max, int[] right_max,
                    int[] left_min, int[] right_min, int n)
    {
        findMaxSumSubarray(A, left_max, 0, n - 1, 1);
        findMaxSumSubarray(A, right_max, n - 1, 0, -1);
 
        for (int i = 0; i < n; i++) {
            A[i] = -A[i];
        }
 
        findMaxSumSubarray(A, left_min, 0, n - 1, 1);
        findMaxSumSubarray(A, right_min, n - 1, 0, -1);
 
        for (int i = 0; i < n; i++) {
            left_min[i] = -left_min[i];
        }
 
        for (int i = 0; i < n; i++) {
            right_min[i] = -right_min[i];
        }
        for (int i = 0; i < n; i++) {
            A[i] = -A[i];
        }
    }
    public static int findMaxAbsDiff(int[] A)
    {
        int n = A.length;
 
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return A[0];
        }
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int[] left_min = new int[n];
        int[] right_min = new int[n];
 
        fillArrays(A, left_max, right_max, left_min, right_min, n);

        int max_abs_diff = Integer.MIN_VALUE;
 
        for (int i = 0; i < n - 1; i++)
        {
            int abs_diff = Integer.max(Math.abs(left_max[i] - right_min[i+1]),
                                    Math.abs(left_min[i] - right_max[i+1]));
            max_abs_diff = Integer.max(max_abs_diff, abs_diff);
        }
 
        return max_abs_diff;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -3, -2, 6, -3, 5, -9, 3, 4, -1, -8, 2 };
 
        System.out.print("The maximum absolute difference is " + findMaxAbsDiff(A));
    }
}