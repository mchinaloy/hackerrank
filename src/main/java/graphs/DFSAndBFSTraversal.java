package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DFSAndBFSTraversal {

    public static boolean hasPathBFS(Node start, Node destination, Queue<Node> queue) {
        Set<Node> visited = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visiting=" + current.val);
            visited.add(current);
            if (current.val == destination.val) {
                return true;
            }
            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static boolean hasPathDFS(Node start, Node destination, Set<Node> visited) {
        System.out.println("Visiting=" + start.val);
        if (start.val == destination.val) {
            return true;
        }
        if (visited.contains(start)) {
            return false;
        }
        for (Node node : start.neighbors) {
            visited.add(start);
            boolean result = hasPathDFS(node, destination, visited);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.addEdge(n2);
        n1.addEdge(n3);

        n2.addEdge(n4);
        n3.addEdge(n5);

        n5.addEdge(n8);

        n4.addEdge(n6);
        n4.addEdge(n7);

        n6.addEdge(n1);

        System.out.println("DFS");
        System.out.println(hasPathDFS(n1, n5, new HashSet<>()));
        System.out.println("BFS");
        System.out.println(hasPathBFS(n1, n5, new LinkedList<>()));

        /*
           2 - 4 - 7
         /     |
        1      6
         \
           3 - 5 - 8
         */
    }

    static class Node {

        public int val;
        public List<Node> neighbors = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public void addEdge(Node node) {
            neighbors.add(node);
        }

    }

}
