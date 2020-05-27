package linkedlists;

public class NodeInsertionSolution {

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

    public static Node insertNode(Node head, int data, int location) {
        int indexCounter = 0;
        Node currentNode = head;

        if(location == 0) {
            Node nodeToInsert = new Node(data);
            nodeToInsert.next = head;
            return nodeToInsert;
        }

        // O(N)
        while(currentNode != null) {
            if(indexCounter + 1 == location) {
                Node nodeToInsert = new Node(data);
                nodeToInsert.next = currentNode.next;
                currentNode.next = nodeToInsert;
            }
            indexCounter++;
            currentNode = currentNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        singlyLinkedList.head = node1;

        Node currentNode = insertNode(node1, 4, 1);
        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

}
