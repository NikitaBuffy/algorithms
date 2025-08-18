package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #46
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(Solution.permute(new int[]{1,2,3}));
    }

    static class Solution {
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(new ArrayList<>(), result, nums, new boolean[nums.length]);
            return result;
        }

        private static void backtrack(List<Integer> current, List<List<Integer>> result, int[] nums, boolean[] used) {
            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                current.add(nums[i]);

                backtrack(current, result, nums, used);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
