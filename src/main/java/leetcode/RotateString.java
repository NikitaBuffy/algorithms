package leetcode;

/**
 * LeetCode #796
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(true == Solution.rotateString("abcde", "cdeab"));
        System.out.println(false == Solution.rotateString("abcde", "abced"));
    }

    static class Solution {
        public static boolean rotateString(String s, String goal) {
            return s.length() == goal.length() && (s + s).contains(goal);
        }
    }
}
