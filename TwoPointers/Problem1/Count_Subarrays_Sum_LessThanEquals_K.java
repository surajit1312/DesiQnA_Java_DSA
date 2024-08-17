package TwoPointers.Problem1;

public class Count_Subarrays_Sum_LessThanEquals_K {
    public static void main(String[] args) {
        long n = 6;
        long k = 5;
        long[] nums = { 1, 2, 3, 4, 5, 6 };

        long countBF = getCountBruteForce(nums, n, k);
        System.out.println(countBF);

        long countOptimal = getCountOptimal(nums, n, k);
        System.out.println(countOptimal);
    }

    /**
     * Brute-Force approach
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static long getCountBruteForce(long[] nums, long n, long k) {
        long count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            long sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal approach
     * TC: O(2N) ~ O(N)
     * SC: O(1)
     *
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static long getCountOptimal(long[] nums, long n, long k) {
        long count = 0L;
        long sum = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N) for i and O(N) for j
            sum += nums[j];
            while (sum > k) {
                sum -= nums[i];
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }
}
