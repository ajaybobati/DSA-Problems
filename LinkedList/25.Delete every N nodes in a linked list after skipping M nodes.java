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
    public static Node deleteNodes(Node head, int m, int n)
    {
        if (head == null || head.next == null) {
            return head;
        }
 
        Node prev = null, next;
        Node curr = head;
 
        for (int i = 1; curr != null && i <= m; i++)
        {
            prev = curr;
            curr = curr.next;
        }
        for (int i = 1; curr != null && i <= n; i++)
        {
            next = curr.next;
            curr = next;
        }
        prev.next = curr;
        deleteNodes(curr, m, n);
 
        return head;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        head = deleteNodes(head, 1, 3);
        printList(head);
    }
}