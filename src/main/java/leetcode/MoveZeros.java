package leetcode;

import java.util.Arrays;

/**
 * LeetCode #283
 */
public class MoveZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
                new int[]{1, 3, 12, 0, 0}, Solution.moveZeroes(new int[]{0, 1, 0, 3, 12})
        ));
        System.out.println(Arrays.equals(
                new int[]{2, 3, 9, 3, 1, 0, 0}, Solution.moveZeroes(new int[]{2, 3, 0, 9, 3, 0, 1})
        ));
        System.out.println(Arrays.equals(
                new int[]{0}, Solution.moveZeroes(new int[]{0})
        ));
    }

    static class Solution {
        public static int[] moveZeroes(int[] nums) {
            int r = 0, l = 0;

            while (r < nums.length) {
                if (nums[l] == 0) {
                    if (nums[r] == 0) {
                        r++;
                    } else {
                        nums[l] = nums[r];
                        nums[r] = 0;
                    }
                } else {
                    l++;
                    r++;
                }
            }

            return nums;
        }
    }
}
