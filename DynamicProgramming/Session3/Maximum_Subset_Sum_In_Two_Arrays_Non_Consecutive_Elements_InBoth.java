package DynamicProgramming.Session3;

public class Maximum_Subset_Sum_In_Two_Arrays_Non_Consecutive_Elements_InBoth {
    public static void main(String[] args) {
        int n = 4; // size of the array
        int[] a = { 1, 5, 3, 21234 };
        int[] b = { -4509, 200, 3, 40 };

        int maxSum = maximumSubsetSumNonConsecutiveInBoth(a, b, n);
        System.out.println(maxSum);
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
    private static int maximumSubsetSumNonConsecutiveInBoth(int[] a, int[] b, int n) {
        // SC: O(N)
        int[] dp = new int[n]; // initializing dp array
        dp[0] = Math.max(Math.max(a[0], 0), Math.max(b[0], 0));
        dp[1] = Math.max(Math.max(Math.max(a[1], 0), Math.max(b[1], 0)), dp[0]);
        // generalize formula for dp[2] - either include 2nd index or exclude
        // dp[2] = Math.max(Math.max(Math.max(a[2], 0), Math.max(b[2], 0)) + dp[0],
        // dp[1]);
        for (int i = 2; i < n; i++) { // TC: O(N)
            dp[i] = Math.max(Math.max(Math.max(a[i], 0),
                    Math.max(b[i], 0)) + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
