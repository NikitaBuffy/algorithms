package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #217
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(Solution.containsDuplicate(new int[]{ 1, 2, 3, 1 }));
        System.out.println(Solution.containsDuplicate(new int[]{ 1, 2, 3, 4 }));
    }

    static class Solution {
        public static boolean containsDuplicate(int[] nums) {
            if (nums.length < 2) {
                return false;
            }

            Arrays.sort(nums);

            Map<Integer, Integer> hash = new HashMap<>();

            for (int num : nums) {
                hash.put(num, hash.getOrDefault(num, 0) + 1);

                int repeat = hash.get(num);

                if (repeat > 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
