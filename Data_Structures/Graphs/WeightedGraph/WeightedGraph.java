package Data_Structures.Graphs.WeightedGraph;

import java.util.*;

public class WeightedGraph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }

    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException();
        }

        Node toNode = nodes.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException();
        }

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var targets = node.getEdges();
            if (!targets.isEmpty()) {
                System.out.println(node + " is connected to " + targets);
            }
        }
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values()) {
            if (!visited.contains(node)) {
                if (hasCycle(node, null, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for (var edge : node.getEdges()) {
            if (edge.to == parent) {
                continue;
            }

            if (visited.contains(edge.to)) {
                return true;
            }

            if (hasCycle(edge.to, node, visited)) {
                return true;
            }

        }

        return false;
    }

    // DIJKSTRA'S Algorithm START

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

    }

    public int getShortestDistance(String from, String to) {

        var fromNode = nodes.get(from);
        Map<Node, Integer> distances = new HashMap<>();

        for (var node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.replace(nodes.get(from), 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to)) {
                    continue;
                }

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return distances.get(nodes.get(to));
    }

    private class Path {
        private List<String> nodes = new ArrayList<>();

        public void add(String node) {
            nodes.add(node);
        }

        @Override
        public String toString() {
            return nodes.toString();
        }
    }

    public Path getShortestPath(String from, String to) {

        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        Map<Node, Integer> distances = new HashMap<>();

        for (var node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.remove(nodes.get(from), 0);

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to)) {
                    continue;
                }

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);

        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();

        while (!stack.isEmpty()) {
            path.add(stack.pop().label);
        }

        return path;
    }

    // DIJKSTRA'S Algorithm END

    // PRIME's Algorithm

    public WeightedGraph getMinimumSpanningTree() {
        var tree = new WeightedGraph();

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label)) {
                continue;
            }

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for (var edge : nextNode.getEdges()) {
                if (!tree.containsNode(edge.to.label)) {
                    edges.add(edge);
                }
            }
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }
}
