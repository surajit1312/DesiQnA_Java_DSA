package Hashing.Session_0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Max_Min_Frequency_Of_Number {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 4, 3 };

        int[] freqBrute = maxMinFrequencyBrute(nums);
        System.out.println(Arrays.toString(freqBrute));

        int[] freqOptimal = maxMinFrequencyOptimal(nums);
        System.out.println(Arrays.toString(freqOptimal));
    }

    /**
     * Optimal approach
     * 
     * TC: O(N + K) ~ O(N)
     * SC: O(K) ~ O(N)
     * 
     * @param nums
     * @return
     */
    private static int[] maxMinFrequencyOptimal(int[] nums) {
        int n = nums.length;
        int minFreq = n;
        int minElem = 0;
        int maxFreq = 0;
        int maxElem = 0;
        // SC: O(K) - number of unique elements, in worst case K = N
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1); // TC: O(1)
        }
        for (Integer key : hm.keySet()) {
            // TC: O(K) - number of unique elements, in worst case K = N
            int count = hm.get(key);
            if (count > maxFreq) {
                maxFreq = count;
                maxElem = key;
            }
            if (count < minFreq) {
                minFreq = count;
                minElem = key;
            }
        }
        int[] freq = new int[] { maxElem, maxFreq, minElem, minFreq }; // SC: O(4) - Output(ignore)
        return freq;
    }

    /**
     * Brute-Force approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @return
     */
    private static int[] maxMinFrequencyBrute(int[] nums) {
        int n = nums.length;
        int minFreq = n;
        int minElem = 0;
        int maxFreq = 0;
        int maxElem = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int count = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > maxFreq) {
                maxFreq = count;
                maxElem = nums[i];
            }
            if (count < minFreq) {
                minFreq = count;
                minElem = nums[i];
            }
        }
        int[] freq = new int[] { maxElem, maxFreq, minElem, minFreq }; // SC: O(4) - Output(ignore)
        return freq;
    }
}
