package Hashing.Session3;

import java.util.HashMap;
import java.util.Map;

public class Count_Pair_Difference_K {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 2, 4, 1 };
        int k = 3;
        int countBF = getPairsCountBruteForce(nums, k);
        System.out.println(countBF);

        int countOptimal = getPairsCountOptimal(nums, k);
        System.out.println(countOptimal);
    }

    /**
     * Optimal approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int getPairsCountOptimal(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int target = k + nums[i];
            if (hm.containsKey(target)) {
                count += hm.get(target);
            }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
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
    private static int getPairsCountBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (nums[i] - nums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
