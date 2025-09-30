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
    public static Node pop(Node headRef)
    {
        if (headRef == null) {
            return null;
        }
 
        int result = headRef.data;  
        headRef = headRef.next;     
 
        System.out.println("The popped node is " + result);
 
        return headRef;
    }
 
    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        head = pop(head);
        printList(head);
    }
}

