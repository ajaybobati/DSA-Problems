package Queue;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
class Node
{
    int v, parent;
 
    Node(int v, int parent)
    {
        this.v = v;
        this.parent = parent;
    }
}
 
class Main
{
    public static boolean BFS(Graph graph, int src, int n)
    {
        boolean[] discovered = new boolean[n];
        discovered[src] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(src, -1));
        while (!q.isEmpty())
        {
            Node node = q.poll();
            for (int u: graph.adjList.get(node.v))
            {
                if (!discovered[u])
                {
                    discovered[u] = true;
                    q.add(new Node(u, node.v));
                }
                else if (u != node.parent)
                {
                    return true;
                }
            }
        }
        return false;
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                                new Edge(1, 4), new Edge(1, 5), new Edge(4, 8),
                                new Edge(4, 9), new Edge(3, 6), new Edge(3, 7),
                                new Edge(6, 10), new Edge(6, 11), new Edge(5, 9)
                               
                            );
        int n = 12;
 
        Graph graph = new Graph(edges, n);
 
        if (BFS(graph, 0, n)) {
            System.out.println("The graph contains a cycle");
        }
        else {
            System.out.println("The graph doesn't contain any cycle");
        }
    }
}

