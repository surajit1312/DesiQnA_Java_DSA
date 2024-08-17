package TwoPointers.Problem2;

import java.util.HashMap;

public class Count_Subarrays_With_Distinct_Numbers_Count_LessThanEquals_K {
    public static void main(String[] args) {
        long n = 15;
        long k = 4;
        long[] nums = { 1, 2, 3, 5, 8, 8, 8, 8, 2, 1, 1, 1, 1, 1, 1 };

        long countDistinctBF = getCountDistinctBruteForce(nums, n, k);
        System.out.println(countDistinctBF);

        long countDistinctOptimal = getCountDistinctOptimal(nums, n, k);
        System.out.println(countDistinctOptimal);
    }

    /**
     * Brute-Force approach
     * TC: O(N^2)
     * SC: O(N)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static long getCountDistinctBruteForce(long[] nums, long n, long k) {
        long count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
            for (int j = i; j < n; j++) { // TC: O(N)
                hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
                if (hm.size() <= k) {
                    count++;
                }
            }
        }
        return count;
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
    private static long getCountDistinctOptimal(long[] nums, long n, long k) {
        long count = 0;
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>(); // SC: O(N)
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N) for i and O(N) for j
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            int size = hm.size();
            while (size > k) {
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if (hm.get(nums[i]) == 0) {
                    hm.remove(nums[i]);
                }
                size = hm.size();
                i++;
            }
            count += (j - i + 1);
        }
        return count;
    }
}
