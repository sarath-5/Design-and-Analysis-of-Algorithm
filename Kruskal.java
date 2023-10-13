import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

class Graph {
    int vertices;
    ArrayList<Edge> edges = new ArrayList<>();

    Graph(int vertices) {
        this.vertices = vertices;
    }

    void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge();
        edge.source = source;
        edge.destination = destination;
        edge.weight = weight;
        edges.add(edge);
    }

    int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    void kruskal() {
        ArrayList<Edge> result = new ArrayList<>();
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        Collections.sort(edges);

        int i = 0;
        int e = 0;
        int cost = 0;

        while (e < vertices - 1) {
            Edge edge = edges.get(i);
            i++;

            int x = find(parent, edge.source);
            int y = find(parent, edge.destination);

            if (x != y) {
                result.add(edge);
                cost += edge.weight;
                e++;
                union(parent, rank, x, y);
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : result) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }

        System.out.println("Minimum Cost: " + cost);
    }
}

public class Kruskal {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        graph.kruskal();
    }
}
