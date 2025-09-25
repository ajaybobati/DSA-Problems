package BinaryTree;
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class updateLevel
{
    static class NodeInfo
    {
        Node node = null;
        int level;
        Node parent = null;
 
        NodeInfo(Node node, int level, Node parent)
        {
            this.node = node;
            this.level = level;
            this.parent = parent;
        }
    }
    public static void updateLevelandParent(Node root, Node parent, int level,
                                            NodeInfo x, NodeInfo y)
    {
        if (root == null) {
            return;
        }
        updateLevelandParent(root.left, root, level + 1, x, y);
        if (root == x.node)
        {
            x.level = level;
            x.parent = parent;
        }
        if (root == y.node)
        {
            y.level = level;
            y.parent = parent;
        }
        updateLevelandParent(root.right, root, level + 1, x, y);
    }
    public static boolean checkCousins(Node root, Node node1, Node node2)
    {
        if (root == null) {
            return false;
        }
 
        int level = 1;         
        Node parent = null;     
 
        NodeInfo x = new NodeInfo(node1, level, parent);
        NodeInfo y = new NodeInfo(node2, level, parent);
 
        updateLevelandParent(root, null, 1, x, y);
        return x.level == y.level && x.parent != y.parent;
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (checkCousins(root, root.left.right, root.right.left)) {
            System.out.println("Nodes are cousins of each other");
        }
        else {
            System.out.println("Nodes are not cousins of each other");
        }
    }
}