package Hashing.Session6;

import java.util.HashMap;
import java.util.Map;

public class Count_SubArrays_Sum_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 5;
        int countBF = countSubArraysBruteForce(nums, k);
        System.out.println(countBF);

        int countOptimal = countSubArraysOptimal(nums, k);
        System.out.println(countOptimal);
    }

    /**
     * Optimal approach
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int countSubArraysOptimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        // this will help to find a sub-array with single element = k
        hm.put(0, 1);
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += nums[i];
            int target = sum - k;
            if (hm.containsKey(target)) {
                count += hm.get(target);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
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
    private static int countSubArraysBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
