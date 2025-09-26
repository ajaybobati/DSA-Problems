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
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
    public static Node reverse(Node head)
    {
        Node result = null;
        Node current = head;
 
        while (current != null)
        {
            Node next = current.next;
 
            current.next = result;
            result = current;
 
            current = next;
        }
 
        return result;
    }
 
    public static Node shuffleMerge(Node a, Node b)
    {
        if (a == null) {
            return b;
        }
 
        if (b == null) {
            return a;
        }
 
        Node recur = shuffleMerge(a.next, b.next);
 
        Node result = a;      
        a.next = b;             
        b.next = recur;         
 
        return result;
    }
 
    public static Node findMiddle(Node head)
    {
        Node prev = null;
        Node slow = head, fast = head;
 
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
 
        if (fast != null && fast.next == null)
        {
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
 
        return slow;
    }
 
    public static void rearrange(Node head)
    {
        if (head == null) {
            return;
        }
 
        Node mid = findMiddle(head);
 
        mid = reverse(mid);
        shuffleMerge(head, mid);
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        rearrange(head);
        printList(head);
    }
}
