package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #228
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(Solution.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(Solution.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    static class Solution {
        public static List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            if (nums.length == 0) return result;

            int left = 0;

            for (int right = 1; right < nums.length; right++) {
                if (nums[right] - nums[right - 1] != 1) {
                    result.add(formatRange(nums[left], nums[right - 1]));
                    left = right;
                }
            }

            result.add(formatRange(nums[left], nums[nums.length - 1]));

            return result;
        }

        private static String formatRange(int start, int end) {
            return start == end ? String.valueOf(start) : start + "->" + end;
        }
    }
}
