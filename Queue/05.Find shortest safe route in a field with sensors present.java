package Queue;


import java.util.ArrayDeque;
import java.util.Queue;
    
class Node
{
    int x, y, dist;
 
    Node(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
 
class Main
{
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };
 
    private static boolean isSafe(int[][] field, boolean visited[][], int x, int y) {
        return (field[x][y] == 1 && !visited[x][y]);
    }
 
    private static boolean isValid(int x, int y, int M, int N) {
        return (x < M && y < N && x >= 0 && y >= 0);
    }
    private static int BFS(int[][] field)
    {
        int M = field.length;
        int N = field[0].length;
 
        boolean[][] visited = new boolean[M][N];
 
        Queue<Node> q = new ArrayDeque<>();
 
        for (int r = 0; r < M; r++)
        {
            if (field[r][0] == 1)
            {
                q.add(new Node(r, 0, 0));
                visited[r][0] = true;
            }
        }
        while (!q.isEmpty())
        {
            int i = q.peek().x;
            int j = q.peek().y;
            int dist = q.peek().dist;
            q.poll();
            if (j == N - 1) {
                return dist;
            }
 
            for (int k = 0; k < row.length; k++)
            {
                if (isValid(i + row[k], j + col[k], M, N) &&
                        isSafe(field, visited, i + row[k], j + col[k]))
                {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    public static int findShortestDistance(int[][] mat)
    {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int M = mat.length;
        int N = mat[0].length;
        int[] r = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] c = { -1, 0, 1, -1, 1, -1, 0, 1 };
 
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < r.length; k++) {
                    if (mat[i][j] == 0 && isValid(i + r[k], j + c[k], M, N)
                            && mat[i + r[k]][j + c[k]] == 1) {
                        mat[i + r[k]][j + c[k]] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] == Integer.MAX_VALUE) {
                    mat[i][j] = 0;
                }
            }
        }
        return BFS(mat);
    }
 
    public static void main(String[] args)
    {
        int[][] field =
                {
                        { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
                };
 
        int dist = findShortestDistance(field);
 
        if (dist != Integer.MAX_VALUE) {
            System.out.print("The shortest safe path has a length of " + dist);
        }
        else {
            System.out.print("No route is safe to reach destination");
        }
    }
}