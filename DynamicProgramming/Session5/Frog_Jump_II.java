package DynamicProgramming.Session5;

public class Frog_Jump_II {
    public static void main(String[] args) {
        int n = 10; // size of the array
        int k = 4;
        int[] heights = { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };

        int minCost = minimumJumpsCost(heights, n, k);
        System.out.println(minCost);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int minimumJumpsCost(int[] heights, int n, int k) {
        // SC: O(N)
        int[] dp = new int[n]; // initializing dp array
        dp[0] = 0; // already at height 0, so cost = 0
        dp[1] = Math.abs(heights[1] - heights[0]);
        // dp[2] = min(abs(heights[2] - height[1]) + dp[1], heights[2] - heights[0]);
        // dp[3] = min(abs(heights[3] - heights[2]) + dp[2], abs(heights[3] -
        // heights[1]) + dp[1], height[3] - heights[0] + dp[0])
        for (int i = 2; i < n; i++) { // TC: O(N)
            int cost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    cost = Math.min(cost, Math.abs(heights[i] - heights[i - j]) + dp[i - j]);
                }
            }
            dp[i] = cost;
        }
        return dp[n - 1];
    }
}
