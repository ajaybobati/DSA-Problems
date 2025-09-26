package Greedy;

import java.util.*;
 
class Edge
{
    int src, dest, weight;
 
    public Edge(int src, int dest, int weight)
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
 
    @Override
    public String toString() {
        return "(" + src + ", " + dest + ", " + weight + ")";
    }
}
class DisjointSet
{
    Map<Integer, Integer> parent = new HashMap<>();
 
    public void makeSet(int n)
    {
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
        }
    }
    private int find(int k)
    {
        if (parent.get(k) == k) {
            return k;
        }
        return find(parent.get(k));
    }
    private void union(int a, int b)
    {
        int x = find(a);
        int y = find(b);
 
        parent.put(x, y);
    }
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n)
    {
        List<Edge> MST = new ArrayList<>();
 
        DisjointSet ds = new DisjointSet();
        ds.makeSet(n);
 
        int index = 0;
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));
 
        while (MST.size() != n - 1)
        {
            Edge next_edge = edges.get(index++);
 
            int x = ds.find(next_edge.src);
            int y = ds.find(next_edge.dest);
 
            if (x != y)
            {
                MST.add(next_edge);
                ds.union(x, y);
            }
        }
 
        return MST;
    }
}
 
class Main
{
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 7), new Edge(1, 2, 8), new Edge(0, 3, 5),
                new Edge(1, 3, 9), new Edge(1, 4, 7), new Edge(2, 4, 5),
                new Edge(3, 4, 15), new Edge(3, 5, 6), new Edge(4, 5, 8),
                new Edge(4, 6, 9), new Edge(5, 6, 11));
 
        int n = 7;
        List<Edge> e = DisjointSet.runKruskalAlgorithm(edges, n);
        System.out.println(e);
    }
}


