package Hashing.Starter;

import java.util.Scanner;

/**
 * Better approach
 * 
 * TC: O(N + Q)
 * SC: O(max) where max = maximum value in nums array
 * 
 * @param args
 */
public class Hashing_02 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N) - taking input TC is not considered
            nums[i] = scn.nextInt();
            max = Math.max(max, nums[i]);
        }
        int[] freq = new int[max + 1]; // SC: O(max + 1)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[nums[i]]++;
        }
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int query = scn.nextInt();
            System.out.print(freq[query] + " ");
        }
        scn.close();
    }
}
