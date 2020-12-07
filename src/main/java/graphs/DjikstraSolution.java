package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DjikstraSolution {

    public static class Graph {

        public Set<Vertex> vertices = new HashSet<>();

        public Graph() {
        }

    }

    public static class Vertex {

        public String name;
        public Map<Vertex, Integer> adjacent = new HashMap<>();
        public List<Vertex> shortestPath = new ArrayList<>();
        public Integer distance = Integer.MAX_VALUE;

        public Vertex(String name) {
            this.name = name;
        }

        public void addPath(Vertex adjacent, Integer distance) {
            this.adjacent.put(adjacent, distance);
        }

    }

    private static void shortestPath(Vertex source) {
        Set<Vertex> settled = new HashSet<>();
        Set<Vertex> unsettled = new HashSet<>();

        unsettled.add(source);

        while(!unsettled.isEmpty()) {
            Vertex current = getMinimumVertex(unsettled);
            unsettled.remove(current);
            for(Entry<Vertex, Integer> adjacentPair : current.adjacent.entrySet()) {
                if(!settled.contains(current)) {
                    calculateMinimumDistance(adjacentPair.getKey(), current, adjacentPair.getValue());
                    unsettled.add(adjacentPair.getKey());
                }
            }
            settled.add(current);
        }

    }

    private static void calculateMinimumDistance(Vertex evaluation, Vertex current, Integer edgeWeight) {
        if(current.distance + edgeWeight < evaluation.distance) {
            evaluation.distance = current.distance + edgeWeight;
            List<Vertex> shortestPath = new ArrayList<>(current.shortestPath);
            shortestPath.add(current);
            evaluation.shortestPath = shortestPath;
        }
    }

    private static Vertex getMinimumVertex(Set<Vertex> vertices) {
        Vertex minimum = null;
        for(Vertex v : vertices) {
            if(minimum == null) {
                minimum = v;
            } else if(v.distance < minimum.distance) {
                minimum = v;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");

        vertexA.addPath(vertexB, 10);
        vertexA.addPath(vertexC, 15);
        vertexB.addPath(vertexD, 12);
        vertexB.addPath(vertexF, 15);
        vertexC.addPath(vertexE, 10);
        vertexD.addPath(vertexF, 1);
        vertexD.addPath(vertexE, 2);
        vertexF.addPath(vertexE, 5);

        Graph graph = new Graph();
        graph.vertices.add(vertexA);
        graph.vertices.add(vertexB);
        graph.vertices.add(vertexC);
        graph.vertices.add(vertexD);
        graph.vertices.add(vertexE);
        graph.vertices.add(vertexF);

        shortestPath(vertexA);

        System.out.println(graph);
    }

}
