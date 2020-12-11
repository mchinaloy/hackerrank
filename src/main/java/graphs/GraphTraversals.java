package graphs;

public class GraphTraversals {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public static void dfsInOrder(Node root) {
        if(root.left != null) {
            dfsInOrder(root.left);
        }

        System.out.println(root.value);

        if(root.right != null) {
            dfsInOrder(root.right);
        }
    }

    public static void dfsPreOrder(Node root) {
        System.out.println(root.value);

        if(root.left != null) {
            dfsPreOrder(root.left);
        }

        if(root.right != null) {
            dfsPreOrder(root.right);
        }
    }

    public static void dfsPostOrder(Node root) {
        if(root.left != null) {
            dfsPostOrder(root.left);
        }

        if(root.right != null) {
            dfsPostOrder(root.right);
        }

        System.out.println(root.value);
    }

    public static void main(String[] args) {

        /*

             1
           /   \
          2     3
         / \   /
        4   5 6
         */

        Node root = new Node(1);
        Node l1 = new Node(2);
        Node l2 = new Node(3);
        Node l3 = new Node(4);
        Node l4 = new Node(5);
        Node l5 = new Node(6);

        root.left = l1;
        root.right = l2;
        l1.left = l3;
        l1.right = l4;
        l2.left = l5;

        // Inorder - left, root, right = 4, 2, 5, 1, 6, 3
        System.out.println("InOrder");
        dfsInOrder(root);

        // PreOrder - root, left, right = 1, 2, 4, 5, 3, 6
        System.out.println("PreOrder");
        dfsPreOrder(root);

        // PostOrder - left, right, root = 4, 5, 2, 6, 3, 1
        System.out.println("PostOrder");
        dfsPostOrder(root);
    }

}
