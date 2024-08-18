package DynamicProgramming.Session2;

public class Maximum_Subset_Sum_In_Array_Non_Adjacent_Elements {
    public static void main(String[] args) {
        int n = 5; // size of the array
        int[] nums = { 1, -100, 2, 4, 5 };

        int maxSum = maximumSubsetSumNonAdjacent(nums, n);
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
    private static int maximumSubsetSumNonAdjacent(int[] nums, int n) {
        // SC: O(N)
        int[] dp = new int[n + 1]; // initializing dp array
        dp[0] = Math.max(nums[0], 0); // 0 coz we can take sub-array {} of size 0
        dp[1] = Math.max(nums[1], Math.max(nums[0], 0));
        /**
         * condition 1: dp[2] = if we include 3rd element, then we cannot use 2nd
         * element
         * i.e. dp[2] = nums[2] + dp[0]
         * condition 2: take best if 3rd elememt is not included, i.e. best till 2nd
         * element
         * i.e. dp[2] = dp[1]
         * 
         * finally dp[2] = Math.max(nums[2] + dp[0], dp[1]);
         */
        for (int i = 2; i < n; i++) { // TC: O(N)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
