package leetcode;

import java.util.Arrays;

/**
 * LeetCode #189
 */
public class RotateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
            new int[] { 5,6,7,1,2,3,4 },
            Solution.rotate(new int[]{ 1,2,3,4,5,6,7 }, 3))
        );
        System.out.println(Arrays.equals(
                new int[] { 3,99,-1,-100 },
                Solution.rotate(new int[]{ -1,-100,3,99 }, 2))
        );
    }

    static class Solution {
        public static int[] rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            if (k == 0) return nums;

            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);

            return nums;
        }

        static void reverse(int[] arr, int l, int r) {
            while (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
}
