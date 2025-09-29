package Queue;

import java.util.*;
class Edge
{
    public final int src, dest, weight;
 
    private Edge(int src, int dest, int weight)
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
 
    public static Edge of(int a, int b, int c) {
        return new Edge(a, b, c);     
    }
}
class Node
{
    int vertex, weight;
    Set<Integer> s;
 
    Node(int vertex, int weight, Set<Integer> s)
    {
        this.vertex = vertex;
        this.weight = weight;
        this.s = s;
    }
}
 
class Graph
{
    List<List<Edge>> adjList = new ArrayList<>();
    public Graph(List<Edge> edges, int n)
    {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        for (Edge e: edges)
        {
            adjList.get(e.src).add(Edge.of(e.src, e.dest, e.weight));
            adjList.get(e.dest).add(Edge.of(e.dest, e.src, e.weight));
        }
    }
}
 
class Main
{
    public static int findMaxCost(Graph graph, int src, int k)
    {
        Queue<Node> q = new ArrayDeque<>();
        Set<Integer> vertices = new HashSet<>();
        vertices.add(src);
        q.add(new Node(src, 0, vertices));
        int maxCost = Integer.MIN_VALUE;
 
        while (!q.isEmpty())
        {
            Node node = q.poll();
 
            int v = node.vertex;
            int cost = node.weight;
            vertices = new HashSet<>(node.s);
            if (cost > k) {
                maxCost = Math.max(maxCost, cost);
            }
            for (Edge edge: graph.adjList.get(v))
            {
                if (!vertices.contains(edge.dest))
                {
                    Set<Integer> s = new HashSet<>(vertices);
                    s.add(edge.dest);
 
                    q.add(new Node(edge.dest, cost + edge.weight, s));
                }
            }
        }
        return maxCost;
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(Edge.of(0, 6, 11), Edge.of(0, 1, 5),
                                Edge.of(1, 6, 3), Edge.of(1, 5, 5), Edge.of(1, 2, 7),
                                Edge.of(2, 3, -8), Edge.of(3, 4, 10), Edge.of(5, 2, -1),
                                Edge.of(5, 3, 9), Edge.of(5, 4, 1), Edge.of(6, 5, 2),
                                Edge.of(7, 6, 9), Edge.of(7, 1, 6));
 
        int n = 8;
        Graph graph = new Graph(edges, n);
 
        int src = 0;
        int cost = 50;
        int maxCost = findMaxCost(graph, src, cost);
 
        if (maxCost != Integer.MIN_VALUE) {
            System.out.println(maxCost);
        }
        else {
            System.out.println("All paths from source have their costs < " + cost);
        }
    }
}