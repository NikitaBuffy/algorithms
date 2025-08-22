package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #2404
 */
public class MostFrequentEvenElement {
    public static void main(String[] args) {
        System.out.println(Solution.mostFrequentEven(new int[]{0,1,2,2,4,4,1}));
        System.out.println(Solution.mostFrequentEven(new int[]{4,4,4,9,2,4}));
        System.out.println(Solution.mostFrequentEven(new int[]{29,47,21,41,13,37,25,7}));
        System.out.println(Solution.mostFrequentEven(new int[]{8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
    }

    static class Solution {
        public static int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
            }

            int maxValue = Integer.MIN_VALUE;
            int minKey = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (value > maxValue){
                    maxValue = entry.getValue();
                    minKey = key;
                } else if (value == maxValue && key < minKey) {
                    minKey = key;
                }
            }

            return minKey;
        }
    }
}
