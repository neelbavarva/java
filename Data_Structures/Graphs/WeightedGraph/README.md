#### Methods Implemented in this Graph

| Method Name | Functionality |
| ------------- | ------------- |
| addNode | To add a Node |
| addEdge | To add an Edge between 2 Nodes |
| dfs | Depth First Search Traversal of the Graph |
| bfs | Breadth First Search Traversal of the Graph |
| getShortestDistance | Get the shortest Distance between 2 Nodes using Dijkstra's Algorithm |
| getShortestPath | Get the shortest Path between 2 Nodes using Dijkstra's Algorithm |
| getMinimumSpanningTree | Get the Minumum Spanning Tree (Using Prime's and Krushkal's Algorithm) |
| printAllShortestDistance | Get shortest distance from the source node to all other nodes using Bellman-Ford's Algorithm |

#### DIJKSTRA's Algorithm

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/dijkstra.png" />

```
Graph graph = new Graph();

graph.addNode(1);
graph.addNode(2);
graph.addNode(3);
graph.addNode(4);
graph.addNode(5);

graph.addEdge(1, 2, 3);
graph.addEdge(1, 3, 4);
graph.addEdge(1, 4, 2);
graph.addEdge(2, 4, 6);
graph.addEdge(2, 5, 1);
graph.addEdge(3, 4, 1);
graph.addEdge(4, 5, 5);
```

#### PRIME's ALgorithm

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/prime-algo.png" />

```
Graph graph = new Graph();

graph.addNode(1);
graph.addNode(2);
graph.addNode(3);
graph.addNode(4);

graph.addEdge(1, 2, 3);
graph.addEdge(1, 3, 1);
graph.addEdge(2, 4, 4);
graph.addEdge(3, 4, 5);
graph.addEdge(2, 3, 2);
```
