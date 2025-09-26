package Sorting;

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
 
    public static Node sortList(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = new Node(), second = new Node(), third = new Node();
 
        Node zero = first, one = second, two = third;
 
        Node curr = head;
        while (curr != null)
        {
            if (curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }
            else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (second.next != null)? (second.next): (third.next);
        one.next = third.next;
        two.next = null;
 
        return first.next;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 0, 0, 1, 2, 1, 2, 1 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        head = sortList(head);
        printList(head);
    }
}