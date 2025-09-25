package Heap;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Node implements Comparable
{
    private int value;
    private int listNum;
 
    private int index;
 
    Node(int value, int listNum, int index)
    {
        this.value = value;
        this.listNum = listNum;
        this.index = index;
    }
 
    public int getValue() {
        return value;
    }
 
    public int getListNum() {
        return listNum;
    }
 
    public int getIndex() {
        return index;
    }
 
    @Override
    public int compareTo(Object o)
    {
        Node node = (Node)o;
        return value - node.value;
    }
}
class Pair<U, V> {
    private final U first;      
    private final V second;     
 
    Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }
 
    public U getFirst() {
        return first;
    }
 
    public V getSecond() {
        return second;
    }
 
    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}
 
class Main
{
    public static Pair<Integer, Integer> findMinimumRange(List<List<Integer>> lists)
    {
        if (lists == null || lists.size() == 0) {
            return new Pair(-1, -1);
        }
        int high = Integer.MIN_VALUE;
 
        Pair<Integer, Integer> p = new Pair(0, Integer.MAX_VALUE);
 
        PriorityQueue<Node> pq = new PriorityQueue<>();
 
        for (int i = 0; i < lists.size(); i++)
        {
            if (lists.get(i) == null || lists.get(i).size() == 0) {
                return new Pair(-1, -1);
            }
 
            pq.add(new Node(lists.get(i).get(0), i, 0));
            high = Integer.max(high, lists.get(i).get(0));
        }
        while (true)
        {
            Node top = pq.poll();
            int low = top.getValue();
            int i = top.getListNum();
            int j = top.getIndex();
            if (high - low < p.getSecond() - p.getFirst()) {
                p = new Pair(low, high);
            }
            if (j == lists.get(i).size() - 1) {
                return p;
            }
            pq.add(new Node(lists.get(i).get(j + 1), i, j + 1));
 
            high = Integer.max(high, lists.get(i).get(j + 1));
        }
    }
 
    public static void main(String[] args)
    {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(3, 6, 8, 10, 15),
                Arrays.asList(1, 5, 12),
                Arrays.asList(4, 8, 15, 16),
                Arrays.asList(2, 6)
        );
 
        System.out.println("The minimum range is " + findMinimumRange(lists));
    }
}