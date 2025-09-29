package DynamicProgramming;


class Main
{
    public static boolean isSafe(int[][] mat, int i, int j)
    {
        return !(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length ||
                mat[i][j] == -1);
    }
 
    public static int findMaximum(int[][] mat, int i, int j)
    {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        if (!isSafe(mat, i, j)) {
            return 0;
        }
        if ((i & 1) == 1) {
            return mat[i][j] + Integer.max(findMaximum(mat, i, j - 1),
                                        findMaximum(mat, i + 1, j));
        }
        else {
            return mat[i][j] + Integer.max(findMaximum(mat, i, j + 1),
                                        findMaximum(mat, i + 1, j));
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 1, 1, -1, 1, 1 },
            { 1, 0, 0, -1, 1 },
            { 1, 1, 1, 1, -1 },
            { -1, -1, 1, 1, 1 },
            { 1, 1, -1, -1, 1 }
        };
 
        System.out.println("The maximum value collected is " + findMaximum(mat, 0, 0));
    }
}


