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
    // Helper function to print a given linked list
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
 
    // Takes two lists sorted in increasing order and merge their nodes
    // to make one big sorted list, which is returned
    public static Node sortedMerge(Node a, Node b)
    {
        // base cases
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }
 
        Node result;
 
        // pick either `a` or `b`, and recur
        if (a.data <= b.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
 
        return result;
    }
 
    /*
        Split the given list's nodes into front and back halves,
        If the length is odd, the extra node should go in the front list.
        It uses the fast/slow pointer strategy
    */
    public static Node[] frontBackSplit(Node source)
    {
        if (source == null || source.next == null) {
            return new Node[]{ source, null };
        }
 
        Node slow = source;
        Node fast = source.next;
        while (fast != null)
        {
            fast = fast.next;
            if (fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        Node[] arr = new Node[]{ source, slow.next };
        slow.next = null;
 
        return arr;
    }
    public static Node mergesort(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }
 
        Node[] arr = frontBackSplit(head);
        Node front = arr[0];
        Node back = arr[1];
        front = mergesort(front);
        back = mergesort(back);
        return sortedMerge(front, back);
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 8, 6, 4, 9, 3, 1 };
 
        Node head = null;
        for (int key: keys) {
            head = new Node(key, head);
        }
        head = mergesort(head);
        printList(head);
    }
}
