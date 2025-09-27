package Queue;

 class DeleteBinaryTree {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; left = right = null; }
    }

    static class BinaryTree {
        Node root;

        void deleteTree(Node node) {
            if (node == null) return;
            deleteTree(node.left);
            deleteTree(node.right);
            node.left = null;
            node.right = null;
        }

        void deleteTree() {
            deleteTree(root);
        }

        void inorder(Node node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Before delete (inorder): ");
        tree.inorder(tree.root);
        System.out.println();

        tree.deleteTree();

        System.out.print("After delete, root = " + tree.root); 
    }
}
