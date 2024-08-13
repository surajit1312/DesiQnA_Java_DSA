package Hashing.Session2;

import java.util.HashMap;
import java.util.Map;

public class Count_Pair_Sum_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 5;

        int countBF = countPairSumBruteForce(nums, k);
        System.out.println(countBF);

        int countOptimal = countPairSumOptimal(nums, k);
        System.out.println(countOptimal);

        // String containsOptimal = containsEqualNumbersOptimal(nums, k) ? "Yes" : "No";
        // System.out.println(containsOptimal);
    }

    /**
     * Optimal approach
     * 
     * TC: O(N)
     * SC: O(K) ~ O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int countPairSumOptimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        // SC: O(K) - number of unique elements, in worst case K = N
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = k - nums[i];
            if (hm.containsKey(diff)) { // TC : O(1)
                count++;
            }
            hm.put(nums[i], i);
        }
        return count;
    }

    /**
     * Brute-Force approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int countPairSumBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (nums[i] + nums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
