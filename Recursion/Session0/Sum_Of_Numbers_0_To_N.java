package Recursion.Session0;

public class Sum_Of_Numbers_0_To_N {
    public static void main(String[] args) {
        int n = 5; // Replace 5 with the desired value of N
        int result = sumNumbersRecursive(n);
        System.out.println("The sum of numbers from 0 to " + n + " is: " + result);
    }

    private static int sumNumbersRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNumbersRecursive(n - 1);
    }
}
