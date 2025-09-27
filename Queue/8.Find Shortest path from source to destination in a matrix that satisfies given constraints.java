package Queue;
import java.util.Queue;
import java.util.LinkedList;


 class ShortestPathInMatrix {

    static int[] rowDir = {-1, 1, 0, 0};
    static int[] colDir = {0, 0, -1, 1};

    static boolean isValid(int[][] grid, boolean[][] visited, int x, int y) {
        int n = grid.length, m = grid[0].length;
        return (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1 && !visited[x][y]);
    }
    public static int shortestPath(int[][] grid, int[] src, int[] dest) {
        int n = grid.length, m = grid[0].length;

        if (grid[src[0]][src[1]] == 0 || grid[dest[0]][dest[1]] == 0) {
            return -1; 
        }

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src[0], src[1], 0}); 
        visited[src[0]][src[1]] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1], dist = cell[2];

            if (x == dest[0] && y == dest[1]) {
                return dist;
            }
            for (int k = 0; k < 4; k++) {
                int newX = x + rowDir[k];
                int newY = y + colDir[k];

                if (isValid(grid, visited, newX, newY)) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, dist + 1});
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 1, 0 },
                { 0, 1, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 }
        };

        int[] src = {0, 0};  
        int[] dest = {3, 3}; 

        int result = shortestPath(grid, src, dest);

        if (result != -1)
            System.out.println("Shortest path length = " + result);
        else
            System.out.println("No path exists!");
    }
}

