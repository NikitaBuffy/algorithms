package leetcode.hashtable;

import java.util.*;

/**
 * LeetCode #347
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.topKFrequent1(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    static class Solution {
        // O(N log N)
        public static int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            return map.entrySet()
                    .stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).limit(k).map(Map.Entry::getKey).toList()
                    .stream().mapToInt(Integer::intValue).toArray();
        }

        // O(N)
        public static int[] topKFrequent1(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            List<Integer>[] freqList = new List[nums.length + 1];
            for (int i = 0; i < freqList.length; i++) {
                freqList[i] = new ArrayList<>();
            }

            for (var entry : map.entrySet()) {
                freqList[entry.getValue()].add(entry.getKey());
            }

            List<Integer> result = new ArrayList<>();
            for (int i = freqList.length - 1; i >= 0; i--){
                List<Integer> numList = freqList[i];
                for (Integer num : numList) {
                    if (k <= 0) {
                        return result.stream().mapToInt(v -> v).toArray();
                    }
                    result.add(num);
                    k--;
                }
            }

            return result.stream().mapToInt(v -> v).toArray();
        }
    }
}
