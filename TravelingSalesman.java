import java.util.*;

public class TSP {

    // Define the number of cities and their distances
    private static int[][] distances = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };
    private static int numCities = distances.length;

    public static void main(String[] args) {

        // Initialize the memoization table
        int[][] memo = new int[numCities][(1 << numCities)];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Find the shortest path and its length
        int shortestPathLength = tsp(0, 1, memo);
        System.out.println("Shortest path length: " + shortestPathLength);

        // Print the path taken
        List<Integer> path = getPathTaken(memo);
        System.out.println("Path taken: " + path);
    }

    // Solve the TSP using dynamic programming
    private static int tsp(int city, int visited, int[][] memo) {
        if (visited == ((1 << numCities) - 1)) {
            return distances[city][0];
        }
        if (memo[city][visited] != -1) {
            return memo[city][visited];
        }
        int shortestPathLength = Integer.MAX_VALUE;
        for (int nextCity = 0; nextCity < numCities; nextCity++) {
            if ((visited & (1 << nextCity)) == 0) {
                int pathLength = distances[city][nextCity] + tsp(nextCity, (visited | (1 << nextCity)), memo);
                shortestPathLength = Math.min(shortestPathLength, pathLength);
            }
        }
        memo[city][visited] = shortestPathLength;
        return shortestPathLength;
    }

    // Get the path taken by the salesman
    private static List<Integer> getPathTaken(int[][] memo) {
        int city = 0;
        int visited = 1;
        List<Integer> path = new ArrayList<>();
        path.add(city);
        while (visited != ((1 << numCities) - 1)) {
            for (int nextCity = 0; nextCity < numCities; nextCity++) {
                if ((visited & (1 << nextCity)) == 0) {
                    int pathLength = distances[city][nextCity] + memo[nextCity][visited | (1 << nextCity)];
                    if (memo[city][visited] == pathLength) {
                        city = nextCity;
                        visited |= (1 << nextCity);
                        path.add(city);
                        break;
                    }
                }
            }
        }
        return path;
    }
}
