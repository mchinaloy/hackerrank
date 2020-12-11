package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class KStreamSolution {

    private static Node root;
    private static final int target = 1;

    private static int findKthLargest(Node node, AtomicInteger counter) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }
        int right = findKthLargest(node.right, counter);
        if(right != Integer.MAX_VALUE) {
            return right;
        }
        if(counter.incrementAndGet() == target) {
            return node.val;
        }
        return findKthLargest(node.left, counter);
    }

    private static int add(int val) {
        add(root, val);
        return findKthLargest(root, new AtomicInteger(0));
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 2, 7};
        for (Integer num : numbers) {
            root = add(root, num);
        }
        System.out.println(add(6));
        System.out.println(add(8));
        System.out.println(add(4));
        System.out.println(add(10));
    }

    public static Node add(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
