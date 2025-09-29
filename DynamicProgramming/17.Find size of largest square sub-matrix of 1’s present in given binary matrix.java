package DynamicProgramming;


import java.util.concurrent.atomic.AtomicInteger;
 
class Main
{
    public static int findLargestSquare(int[][] mat, int m, int n,
            AtomicInteger maxsize)
    {
        if (m < 0 || n < 0) {
            return 0;
        }
        int left = findLargestSquare(mat, m, n - 1, maxsize);
        int top = findLargestSquare(mat, m - 1, n, maxsize);
 
        int diagonal = findLargestSquare(mat, m - 1, n - 1, maxsize);
 
        int size = 0;
        if (mat[m][n] != 0) {
            size = 1 + Integer.min(Integer.min(top, left), diagonal);
        }
        maxsize.set(Integer.max(maxsize.get(), size));
 
        return size;
    }
 
    public static int findLargestSquareSubmatrix(int[][] mat)
    {
        if (mat == null || mat.length == 0) {
            return 0;
        }
 
        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;
        AtomicInteger maxsize = new AtomicInteger();
 
        findLargestSquare(mat, M - 1, N - 1, maxsize);
        return maxsize.get();
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 0, 0, 1, 0, 1, 1 },
                        { 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1, 1 }
                };
 
        System.out.println("The size of largest square submatrix of 1's is " +
                findLargestSquareSubmatrix(mat));
    }
}

