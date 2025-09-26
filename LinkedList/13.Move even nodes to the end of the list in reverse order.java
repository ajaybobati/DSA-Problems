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
    public static void rearrange(Node head)
    {
        // empty list
        if (head == null) {
            return;
        }
        Node odd = head;
        Node even = null, prev = null;
        while (odd != null && odd.next != null)
        {
            if (odd.next != null)
            {
                Node newNode = odd.next;
                odd.next = odd.next.next;
 
                newNode.next = even;
                even = newNode;
            }
            prev = odd;
            odd = odd.next;
        }
        if (odd != null) {
            odd.next = even;
        }
        else {
            prev.next = even;
        }
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        printList("Before: ", head);
 
        rearrange(head);
 
        printList("After: ", head);
    }
}
