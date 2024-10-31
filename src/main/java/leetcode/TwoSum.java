package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode #1
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
                new int[]{0, 1},
                Solution.twoSum(new int[]{2, 7, 11, 15}, 9)
        ));
        System.out.println(Arrays.equals(
                new int[]{1, 2},
                Solution.twoSum(new int[]{3, 2, 4}, 6)
        ));
    }

    static class Solution {
        public static int[] twoSum(int[] nums, int target) {
            int[][] arr = new int[nums.length][2];

            for (int i = 0; i < nums.length; i++) {
                arr[i][0] = nums[i];
                arr[i][1] = i;
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            int left = 0, right = arr.length - 1;

            while (left < right) {
                if (arr[left][0] + arr[right][0] == target) {
                    return new int[]{arr[left][1], arr[right][1]};
                }
                if (arr[left][0] + arr[right][0] < target) {
                    left += 1;
                } else {
                    right -=1;
                }
            }

            return new int[0];
        }
    }
}
