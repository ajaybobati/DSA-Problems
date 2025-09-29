package DynamicProgramming;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
class Main
{
    public static boolean isValid(int[][] mat, int i, int j) {
        return (i >= 0 && i < mat.length && j >= 0 && j < mat.length);
    }
    public static List<Integer> findLongestPath(int[][] mat, int i, int j)
    {
        List<Integer> path = new ArrayList<>();
 
        if (!isValid (mat, i, j)) {
            return path;
        }
 
        if (i > 0 && mat[i - 1][j] - mat[i][j] == 1) {
            path = findLongestPath(mat, i - 1, j);
        }
        if (j + 1 < mat.length && mat[i][j + 1] - mat[i][j] == 1) {
            path = findLongestPath(mat, i, j + 1);
        }
 
        if (i + 1 < mat.length && mat[i + 1][j] - mat[i][j] == 1) {
            path = findLongestPath(mat, i + 1, j);
        }
        if (j > 0 && mat[i][j - 1] - mat[i][j] == 1) {
            path = findLongestPath(mat, i, j - 1);
        }
 
        path.add(mat[i][j]);
 
        return path;
    }
 
    public static List<Integer> findLongestPath(int[][] mat)
    {
        List<Integer> longest_path = new ArrayList<>();
 
        if (mat == null || mat.length == 0) {
            return longest_path;
        }
 
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
            {
                List<Integer> path = findLongestPath(mat, i, j);
 
                if (longest_path == null || path.size() > longest_path.size()) {
                    longest_path = path;
                }
            }
        }
 
        Collections.reverse(longest_path);
        return longest_path;
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 10, 13, 14, 21, 23 },
            { 11, 9, 22, 2, 3 },
            { 12, 8, 1, 5, 4 },
            { 15, 24, 7, 6, 20 },
            { 16, 17, 18, 19, 25 }
        };
        System.out.println(findLongestPath(mat));
    }
}

