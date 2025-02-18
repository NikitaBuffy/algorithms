package leetcode;

import java.util.Arrays;

/**
 * LeetCode #27
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(2 == Solution.removeElement2(new int[]{ 3, 2, 2, 3 }, 3));
        System.out.println(5 == Solution.removeElement2(new int[]{ 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
        System.out.println(0 == Solution.removeElement2(new int[]{}, 10));
        System.out.println(1 == Solution.removeElement2(new int[]{ 2 }, 3));
        System.out.println(0 == Solution.removeElement2(new int[]{ 1 }, 1));
        System.out.println(2 == Solution.removeElement2(new int[]{ 3, 3 }, 5));
    }

    static class Solution {
        /*
         * Not optimized
         */
        public static int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                if (nums[0] != val) {
                    return 1;
                } else {
                    return 0;
                }
            }

            int l = 0, r = nums.length - 1;

            while (l < r) {
                if (nums[l] == val) {
                    if (nums[r] == val) {
                        r--;
                    }
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                } else {
                    l++;
                }
            }

            return (int) Arrays.stream(nums).filter(num -> num != val).count();
        }

        /*
         * Faster, stronger!
         */
        public static int removeElement2(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }
}
