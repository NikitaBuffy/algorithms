package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
                new int[]{0, 1},
                Solution.twoSumHashTable(new int[]{2, 7, 11, 15}, 9)
        ));
        System.out.println(Arrays.equals(
                new int[]{1, 2},
                Solution.twoSumHashTable(new int[]{3, 2, 4}, 6)
        ));
    }

    static class Solution {

        // O(n log n)
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

        // O(n)
        public static int[] twoSumHashTable(int[] nums, int target) {
            Map<Integer, Integer> table = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int needed = target - nums[i];

                Integer get = table.get(needed);
                if (get != null) {
                    return new int[]{get, i};
                }

                table.put(nums[i], i);
            }

            return new int[0];
        }
    }
}
