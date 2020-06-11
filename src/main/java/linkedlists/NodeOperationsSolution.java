package linkedlists;

public class NodeOperationsSolution {

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

    public static Node reverse(Node head) {
        // Write your code here
        /* Input:
            N = 6
            list = [1, 2, 8, 9]
            list = [1, 2, 8, 9, 12, 16]
            list = [2, 18, 24, 3, 5, 7, 9, 6, 12]
        */
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.next != null && currentNode.next.data % 2 == 0) {
                Node firstNodeToSwap = currentNode.next;
                Node secondNodeToSwap = currentNode.next.next;

                firstNodeToSwap.next = secondNodeToSwap.next;
                secondNodeToSwap.next = firstNodeToSwap;

                currentNode.next = secondNodeToSwap;
                currentNode.next.next = firstNodeToSwap;
                currentNode = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
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

        SinglyLinkedList singlyLinkedListReverse = new SinglyLinkedList();
        Node node1Reverse = new Node(2);
        Node node2Reverse = new Node(18);
        Node node3Reverse = new Node(24);
        Node node4Reverse = new Node(3);
        Node node5Reverse = new Node(5);
        Node node6Reverse = new Node(7);
        Node node7Reverse = new Node(9);
        Node node8Reverse = new Node(6);
        Node node9Reverse = new Node(12);

        // [2, 18, 24, 3, 5, 7, 9, 6, 12]
        // [24, 18, 2, 3, 5, 7, 9, 12, 6]

        node1Reverse.next = node2Reverse;
        node2Reverse.next = node3Reverse;
        node3Reverse.next = node4Reverse;
        node4Reverse.next = node5Reverse;
        node5Reverse.next = node6Reverse;
        node6Reverse.next = node7Reverse;
        node7Reverse.next = node8Reverse;
        node8Reverse.next = node9Reverse;

        singlyLinkedListReverse.head = node1Reverse;

        reverse(node1Reverse);

        System.out.println("Reverse");

        Node currentNode3 = node1Reverse;
        while(currentNode3 != null) {
            System.out.println(currentNode3.data);
            currentNode3 = currentNode3.next;
        }

    }

}
