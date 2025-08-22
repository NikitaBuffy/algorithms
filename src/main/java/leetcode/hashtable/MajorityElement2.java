package leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #229
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        System.out.println(Solution.majorityElement(new int[]{1, 2}));
        System.out.println(Solution.majorityElement(new int[]{3, 2, 3}));
    }

    static class Solution {

        // O(N), O(1) space
        public static List<Integer> majorityElement(int[] nums) {
            Integer cand1 = null, cand2 = null;
            int count1 = 0, count2 = 0;

            for (int num : nums) {
                if (cand1 != null && num == cand1) {
                    count1++;
                } else if (cand2 != null && num == cand2) {
                    count2++;
                } else if (count1 == 0) {
                    cand1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    cand2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (cand1 != null && num == cand1) count1++;
                else if (cand2 != null && num == cand2) count2++;
            }

            List<Integer> result = new ArrayList<>();
            int threshold = nums.length / 3;
            if (count1 > threshold) result.add(cand1);
            if (count2 > threshold) result.add(cand2);

            return result;
        }
    }
}