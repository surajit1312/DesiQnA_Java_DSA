package Hashing.Session4;

import java.util.HashMap;
import java.util.Map;

public class Count_Pair_Absolute_Difference_K {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 5, 9, 2, 12, 3 };
        int k = 2;
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
            int target1 = nums[i] - k;
            int target2 = nums[i] + k;
            count += hm.getOrDefault(target1, 0);
            if (k != 0) {
                count += hm.getOrDefault(target2, 0);
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
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
