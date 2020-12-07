package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TraversalSolution {

    static class Node {

        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }

    }

    // Preorder = root -> left -> right / roots first
    // Inorder = left -> root -> right / inherent order
    // Postorder = left -> right -> root / leaves first

    /*
    pre-order (red): F, B, A, D, C, E, G, I, H;
    in-order (yellow): A, B, C, D, E, F, G, H, I;
    post-order (green): A, C, E, D, B, H, I, G, F.

    F == Root
     */

    // A, B, C
    static Node DFSInOrder(Node root) {
        if(root.left != null) {
            DFSInOrder(root.left);
        }

        System.out.print(root.data + " ");

        if(root.right != null) {
            DFSInOrder(root.right);
        }

        return root;
    }

    // B, A, C
    static Node DFSPreOrder(Node root) {
        System.out.print(root.data + " ");

        if(root.left != null) {
            DFSInOrder(root.left);
        }

        if(root.right != null) {
            DFSInOrder(root.right);
        }

        return root;
    }

    // A, C, B
    static Node DFSPostOrder(Node root) {
        if(root.left != null) {
            DFSInOrder(root.left);
        }

        if(root.right != null) {
            DFSInOrder(root.right);
        }
        System.out.print(root.data + " ");

        return root;
    }

    /*
         8
        / \
       6   9
      / \   \
     3  7   10

    */
    // 8 6 9 3 7 10
    static Node BFSOrder(Node root) {
        List<Node> nodesToVisit = new ArrayList<>();
        nodesToVisit.add(root);
        while(!nodesToVisit.isEmpty()) {
            System.out.print(nodesToVisit.get(0).data + " ");
            Node node = nodesToVisit.get(0);
            if(node.left != null) {
                nodesToVisit.add(node.left);
            }
            if(node.right != null) {
                nodesToVisit.add(node.right);
            }
            nodesToVisit.remove(0);
        }
        return root;
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

    /*
     8
    / \
   6   9
  / \   \
  3  7   10
     */

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 8);
        root = insertNode(root, 6);
        root = insertNode(root, 3);
        root = insertNode(root, 7);
        root = insertNode(root, 9);
        root = insertNode(root, 10);

        DFSPreOrder(root);
        System.out.println();
        DFSInOrder(root);
        System.out.println();
        DFSPostOrder(root);
        System.out.println();
        BFSOrder(root);
    }

}
