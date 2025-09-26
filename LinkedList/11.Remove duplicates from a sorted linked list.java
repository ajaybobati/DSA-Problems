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
 
    public static Node removeDuplicates(Node head)
    {
        if (head == null) {
            return null;
        }
 
        Node current = head;
        while (current.next != null)
        {
            if (current.data == current.next.data)
            {
                Node nextNext = current.next.next;
                current.next = nextNext;
            }
            else {
                current = current.next;   
            }
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        int[] keys = {1, 2, 2, 2, 3, 4, 4, 5};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        } head = removeDuplicates(head);
 
        printList(head);
    }
}