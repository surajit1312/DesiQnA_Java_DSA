package Hashing.Session9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean checkAnagramBrute = isAnagramBrute(s, t);
        System.out.println(checkAnagramBrute);

        boolean checkAnagramBetter = isAnagramBetter(s, t);
        System.out.println(checkAnagramBetter);

        boolean checkAnagramOptimal = isAnagramOptimal(s, t);
        System.out.println(checkAnagramOptimal);
    }

    /**
     * Brute-Force approach
     * 
     * TC: O(3N + 2Nlog(N)) ~ O(Nlog(N))
     * SC: O(2N) ~ O(N)
     * 
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sch = s.toCharArray(); // TC: O(N), SC: O(N)
        char[] tch = t.toCharArray(); // TC: O(N), SC: O(N)
        Arrays.sort(sch); // TC: O(Nlog(N))
        Arrays.sort(tch); // TC: O(Nlog(N))
        for (int i = 0; i < sch.length; i++) { // TC: O(N)
            if (sch[i] != tch[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Better approach - Using HashMap
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     * 
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) { // TC: O(N)
            if (hm.containsKey(t.charAt(i))) {
                int count = hm.get(t.charAt(i));
                if (count == 1) {
                    hm.remove(t.charAt(i));
                } else {
                    hm.put(t.charAt(i), count - 1);
                }
            }
        }
        return hm.isEmpty();
    }

    /**
     * Optimal approach - Using Constant Space
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(26) ~ O(1)
     */
    public static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26]; // SC: O(26) ~ O(1)
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) { // TC: O(N)
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
