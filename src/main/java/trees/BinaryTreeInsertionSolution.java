package trees;

public class BinaryTreeInsertionSolution {

    static class Node {

        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }

    }

    static Node insertNode(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(data < root.data) {
            if(root.left == null) {
                root.left = new Node(data);
            } else {
                insertNode(root.left, data);
            }
        } else {
            if(root.right == null) {
                root.right = new Node(data);
            } else {
                insertNode(root.right, data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 5);
        insertNode(root, 10);
        insertNode(root, 8);
        insertNode(root, 3);
        insertNode(root, 11);
        System.out.println("");
        /*
        5
        / \
        3  10
           /
          8
         */
    }

}
