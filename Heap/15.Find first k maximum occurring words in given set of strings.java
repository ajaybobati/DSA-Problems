package Heap;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class Trie
{
    int count = 0;
    String key = null;
    Map<Character, Trie> character = new HashMap<>();
}
class Node implements Comparable
{
    String key;
    int count;
    Node(String key, int count)
    {
        this.key = key;
        this.count = count;
    }
 
    @Override
    public int compareTo(Object o)
    {
        Node node = (Node)o;
        return count - node.count;
    }
}
 
class Main
{
    private static void insert(Trie head, String str)
    {
        Trie curr = head;
 
        for (char c: str.toCharArray())
        {
            curr.character.putIfAbsent(c, new Trie());
 
            curr = curr.character.get(c);
        }
        curr.key = str;
        curr.count += 1;
    }
    private static void preorder(Trie curr, PriorityQueue<Node> pq)
    {
        if (curr == null) {
            return;
        }
 
        for (var entry: curr.character.entrySet())
        {
            if (entry.getValue().count != 0) {
                pq.add(new Node(entry.getValue().key, entry.getValue().count));
            }
            preorder(entry.getValue(), pq);
        }
    }
    public static void findKfrequentWords(String[] dict, int k)
    {
        Trie head = new Trie();
        for (String word: dict) {
            insert(head, word);
        }
 
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.reverseOrder());
 
        preorder(head, pq);
        while (k-- > 0 && !pq.isEmpty())
        {
            Node max = pq.poll();
            System.out.println(max.key + " occurs " + max.count + " times");
        }
    }
 
    public static void main (String[] args)
    {
        String[] dict =
        {
            "code", "coder", "coding", "codable", "codec", "codecs", "coded",
            "codeless", "codec", "codecs", "codependence", "codex", "codify",
            "codependents", "codes", "code", "coder", "codesign", "codec",
            "codeveloper", "codrive", "codec", "codecs", "codiscovered"
        };
 
        int k = 4;
 
        findKfrequentWords(dict, k);
    }
}