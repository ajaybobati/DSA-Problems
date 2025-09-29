package DynamicProgramming;


class Main
{
    private static final int M = 100;
 
    public static int findMinAdjustmentCost(int[] A, int target)
    {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[][] T = new int[A.length][M + 1];
 
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j <= M; j++)
            {
                if (i == 0) {
                    T[i][j] = Math.abs(j - A[i]);
                }
                else {
                    T[i][j] = Integer.MAX_VALUE;
                    int k = Integer.max(j - target, 0);
                    while (k <= Integer.min(M, j + target))
                    {
                        T[i][j] = Integer.min(T[i][j], T[i-1][k] + Math.abs(A[i] - j));
                        k++;
                    }
                }
            }
        }
 
        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= M; j++) {
            result = Integer.min(result, T[A.length - 1][j]);
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 55, 77, 52, 61, 39, 6, 25, 60, 49, 47 };
        int target = 10;
 
        System.out.println("The minimal adjustment cost is " +
                    findMinAdjustmentCost(A, target));
    }
}