package Greedy;

import java.util.*;
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
 
class Main
{
    private static String[] color = {
            "", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",
            "BLACK", "BROWN", "WHITE", "PURPLE", "VOILET"
    };
 
    public static void colorGraph(Graph graph, int n)
    {
        Map<Integer, Integer> result = new HashMap<>();
 
        for (int u = 0; u < n; u++)
        {
            Set<Integer> assigned = new TreeSet<>();
 
            for (int i: graph.adjList.get(u))
            {
                if (result.containsKey(i)) {
                    assigned.add(result.get(i));
                }
            }
 
            int color = 1;
            for (Integer c: assigned)
            {
                if (color != c) {
                    break;
                }
                color++;
            }
            result.put(u, color);
        }
 
        for (int v = 0; v < n; v++)
        {
            System.out.println("The color assigned to vertex " + v + " is "
                    + color[result.get(v)]);
        }
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3), new Edge(2, 3), new Edge(2, 4)
        );
 
        int n = 6;
 
        Graph graph = new Graph(edges, n);
 
        colorGraph(graph, n);
    }
}
