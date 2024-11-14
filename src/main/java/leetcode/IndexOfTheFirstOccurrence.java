package leetcode;

/**
 * LeetCode #28
 */
public class IndexOfTheFirstOccurrence {

    public static void main(String[] args) {
        int case1 = Solution.needleIndex("sadbutsad", "sad");
        int case2 = Solution.needleIndex("leetcode", "leeto");
        System.out.println(case1);
        System.out.println(case2);
    }

    public static class Solution {
        public static int needleIndex(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
}
