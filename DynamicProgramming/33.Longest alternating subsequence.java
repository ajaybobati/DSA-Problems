package DynamicProgramming;

class Main
{
    public static int util(int[] A, int start, int end, boolean flag)
    {
        int result = 0;
        for (int i = start; i <= end; i++)
        {
            if (flag && A[i - 1] < A[i]) {
                result = Integer.max(result, 1 + util(A, i + 1, end, !flag));
            }
            else if (!flag && A[i - 1] > A[i]) {
                result = Integer.max(result, 1 + util(A, i + 1, end, !flag));
            }
 
            else {
                result = Integer.max(result, util(A, i + 1, end, flag));
            }
        }
 
        return result;
    }
    public static int findLongestSequence(int[] A)
    {
        // base case
        if (A == null || A.length == 0) {
            return 0;
        }
 
        return 1 + Integer.max(util(A, 1, A.length - 1, true),
                            util(A, 1, A.length - 1, false));
 
    }
 
    public static void main(String[] args)
    {
        int[] A = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };
 
        System.out.println("The length of the longest alternating subsequence is "
                + findLongestSequence(A));
    }
}