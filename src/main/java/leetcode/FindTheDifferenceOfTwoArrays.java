package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * LeetCode #2215
 */
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Solution.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(Solution.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    static class Solution {

        // O(n + m)
        public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            result.add(new ArrayList<>());

            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            for (int i : nums1) {
                set1.add(i);
            }

            for (int i : nums2) {
                set2.add(i);
            }

            for (Integer i : set1) {
                if (!set2.contains(i)) {
                    result.get(0).add(i);
                }
            }

            for (Integer i : set2) {
                if (!set1.contains(i)) {
                    result.get(1).add(i);
                }
            }

            return result;
        }
    }
}
