package Array;

class isValidCe
{
    private static boolean isValidCell(int x, int y, int N) {
        return !(x < 0 || y < 0 || x >= N || y >= N);
    }
 
    private static int countPaths(int[][] maze, int i, int j, int x, int y,
                                  boolean visited[][])
    {
        if (i == x && j == y) {
            return 1;
        }
        int count = 0;
        visited[i][j] = true;
        int N = maze.length;
 
        if (isValidCell(i, j, N) && maze[i][j] == 1)
        {
            if (i + 1 < N && !visited[i + 1][j]) {
                count += countPaths(maze, i + 1, j, x, y, visited);
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                count += countPaths(maze, i - 1, j, x, y, visited);
            }
            if (j + 1 < N && !visited[i][j + 1]) {
                count += countPaths(maze, i, j + 1, x, y, visited);
            }
 
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                count += countPaths(maze, i, j - 1, x, y, visited);
            }
        }
        visited[i][j] = false;
 
        return count;
    }
 
    public static int findCount(int[][] maze, int i, int j, int x, int y)
    {
        if (maze == null || maze.length == 0 || maze[i][j] == 0 || maze[x][y] == 0) {
            return 0;
        }
        int N = maze.length;
        boolean[][] visited = new boolean[N][N];
 
        return countPaths(maze, i, j, x, y, visited);
    }
 
    public static void main(String[] args)
    {
        int[][] maze =
        {
            { 1, 1, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 1 }
        };
        int count = findCount(maze, 0, 0, 3, 3);
 
        System.out.println("The total number of unique paths are " + count);
    }
}

