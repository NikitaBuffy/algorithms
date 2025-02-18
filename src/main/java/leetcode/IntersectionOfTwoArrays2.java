package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #350
 */
public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(
                new int[]{2, 2}, Solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})
        ));
        System.out.println(Arrays.equals(
                new int[]{4, 9}, Solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})
        ));
    }

    static class Solution {
        public static int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> result = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int p1 = 0;
            int p2 = 0;

            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] == nums2[p2]) {
                    result.add(nums1[p1]);
                    p1++;
                    p2++;
                } else if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }

            return result.stream().mapToInt(i -> i).toArray();
        }
    }
}
