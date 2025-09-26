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
 
    Node() {}
}
 
class Main
{
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
 
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
    public static Node shuffleMerge(Node a, Node b)
    {
        Node dummy = new Node();
        Node tail = dummy;
 
        while (true)
        {
            if (a == null)
            {
                tail.next = b;
                break;
            }
 
            else if (b == null)
            {
                tail.next = a;
                break;
            }
            else {
                tail.next = a;
                tail = a;
                a = a.next;
 
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
 
        return dummy.next;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node a = null, b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            a = new Node(keys[i], a);
        }
 
        for (int i = keys.length - 2; i >= 0; i = i - 2) {
            b = new Node(keys[i], b);
        }
 
        printList("First List: ", a);
        printList("Second List: ", b);
 
        Node head = shuffleMerge(a, b);
        printList("After Merge: ", head);
    }}