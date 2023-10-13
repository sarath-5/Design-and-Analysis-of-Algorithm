import java.util.*;

class knapsackdpp {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Making and initializing dp and selected arrays
        int[][] dp = new int[n + 1][W + 1];
        boolean[][] selected = new boolean[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = 1; w < W + 1; w++) {

                if (wt[i - 1] <= w) {

                    // Finding the maximum value and updating selected array
                    int newValue = dp[i - 1][w - wt[i - 1]] + val[i - 1];
                    if (newValue > dp[i - 1][w]) {
                        dp[i][w] = newValue;
                        selected[i][w] = true;
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Printing the weights taken
        int w = W;
        List<Integer> weightsTaken = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            if (selected[i][w]) {
                weightsTaken.add(wt[i - 1]);
                w -= wt[i - 1];
            }
        }
        System.out.println("Weights taken: " + weightsTaken);

        // Returning the maximum value of knapsack
        return dp[n][W];
    }

    // Driver code
    public static void main(String[] args)
    {
        int profit[] = { 11, 21, 31,33,43,53,55,65 };
        int weight[] = { 10, 20, 30 ,40,50,60,70,80};
        int W = 110;
        int n = profit.length;
        System.out.println("Profit values: " + Arrays.toString(profit));
        System.out.println("Weight values: " + Arrays.toString(weight));
        System.out.println("Knapsack capacity: " + W);
        System.out.print(knapSack(W, weight, profit, n));
    }
}
