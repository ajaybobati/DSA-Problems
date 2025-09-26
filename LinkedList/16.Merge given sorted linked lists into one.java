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
    public static Node sortedMerge(Node a, Node b)
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
 
            if (a.data <= b.data)
            {
                if (a != null)
                {
                    Node newNode = a;
                    a = a.next;
 
                    newNode.next = tail.next;
                    tail.next = newNode;
                }
            }
            else {
                if (b != null)
                {
                    Node newNode = b;
                    b = b.next;
 
                    newNode.next = tail.next;
                    tail.next = newNode;
                }
            }
            tail = tail.next;
        }
 
        return dummy.next;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node a = null, b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            a = a = new Node(keys[i], a);
        }
 
        for (int i = keys.length - 2; i >= 0; i = i - 2) {
            b = b = new Node(keys[i], b);
        }
 
        printList("First List: ", a);
        printList("Second List: ", b);
 
        Node head = sortedMerge(a, b);
        printList("After Merge: ", head);
    }
}