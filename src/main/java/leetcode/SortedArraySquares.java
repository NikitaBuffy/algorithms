package leetcode;

import java.util.Arrays;

/**
 * LeetCode #977
 */
public class SortedArraySquares {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
                new int[]{0, 1, 9, 16, 100}, Solution.sortedSquares(new int[]{-4, -1, 0, 3, 10})
        ));
        System.out.println(Arrays.equals(
                new int[]{4, 9, 9, 49, 121}, Solution.sortedSquares(new int[]{-7, -3, 2, 3, 11})
        ));
    }

    static class Solution {
        public static int[] sortedSquares(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            int[] result = new int[nums.length];

            while (l <= r) {
                int numL = (int) Math.pow(nums[l], 2);
                int numR = (int) Math.pow(nums[r], 2);

                if (numR > numL) {
                    result[r - l] = numR;
                    r--;
                } else {
                    result[r - l] = numL;
                    l++;
                }
            }

            return result;
        }
    }
}
