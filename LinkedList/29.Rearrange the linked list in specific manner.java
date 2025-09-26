package LinkedList;

class Node
{
    int data;
    Node next;
 
    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
 
    public Node() {}
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
 
    public static void rearrange(Node head)
    {
        if (head == null || head.next == null) {
            return;
        }
        Node dummyFirst = new Node();
        Node dummySecond = new Node();
        Node first = dummyFirst;
        Node second = dummySecond;
 
        Node curr = head;
 
        while (curr != null)
        {
            first.next = curr;
            first = first.next;
            if (curr.next != null)
            {
                second.next = curr.next;
                second = second.next;
                curr = curr.next;
            }
            curr = curr.next;
        }
 
        first.next = dummySecond.next;
        second.next = null;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        rearrange(head);
 
        printList(head);
    }
}

