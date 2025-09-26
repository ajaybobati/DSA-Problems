package LinkedList;

class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
 
class Main
{
    public static Node findKthNode(Node head, int k)
    {
        int n = 0;
        Node curr = head;
        while (curr != null)
        {
            curr = curr.next;
            n++;
        }
        if (n >= k)
        {
            curr = head;
            for (int i = 0; i < n - k; i++) {
                curr = curr.next;
            }
        }
 
        return curr;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        int k = 3;
        Node node = findKthNode(head, k);
 
        if (node != null) {
            System.out.println("k'th node from the end is " + node.data);
        }
    }
}

