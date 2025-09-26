
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
    public static Node[] alternatingSplit(Node source)
    {
        Node a = null;
        Node b = null;
        Node current = source;
 
        while (current != null)
        {
 
            Node newNode = current;         
            current = current.next;         
            newNode.next = a;               
            a = newNode;                   
 
            if (current != null)
            {
 
                newNode = current;          
                current = current.next;     
 
                newNode.next = b;           
                b = newNode;                
            }
        }
 
        return new Node[] { a, b };
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        Node[] nodes = alternatingSplit(head);
 
        printList("First List: ", nodes[0]);
        printList("Second List: ", nodes[1]);
    }
}

