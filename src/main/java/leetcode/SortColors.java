package leetcode;

import java.util.Arrays;

/**
 * LeetCode #75
 */
public class SortColors {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.sortColors(new int[]{2, 0, 2, 1, 1, 0})));
    }

    static class Solution {
        public static int[] sortColors(int[] nums) {
            int n = nums.length;
            int r = n - 1;
            int l = 0;

            for (int i = 0; i <= r; i++) {
                if (nums[i] == 0) {
                    swap(nums, l, i);
                    l++;
                } else if (nums[i] == 2) {
                    swap(nums, i, r);
                    r--;
                    i--;
                }
            }

            return nums;
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
