package DynamicProgramming.Session4;

public class Frog_Jump_I {
    public static void main(String[] args) {
        int n = 4; // size of the array
        int[] heights = { 10, 30, 40, 20 };

        int minCost = minimumJumpsCost(heights, n);
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
    private static int minimumJumpsCost(int[] heights, int n) {
        // SC: O(N)
        int[] dp = new int[n]; // initializing dp array
        dp[0] = 0; // already at height 0, so cost = 0
        dp[1] = Math.abs(heights[1] - heights[0]); // 30 - 10 = 20
        // dp[2] = min(abs(heights[2] - height[1]) + dp[1], heights[2] - heights[0]);
        // dp[3] = min(abs(heights[3] - heights[2]) + dp[2], abs(heights[3] -
        // heights[1]) + dp[1])
        for (int i = 2; i < n; i++) { // TC: O(N)
            int singleStep = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int doubleStep = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            dp[i] = Math.min(singleStep, doubleStep);
        }
        return dp[n - 1];
    }
}
