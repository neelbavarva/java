import java.io.*;
import java.util.*;

public class Graph {

    Scanner sc = new Scanner(System.in);

    private class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private int maxNode = 0;
    private int totalEdges = 0;
    private List<Integer> nodes = new ArrayList<>();
    private List<Edge> edgeList = new ArrayList<>();
    private Map<Integer, List<Edge>> adj = new HashMap<>();

    public void addNode(int data) {
        if (nodes.contains(data)) {
            return;
        }
        nodes.add(data);
        maxNode = Math.max(maxNode, data);
        adj.putIfAbsent(data, new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        if (!(nodes.contains(from) && nodes.contains(to))) {
            return;
        }

        totalEdges++;

        edgeList.add(new Edge(from, to, weight));

        adj.get(from).add(new Edge(from, to, weight));
        adj.get(to).add(new Edge(to, from, weight));
    }

    public void print() {
        for (int i = 0; i < nodes.size(); i++) {
            List<Edge> edges = adj.get(nodes.get(i));

            for (int j = 0; j < edges.size(); j++) {
                Edge current = edges.get(j);
                System.out.println(current.from + " is connected to " + current.to + " with weight " + current.weight);
            }
        }
    }

    public void printEdges() {
        for (int i = 0; i < edgeList.size(); i++) {
            System.out.println(edgeList.get(i).from + " is connected to " + edgeList.get(i).to + " with weight "
                    + edgeList.get(i).weight);
        }
    }

    public void dfs(int root) {
        if (!nodes.contains(root)) {
            return;
        }

        dfs(root, new HashSet<>());
    }

    private void dfs(int root, Set<Integer> visited) {
        System.out.print(root + " ");
        visited.add(root);

        List<Edge> edges = adj.get(root);

        for (int i = 0; i < edges.size(); i++) {
            if (!visited.contains(edges.get(i).to)) {
                dfs(edges.get(i).to, visited);
            }
        }
    }

    public void bfs(int root) {
        if (!nodes.contains(root)) {
            return;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int current = queue.remove();

            if (visited.contains(current)) {
                continue;
            }

            System.out.print(current + " ");
            visited.add(current);

            List<Edge> edges = adj.get(current);

            for (int i = 0; i < edges.size(); i++) {

                Edge next = edges.get(i);
                if (!visited.contains(next.to)) {
                    queue.add(next.to);
                }
            }
        }
    }

    public boolean hasCycle() {
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < nodes.size(); i++) {
            if (hasCycle(nodes.get(i), -1, visiting, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(int node, int parent, Set<Integer> visiting, Set<Integer> visited) {

        visiting.add(node);

        List<Edge> edges = adj.get(node);

        for (int i = 0; i < edges.size(); i++) {
            if (visited.contains(edges.get(i).to) || edges.get(i).to == parent) {
                continue;
            }

            if (visiting.contains(edges.get(i).to)) {
                return true;
            }

            if (hasCycle(edges.get(i).to, node, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }

    private class NodeEntry {
        int node;
        int weight;

        private NodeEntry(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Dijkstra's Algorithm
    public int getShortestDistance(int from, int to) {

        Map<Integer, Integer> distances = new HashMap<>();

        for (int i = 0; i < nodes.size(); i++) {
            distances.putIfAbsent(nodes.get(i), Integer.MAX_VALUE);
        }

        distances.put(from, 0);

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        queue.add(new NodeEntry(from, 0));

        while (!queue.isEmpty()) {
            NodeEntry current = queue.remove();
            visited.add(current.node);

            List<Edge> edges = adj.get(current.node);

            for (int i = 0; i < edges.size(); i++) {

                if (visited.contains(edges.get(i).to)) {
                    continue;
                }

                int newDistance = distances.get(current.node) + edges.get(i).weight;

                if (newDistance < distances.get(edges.get(i).to)) {
                    distances.replace(edges.get(i).to, newDistance);
                    queue.add(new NodeEntry(edges.get(i).to, newDistance));
                }
            }
        }

        return distances.get(to);
    }

    private class Path {
        int distance;
        int previous;

        private Path(int distance, int previous) {
            this.distance = distance;
            this.previous = previous;
        }
    }

    // Dijkstra's Algorithm
    public void getShortestPath(int from, int to) {

        Map<Integer, Path> distances = new HashMap<>();

        for (int i = 0; i < nodes.size(); i++) {
            distances.putIfAbsent(nodes.get(i), new Path(Integer.MAX_VALUE, nodes.get(i)));
        }

        distances.put(from, new Path(0, Integer.MIN_VALUE));

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        queue.add(new NodeEntry(from, 0));

        while (!queue.isEmpty()) {
            NodeEntry current = queue.remove();
            visited.add(current.node);

            List<Edge> edges = adj.get(current.node);

            for (int i = 0; i < edges.size(); i++) {

                if (visited.contains(edges.get(i).to)) {
                    continue;
                }

                int newDistance = distances.get(current.node).distance + edges.get(i).weight;

                if (newDistance < distances.get(edges.get(i).to).distance) {
                    distances.replace(edges.get(i).to, new Path(newDistance, current.node));
                    queue.add(new NodeEntry(edges.get(i).to, newDistance));
                }
            }
        }

        printPath(to, distances);
    }

    private void printPath(int node, Map<Integer, Path> distances) {
        if (node == Integer.MIN_VALUE) {
            return;
        }
        printPath(distances.get(node).previous, distances);
        System.out.print(node + " ");
    }

    public Graph getMinimumSpanningTree() {
        System.out.print("Calculate Using Prime's / Krushkal's Algorithm ? [P/K] ");
        String input = sc.nextLine();

        if (input.toUpperCase().equals("P")) {
            return primsAlgorithm();
        } else if (input.toUpperCase().equals("K")) {
            return krushkalsAlgorithm();
        } else {
            throw new IllegalArgumentException("Press P to for Prim's Algorithm OR Press K for Krushkal's Algorithm");
        }
    }

    // Prim's Algorithm
    private Graph primsAlgorithm() {
        Graph tree = new Graph();

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        queue.addAll(adj.get(nodes.get(0)));

        while (!queue.isEmpty() && tree.nodes.size() <= nodes.size()) {

            Edge minEdge = queue.remove();
            int nextNode = minEdge.to;

            if (tree.nodes.contains(nextNode)) {
                continue;
            }

            tree.addNode(nextNode);

            tree.addEdge(minEdge.from, minEdge.to, minEdge.weight);

            List<Edge> edges = adj.get(nextNode);

            for (int i = 0; i < edges.size(); i++) {
                if (!tree.nodes.contains(edges.get(i).to)) {
                    queue.add(edges.get(i));
                }
            }
        }

        return tree;
    }

    private int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private void union(int parent[], int x, int y) {
        parent[x] = y;
    }

    // Krushkal's Algorithm
    private Graph krushkalsAlgorithm() {
        Graph tree = new Graph();
        int parent[] = new int[maxNode + 1];

        Arrays.fill(parent, -1);

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        for (int i = 0; i < edgeList.size(); i++) {
            queue.add(edgeList.get(i));
        }

        for (int i = 0; i < nodes.size(); i++) {
            tree.addNode(nodes.get(i));
        }

        int e = 0;

        while (!queue.isEmpty() && e < nodes.size() - 1) {

            Edge current = queue.poll();

            int x = find(parent, current.from);
            int y = find(parent, current.to);

            if (x == y) {
                continue;
            }

            e++;
            union(parent, current.from, current.to);
            tree.addEdge(current.from, current.to, current.weight);
        }

        return tree;
    }

    // Bellman-Ford's Algorithm
    public void printAllShortestDistance(int source) {
        System.out.println("Bellman-Ford Algorithm");
        System.out.println("Source to all other Nodes, in -ve weighted Graph");

        Map<Integer, Integer> distances = new HashMap<>();

        for (int i = 0; i < nodes.size(); i++) {
            distances.putIfAbsent(nodes.get(i), Integer.MAX_VALUE);
        }

        distances.replace(source, 0);

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < edgeList.size(); j++) {
                int newDistance = distances.get(edgeList.get(j).from) + edgeList.get(j).weight;
                if (distances.get(edgeList.get(j).from) != Integer.MAX_VALUE
                        && newDistance < distances.get(edgeList.get(j).to)) {
                    distances.replace(edgeList.get(j).to, newDistance);
                }
            }
        }

        for (int i = 0; i < edgeList.size(); i++) {
            int newDistance = distances.get(edgeList.get(i).from) + edgeList.get(i).weight;

            if (distances.get(edgeList.get(i).from) != Integer.MAX_VALUE
                    && newDistance < distances.get(edgeList.get(i).to)) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        for (var edge : distances.entrySet()) {
            System.out.println(edge.getKey() + "  " + edge.getValue());
        }

    }

}
