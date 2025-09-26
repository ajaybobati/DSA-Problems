package LinkedList;

class Node
{
    int data;
    Node next = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    static class NodeWrapper
    {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        return node;  
    }
    public static boolean checkPalindrome(NodeWrapper left, Node right)
    {
        if (right == null) {
            return true;
        }
 
        boolean result = checkPalindrome(left, right.next) &&
                            (left.node.data == right.data);
        left.node = left.node.next;
 
        return result;
    }
    public static boolean checkPalin(Node head)
    {
        return checkPalindrome(new NodeWrapper(head), head);
    }
 
    public static void main(String[] args)
    {
        int[] keys = {1, 3, 5, 3, 1};
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = push(head, keys[i]);
        }
 
        if (checkPalin(head)) {
            System.out.println("The linked list is a palindrome");
        }
        else {
            System.out.println("The linked list is not a palindrome");
        }
    }
}


