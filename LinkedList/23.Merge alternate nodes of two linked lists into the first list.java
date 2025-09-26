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
    public static Node[] merge(Node a, Node b)
    {
        Node dummy = new Node();
        Node tail = dummy;
 
        while (true)
        {
            if (a == null)
            {
                tail.next = null; 
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
 
        a = dummy.next;
        return new Node[] { a, b };
    }
 
    public static void main(String[] args)
    {
        Node a = null, b = null;
 
        for (int i = 3; i >= 0; i--) {
            a = new Node(i, a);
        }
        for (int i = 10; i >= 4; i--) {
            b = new Node(i, b);
        }
 
        printList("First List: ", a);
        printList("Second List: ", b);
 
        Node[] arr = merge(a, b);
        a = arr[0];
        b = arr[1];
 
        System.out.println("\nAfter Merge: \n");
 
        printList("First List: ", a);
        printList("Second List: ", b);
    }
}

