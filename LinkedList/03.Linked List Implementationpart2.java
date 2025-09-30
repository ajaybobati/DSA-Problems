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
 
class newN
{
    public static Node newNode(int key)
    {
        Node node = new Node(key, null);
        return node;
    }
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
    public static Node appendNode(Node head, int key)
    {
        Node current = head;
        Node node = newNode(key);
        if (current == null) {
            head = node;
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4};
        Node head = null;
        for (int key: keys) {
            head = appendNode(head, key);
        }
 
        printList(head);
    }
}
