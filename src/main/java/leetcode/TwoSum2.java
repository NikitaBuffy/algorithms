package leetcode;

import java.util.Arrays;

/**
 * LeetCode #167
 */
public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
                new int[]{1, 2}, Solution.twoSum2(new int[]{2, 7, 11, 15}, 9)
        ));
        System.out.println(Arrays.equals(
                new int[]{1, 3}, Solution.twoSum2(new int[]{2, 3, 4}, 6)
        ));
        System.out.println(Arrays.equals(
                new int[]{1, 2}, Solution.twoSum2(new int[]{-1, 0}, -1)
        ));
    }

    static class Solution {
        public static int[] twoSum2(int[] numbers, int target) {
            int l = 0;
            int r = numbers.length - 1;

            while (l < r) {
                int sum = numbers[l] + numbers[r];
                if (sum == target) {
                    return new int[]{ l + 1, r + 1 };
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }

            return new int[0];
        }
    }
}
