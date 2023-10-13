import java.util.Arrays;

public class travelling {
    private int[][] distance;
    private int numberOfCities;
    private int[][] memo;

    public travelling(int[][] distance) {
        this.distance = distance;
        this.numberOfCities = distance.length;
        this.memo = new int[numberOfCities][(int) Math.pow(2, numberOfCities)];
    }

    public int tsp(int startCity, int visitedCities) {
        if (visitedCities == (1 << numberOfCities) - 1) {
            return distance[startCity][0];
        }
        if (memo[startCity][visitedCities] != 0) {
            return memo[startCity][visitedCities];
        }
        int minCost = Integer.MAX_VALUE;
        for (int nextCity = 0; nextCity < numberOfCities; nextCity++) {
            if ((visitedCities & (1 << nextCity)) == 0) {
                int currentCost = distance[startCity][nextCity] + tsp(nextCity, visitedCities | (1 << nextCity));
                minCost = Math.min(minCost, currentCost);
            }
        }
        memo[startCity][visitedCities] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[][] distance = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        travelling tsp = new travelling(distance);
        int startCity = 0;
        int visitedCities = 1 << startCity;
        int minCost = tsp.tsp(startCity, visitedCities);
        System.out.println("Minimum cost: " + minCost);
    }
}
