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

    public static Node deleteNode(Node head, int location) {
        if(location == 0) {
            head = head.next;
            return head;
        }

        int indexCounter = 0;
        Node currentNode = head;

        while(currentNode != null) {
            if(indexCounter + 1 == location) {
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
            indexCounter++;
        }

        return head;
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

        System.out.println("Insertion");
        Node currentNode = insertNode(node1, 4, 1);
        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }

        System.out.println("Deletion");
        deleteNode(node1, 2);

        Node currentNode2 = node1;
        while(currentNode2 != null) {
            System.out.println(currentNode2.data);
            currentNode2 = currentNode2.next;
        }

    }

}
