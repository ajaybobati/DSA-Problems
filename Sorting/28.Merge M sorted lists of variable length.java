package Sorting;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
 
// A class to store a heap node
class Node implements Comparable
{
    private int value;
 
    private int i;
 
    private int index;
 
    public Node(int value, int i, int index)
    {
        this.value = value;
        this.i = i;
        this.index = index;
    }
 
    public int getValue() {
        return value;
    }
 
    public int getListNum() {
        return i;
    }
 
    public int getIndex() {
        return index;
    }
 
    public void setIndex(int index) {
        this.index = index;
    }
 
    public void setValue(int value) {
        this.value = value;
    }
 
    @Override
    public int compareTo(Object o)
    {
        Node node = (Node)o;
        return value - node.value;
    }
}
 
class Main
{
    public static void printSorted(List<List<Integer>> lists)
    {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
 
        for (int i = 0; i < lists.size(); i++)
        {
            if (lists.get(i).size() >= 1) {
                pq.add(new Node(lists.get(i).get(0), i, 0));
            }
        }
 
        while (!pq.isEmpty())
        {
            Node min = pq.poll();
 
            System.out.print(min.getValue() + " ");
 
            if (min.getIndex() + 1 < lists.get(min.getListNum()).size())
            {
                min.setIndex(min.getIndex() + 1);
                min.setValue(lists.get(min.getListNum()).get(min.getIndex()));
                pq.add(min);
            }
        }
    }
 
    public static void main(String[] args)
    {
        List<List<Integer>> lists = Arrays.asList(
                                        Arrays.asList(10, 20, 30, 40),
                                        Arrays.asList(15, 25, 35),
                                        Arrays.asList(27, 29, 37, 48, 93),
                                        Arrays.asList(32, 33)
                                    );
 
        printSorted(lists);
    }
}

