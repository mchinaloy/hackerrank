package linkedlists;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
public class CycleDetectionSolution {

    static class Node {

        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    static class SinglyLinkedList {

        public Node head;

        public SinglyLinkedList() {
        }

    }

    static boolean hasCycle(Node head) {
        Set<Node> seenNodes = new HashSet<>();
        Node currentNode = head;

        // O(N) time complexity
        // O(2N) -> O(N) space complexity
        while(currentNode != null) {
            if(seenNodes.contains(currentNode)) {
                return true;
            } else {
                seenNodes.add(currentNode);
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        singlyLinkedList.head = node1;

        System.out.println(hasCycle(node1));
    }

}
