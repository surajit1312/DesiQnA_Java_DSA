package Hashing.Session7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Largest_Smallest_SubArrays_Sum_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, -1, 6 };
        int k = 9;

        int[] largestSizeIndices = largestSubArrayWithSumK(nums, k);
        System.out.println(Arrays.toString(largestSizeIndices));
        int[] smallestSizeIndices = smallestSubArrayWithSumK(nums, k);
        System.out.println(Arrays.toString(smallestSizeIndices));

        int[] largestSizeIndicesOptimal = largestSubArrayWithSumKOptimal(nums, k);
        System.out.println(Arrays.toString(largestSizeIndicesOptimal));
        int[] smallestSizeIndicesOptimal = smallestSubArrayWithSumKOptimal(nums, k);
        System.out.println(Arrays.toString(smallestSizeIndicesOptimal));
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
    private static int[] largestSubArrayWithSumKOptimal(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, 0);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] indices = { -1, -1 };
        for (int j = 1; j < n; j++) { // TC: O(N)
            sum += nums[j];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                int i = hm.get(diff);
                if (max < j - i + 1) {
                    max = j - i + 1;
                    indices[0] = i + 1;
                    indices[1] = j;
                }
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, j + 1);
            }
        }
        return indices;
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
    private static int[] smallestSubArrayWithSumKOptimal(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, 0);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int[] indices = { -1, -1 };
        for (int j = 1; j < n; j++) { // TC: O(N)
            sum += nums[j];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                int i = hm.get(diff);
                if (min > j - i + 1) {
                    min = j - i + 1;
                    indices[0] = i;
                    indices[1] = j;
                }
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, j + 1);
            }
        }
        return indices;
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
    private static int[] largestSubArrayWithSumK(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] indices = { -1, -1 };
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum == k) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        indices[0] = i;
                        indices[1] = j;
                    }
                }
            }
        }
        return indices;
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
    private static int[] smallestSubArrayWithSumK(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int[] indices = { -1, -1 };
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum == k) {
                    if (min > j - i + 1) {
                        min = j - i + 1;
                        indices[0] = i;
                        indices[1] = j;
                    }
                }
            }
        }
        return indices;
    }
}
