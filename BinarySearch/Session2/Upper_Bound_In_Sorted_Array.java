package BinarySearch.Session2;

public class Upper_Bound_In_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6, 6, 7, 7, 9 };
        int target = 6;
        int upperBoundIndex = upperBound(nums, target);
        System.out.println(upperBoundIndex);
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int upperBound(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= k) {
                low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid;
            }
        }
        if (low > n - 1) {
            return -1;
        }
        return low;
    }
}
