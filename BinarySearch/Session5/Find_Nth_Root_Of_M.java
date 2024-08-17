package BinarySearch.Session5;

public class Find_Nth_Root_Of_M {
    public static void main(String[] args) {
        int n = 2;
        int m = 9;
        int root = NthRoot(n, m);
        System.out.println(root);
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int pow = (int) Math.pow(mid, n);
            if (pow == m) {
                return mid;
            } else if (pow < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
