package Hashing.Session8;

import java.util.HashMap;
import java.util.Map;

public class Count_Largest_Smallest_SubArrays_Sum_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 2, 3, 5 };
        int k = 5;

        int countLargest = countLargestSubArraysWithSumK(nums, k);
        System.out.println(countLargest);
        int countSmallest = countSmallestSubArraysWithSumK(nums, k);
        System.out.println(countSmallest);

        int countLargestOptimal = countLargestSubArraysWithSumKOptimal(nums, k);
        System.out.println(countLargestOptimal);
        int countSmallestOptimal = countSmallestSubArraysWithSumKOptimal(nums, k);
        System.out.println(countSmallestOptimal);
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
    private static int countLargestSubArraysWithSumKOptimal(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 0);
        int count = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                int i = hm.get(diff);
                if (max < j - i + 1) {
                    max = j - i + 1;
                    count = 1;
                } else if (count == j - i + 1) {
                    count++;
                }
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, j + 1);
            }
        }
        return count;
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
    private static int countSmallestSubArraysWithSumKOptimal(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 0);
        int count = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                int i = hm.get(diff);
                if (min > j - i + 1) {
                    min = j - i + 1;
                    count = 1;
                } else if (count == j - i + 1) {
                    count++;
                }
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, j + 1);
            }
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
    private static int countLargestSubArraysWithSumK(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum == k) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        count = 1;
                    } else if (max == j - i + 1) {
                        count++;
                    }
                }
            }
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
    private static int countSmallestSubArraysWithSumK(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum == k) {
                    if (min > j - i + 1) {
                        min = j - i + 1;
                        count = 1;
                    } else if (min == j - i + 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
