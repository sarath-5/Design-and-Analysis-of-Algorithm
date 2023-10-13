import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                         {4, 0, 8, 0, 0, 0, 0, 11, 0},
                         {0, 8, 0, 7, 0, 4, 0, 0, 2},
                         {0, 0, 7, 0, 9, 14, 0, 0, 0},
                         {0, 0, 0, 9, 0, 10, 0, 0, 0},
                         {0, 0, 4, 14, 10, 0, 2, 0, 0},
                         {0, 0, 0, 0, 0, 2, 0, 1, 6},
                         {8, 11, 0, 0, 0, 0, 1, 0, 7},
                         {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        int start = 0;
        dijkstra(graph, start);
    }

    public static void dijkstra(int[][] graph, int start) {
        int numVertices = graph[0].length;
        int[] distance = new int[numVertices]; // Distance from start to vertex i
        boolean[] visited = new boolean[numVertices]; // Whether vertex i has been visited or not
        for (int i = 0; i < numVertices; i++) {
            distance[i] = Integer.MAX_VALUE; // Set all distances to "infinity"
            visited[i] = false; // No vertices have been visited yet
        }
        distance[start] = 0; // Distance from start to itself is 0

        for (int i = 0; i < numVertices - 1; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            for (int j = 0; j < numVertices; j++) {
                if (graph[minVertex][j] != 0 && !visited[j]) {
                    int newDistance = distance[minVertex] + graph[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }

        // Print the distances from start to all other vertices
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Distance from " + start + " to " + i + " is " + distance[i]);
        }
    }

    public static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}
