package BinarySearch.Session1;

import java.util.Arrays;

public class Find_First_Last_Position_Element_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 7, 8, 8, 8, 8, 9, 10 };
        int k = 8;
        int[] indices = searchRange(nums, k);
        System.out.println(Arrays.toString(indices));
    }

    /**
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        return new int[] { searchLeft(nums, target), searchRight(nums, target) };
    }

    public static int searchLeft(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                // nums[mid] == k
                minIndex = mid;
                high = mid - 1;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    public static int searchRight(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int maxIndex = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                // nums[mid] == k
                maxIndex = mid;
                low = mid + 1;
            }
        }
        return maxIndex == Integer.MIN_VALUE ? -1 : maxIndex;
    }
}
