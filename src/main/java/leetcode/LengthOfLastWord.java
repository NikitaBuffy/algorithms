package leetcode;

/**
 * LeetCode #58
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        int case1 = Solution.lengthOfLastWord("Hello World");
        int case2 = Solution.lengthOfLastWord("   fly me   to   the moon  ");
        int case3 = Solution.lengthOfLastWord("luffy is still joyboy");
        System.out.println(case1);
        System.out.println(case2);
        System.out.println(case3);
    }

    public static class Solution {
        public static int lengthOfLastWord(String s) {
            s = s.trim();
            String[] words = s.split(" ");
            return words[words.length - 1].length();
        }
    }
}
