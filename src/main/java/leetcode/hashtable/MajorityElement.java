package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #169
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(Solution.majorityElementOptimized(new int[]{2,2,1,1,1,2,2}));
        System.out.println(Solution.majorityElementOptimized(new int[]{3,2,3}));
    }

    static class Solution {

        // O(N), O(N) space
        public static int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > nums.length / 2){
                    return entry.getKey();
                }
            }

            return -1;
        }

        // O(N), O(1) space
        public static int majorityElementOptimized(int[] nums) {
            int candidate = -1;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }

                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }
}
