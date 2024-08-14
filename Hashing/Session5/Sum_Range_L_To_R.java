package Hashing.Session5;

public class Sum_Range_L_To_R {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int l = 3, r = 7; // Example range [l, r]
        int sumBF = sumRangeBruteForce(nums, l, r);
        System.out.println(sumBF);

        int sumOptimal = sumRangeOptimal(nums, l, r);
        System.out.println(sumOptimal);
    }

    /**
     * Optimal approach
     * TC: O(N + Q), where Q = number of queries to pass l and r
     * SC: O(N)
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int sumRangeOptimal(int[] nums, int l, int r) {
        int n = nums.length;
        int[] prefixsum = new int[n]; // SC: O(N)
        prefixsum[0] = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }
        return prefixsum[r] - prefixsum[l - 1];
    }

    /**
     * Brute-Force approach
     * 
     * TC: O(N) in worst case l = 0, r = N - 1
     * SC: O(1)
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int sumRangeBruteForce(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) { // TC: O(r - l + 1)
            sum += nums[i];
        }
        return sum;
    }
}
