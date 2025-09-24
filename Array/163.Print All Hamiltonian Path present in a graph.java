package Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
class Graph
{
    List<List<Integer>> adjList = null;
 
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
 
class hamiltoni
{
    public static void hamiltonianPaths(Graph graph, int v, boolean[] visited,
                                            List<Integer> path, int n)
    {
        if (path.size() == n)
        {
            System.out.println(path);
            return;
        }
        for (int w: graph.adjList.get(v))
        {
            if (!visited[w])
            {
                visited[w] = true;
                path.add(w);
                hamiltonianPaths(graph, w, visited, path, n);
 
                visited[w] = false;
                path.remove(path.size() - 1);
            }
        }
    }
 
    public static void findHamiltonianPaths(Graph graph, int n)
    {
        for (int start = 0; start < n; start++)
        {
            List<Integer> path = new ArrayList<>();
            path.add(start);
            boolean[] visited = new boolean[n];
            visited[start] = true;
 
            hamiltonianPaths(graph, start, visited, path, n);
        }
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(2, 3)
        );
        int n = 4;
        Graph graph = new Graph(edges, n);
 
        findHamiltonianPaths(graph, n);
    }
}