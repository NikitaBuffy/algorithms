package leetcode;

/**
 * LeetCode #14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    // O(N * M)
    public static String longestCommonPrefix(String[] strs) {
        String firstWord = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int counter = firstWord.length() - 1;
            while (!strs[i].startsWith(firstWord)) {
                firstWord = firstWord.substring(0, counter);
                counter--;
            }
        }

        return firstWord;
    }
}
