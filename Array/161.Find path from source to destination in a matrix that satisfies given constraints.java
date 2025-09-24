package Array;

import java.util.ArrayList;
import java.util.List;
class Node
{
    int first, second;
 
    public Node(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
 
    @Override
    public boolean equals(Object ob)
    {
        Node node = (Node) ob;
        return (first == node.first && second == node.second);
    }
 
    @Override
    public int hashCode() {
        return 31 * first + second;
    }
 
    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}
 
class isVali
{
    private static final int[] row = { -1, 0, 0, 1 };   
private static final int[] col = { 0, -1, 1, 0 };
 
    private static boolean isValid(List<Node> path, Node pt, int N)
    {
        return pt.first >= 0 && pt.first < N &&
                pt.second >= 0 && pt.second < N &&
                !path.contains(pt);
    }
    public static boolean findPath(int mat[][], List<Node> path, Node curr)
    {
        if (mat == null || mat.length == 0) {
            return false;
        }
        int N = mat.length;
        path.add(curr);
        if (curr.first == N - 1 && curr.second == N - 1) {
            return true;
        }
        int n = mat[curr.first][curr.second];
 
        for (int i = 0; i < row.length; i++)
        {
            int x = curr.first + row[i] * n;
            int y = curr.second + col[i] * n;
 
            Node next = new Node(x, y);
            if (isValid(path, next, N) && findPath(mat, path, next)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
 
    public static void main(String[] args)
    {
        int mat[][] =
        {
            { 7, 1, 3, 5, 3, 6, 1, 1, 7, 5 },
            { 2, 3, 6, 1, 1, 6, 6, 6, 1, 2 },
            { 6, 1, 7, 2, 1, 4, 7, 6, 6, 2 },
            { 6, 6, 7, 1, 3, 3, 5, 1, 3, 4 },
            { 5, 5, 6, 1, 5, 4, 6, 1, 7, 4 },
            { 3, 5, 5, 2, 7, 5, 3, 4, 3, 6 },
            { 4, 1, 4, 3, 6, 4, 5, 3, 2, 6 },
            { 4, 4, 1, 7, 4, 3, 3, 1, 4, 2 },
            { 4, 4, 5, 1, 5, 2, 3, 5, 3, 5 },
            { 3, 6, 3, 5, 2, 2, 6, 4, 2, 1 }
        };
 
        List<Node> path = new ArrayList<>();
        Node source = new Node(0, 0);
 
        if (findPath(mat, path, source)) {
            System.out.println(path);
        }
    }
}


