package TwoPointers.Problem3;

import java.util.Arrays;

public class Count_Pairs_With_Difference_LessThanEquals_K {
    public static void main(String[] args) {
        long n = 3;
        long k = 2;
        long[] nums = { 1, 3, 2 };

        long countPairsBF = getCountPairsBruteForce(nums, n, k);
        System.out.println(countPairsBF);

        long countPairsOptimal = getCountPairsOptimal(nums, n, k);
        System.out.println(countPairsOptimal);
    }

    /**
     * Brute-Force approach
     * TC: O(Nlog(N) + N^2) ~ O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static long getCountPairsBruteForce(long[] nums, long n, long k) {
        long count = 0;
        Arrays.sort(nums); // TC: O(Nlog(N))
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i; j < n; j++) { // TC: O(N)
                long diff = nums[j] - nums[i];
                if (diff <= k) {
                    count++;
                }
            }
        }
        /*
         * subtracting n as we considered i and j from
         * same index so pairs would have single elements too
         */
        return count - n;
    }

    /**
     * Optimal approach
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     *
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static long getCountPairsOptimal(long[] nums, long n, long k) {
        long count = 0;
        Arrays.sort(nums); // 1, 2, 3, 4
        for (int i = 0, j = 0; j < n; j++) {
            long diff = nums[j] - nums[i];
            while (diff > k) {
                i++;
                diff = nums[j] - nums[i];
            }
            count += (j - i + 1);
        }
        /*
         * subtracting n as we considered i and j from
         * same index so pairs would have single elements too
         */
        return count - n;
    }
}
