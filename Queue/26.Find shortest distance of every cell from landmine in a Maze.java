package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Arrays;
 
class Node
{
    int x;             
    int y;              
    int distance;       
 
    Node(int x, int y, int distance)
    {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
 
class Main
{
    private static boolean isValid(int i, int j, int M, int N) {
        return (i >= 0 && i < M) && (j >= 0 && j < N);
    }
 
    private static boolean isSafe(int i, int j, char[][] mat, int[][] result) {
        return mat[i][j] == 'O' && result[i][j] == -1;
    }
 
    public static int[][] updateShortestDistance(char[][] mat)
    {
        if (mat == null || mat.length == 0) {
            return null;
        }
 
        int M = mat.length;
        int N = mat[0].length;
 
        int[][] result = new int[M][N];
        Queue<Node> q = new ArrayDeque<>();
 
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] == 'M')
                {
                    q.add(new Node(i, j, 0));
 
                    result[i][j] = 0;
                }
                else {
                    result[i][j] = -1;
                }
            }
        }
        int[] row = { 0, -1, 0, 1 };
        int[] col = { -1, 0, 1, 0 };
        while (!q.isEmpty())
        {
            int x = q.peek().x;
            int y = q.peek().y;
            int distance = q.peek().distance;
            q.poll();
            for (int i = 0; i < row.length; i++)
            {
                if (isValid(x + row[i], y + col[i], M, N) &&
                        isSafe(x + row[i], y + col[i], mat, result))
                {
                    result[x + row[i]][y + col[i]] = distance + 1;
                    q.add(new Node(x + row[i], y + col[i], distance + 1));
                }
            }
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        char[][] mat =
                {
                        {'O', 'M', 'O', 'O', 'X'},
                        {'O', 'X', 'X', 'O', 'M'},
                        {'O', 'O', 'O', 'O', 'O'},
                        {'O', 'X', 'X', 'X', 'O'},
                        {'O', 'O', 'M', 'O', 'O'},
                        {'O', 'X', 'X', 'M', 'O'}
                };
 
        int[][] result = updateShortestDistance(mat);
 
        for (var r: result) {
            System.out.println(Arrays.toString(r));
        }
    }
}

