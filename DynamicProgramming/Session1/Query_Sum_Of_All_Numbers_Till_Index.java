package DynamicProgramming.Session1;

import java.util.Arrays;

public class Query_Sum_Of_All_Numbers_Till_Index {
    public static void main(String[] args) {
        int n = 5; // size of the array
        int[] nums = { 6, 7, 3, 2, 2 };
        int q = 4; // number of queries
        int[] queries = { 0, 3, 4, 2 }; // query array

        int[] sumNumsBF = getNumbersSumTillIndexBrute(nums, queries, n, q);
        System.out.println(Arrays.toString(sumNumsBF));

        int[] sumNumsOptimal = getNumbersSumTillIndexOptimal(nums, queries, n, q);
        System.out.println(Arrays.toString(sumNumsOptimal));
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(Q x N)
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int[] getNumbersSumTillIndexBrute(int[] nums, int[] queries, int n, int q) {
        int[] sums = new int[q];
        for (int i = 0; i < q; i++) { // TC: O(Q)
            sums[i] = 0;
            for (int j = 0; j <= queries[i]; j++) { // TC: O(N)
                sums[i] += nums[j];
            }
        }
        return sums;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(Q + N)
     * SC: O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int[] getNumbersSumTillIndexOptimal(int[] nums, int[] queries, int n, int q) {
        int[] sums = new int[q];
        // using dp pre-calculate sum's for all indices
        int[] dp = new int[n]; // initializing dp array
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            dp[i] = dp[i - 1] + nums[i]; // recurrence formula
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            sums[i] = dp[queries[i]];
        }
        return sums;
    }
}
