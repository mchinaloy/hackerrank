package trees;

public class BinaryTreeHeightSolution {

    static class Node {

        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }

    }

    static int height(Node root) {
        if(root == null) {
            return -1;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        if(leftH > rightH) {
            return leftH + 1;
        } else {
            return rightH + 1;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 5);
        insertNode(root, 10);
        insertNode(root, 8);
        insertNode(root, 3);
        insertNode(root, 11);
        System.out.println("");
        System.out.println(height(root));
        /*
            5
            / \
            3  10
               /
              8
         */
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

}
