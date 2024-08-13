package Hashing.Starter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Optimal approach
 * 
 * TC: O(N + Q)
 * SC: O(K) where K = number of unique elements in nums array
 * In worst case K = N ~ O(N)
 * 
 * @param args
 */
public class Hashing_03 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { // TC: O(N) - taking input TC is not considered
            nums[i] = scn.nextInt();
        }
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int query = scn.nextInt();
            System.out.print(hm.getOrDefault(query, 0) + " ");
        }
        scn.close();
    }
}
