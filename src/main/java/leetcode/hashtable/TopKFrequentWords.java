package leetcode.hashtable;

import java.util.*;

/**
 * LeetCode #692
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(Solution.topKFrequent2(new String[]{"i","love","leetcode","i","love","coding"}, 2));
        System.out.println(Solution.topKFrequent2(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }

    static class Solution {
        // O(N log N)
        public static List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new TreeMap<>();

            for (int i = 0; i < words.length; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }

            return map.entrySet().stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .limit(k)
                    .map(Map.Entry::getKey)
                    .toList();
        }

        // O(N log K)
        public static List<String> topKFrequent2(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                    (a, b) -> a.getValue().equals(b.getValue()) ?
                            b.getKey().compareTo(a.getKey()) :
                            a.getValue() - b.getValue()
            );

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                heap.offer(entry);
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            List<String> result = new ArrayList<>();
            while (!heap.isEmpty()) {
                result.add(heap.poll().getKey());
            }
            Collections.reverse(result);

            return result;
        }
    }
}
