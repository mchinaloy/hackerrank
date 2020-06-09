package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Dijkstra Shortest Path Implementation
public class ShortestPathSolution {

    public static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node result = null;
        for (Node node : unsettledNodes) {
            if (result == null) {
                result = node;
                continue;
            }
            if (node.distance < result.distance) {
                result = node;
            }
        }
        return result;
    }

    public static void calculateMinimumDistance(Node adjacentNode, int edgeWeight, Node currentNode) {
        if(currentNode.distance + edgeWeight < adjacentNode.distance) {
            adjacentNode.distance = currentNode.distance + edgeWeight;
            LinkedList<Node> shortestPath = new LinkedList<>(currentNode.shortestPath);
            shortestPath.add(currentNode);
            adjacentNode.shortestPath = shortestPath;
        }
    }

    public static Graph shortestPath(Graph graph, Node source) {
        source.distance = 0;

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.adjacentNodes.entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                int edgeWeight = adjacencyPair.getValue();
                if(!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }

        return graph;
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = shortestPath(graph, nodeA);
        System.out.println();
    }

    static class Graph {

        public Set<Node> nodes = new HashSet<>();

        public void addNode(Node node) {
            nodes.add(node);
        }

    }

    static class Node {

        public String name;
        public Integer distance = Integer.MAX_VALUE;
        public List<Node> shortestPath = new LinkedList<>();
        public Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }

    }

}
