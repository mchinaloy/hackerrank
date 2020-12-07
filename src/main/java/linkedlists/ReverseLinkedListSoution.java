package linkedlists;

public class ReverseLinkedListSoution {

    static class Node {

        int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    public static Node reverseList(Node root) {
        // 1 -> 2 -> 3 -> 4
        // 4 -> 3 -> 2 -> 1

        Node next;
        Node prev = null;
        Node curr = root;

        while(curr != null) {
            next = curr.next; // Store next for later
            curr.next = prev; // Switch pointers (reverse)

            prev = curr; // Prev is now current
            curr = next; // Curr is now next
        }

        return prev;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node child1 = new Node(2);
        root.next = child1;
        Node child2 = new Node(3);
        child1.next = child2;
        child2.next = new Node(4);

        Node tmp = reverseList(root);

        while(tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

}
