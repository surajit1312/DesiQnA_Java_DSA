package Hashing;

import java.util.Scanner;

public class Hashing_01 {
    /**
     * Brute-Force approach
     * 
     * TC: O(Q x N)
     * SC: O(1)
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { // TC: O(N) - taking input TC is not considered
            nums[i] = scn.nextInt();
        }
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int query = scn.nextInt();
            int count = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (nums[j] == query) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
        scn.close();
    }
}
