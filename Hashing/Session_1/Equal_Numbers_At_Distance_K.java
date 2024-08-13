package Hashing.Session_1;

import java.util.HashMap;
import java.util.Map;

public class Equal_Numbers_At_Distance_K {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 1, 2, 3 };
        int k = 2;

        String containsBF = containsEqualNumbersBruteForce(nums, k) ? "Yes" : "No";
        System.out.println(containsBF);

        String containsOptimal = containsEqualNumbersOptimal(nums, k) ? "Yes" : "No";
        System.out.println(containsOptimal);
    }

    /**
     * Optimal approach
     * 
     * TC: O(N)
     * SC: O(K) ~ O(N)
     * 
     * @param nums
     * @return
     */
    private static boolean containsEqualNumbersOptimal(int[] nums, int k) {
        int n = nums.length;
        // SC: O(K) - number of unique elements, in worst case K = N
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (hm.containsKey(nums[i]) && i - hm.get(nums[i]) <= k) { // TC : O(1)
                return true;
            }
            hm.put(nums[i], i);
        }
        return false;
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
    private static boolean containsEqualNumbersBruteForce(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j <= i + k; j++) { // TC: O(N)
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
