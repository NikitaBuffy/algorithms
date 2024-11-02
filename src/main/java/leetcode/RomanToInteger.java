package leetcode;

import java.util.Map;

/**
 * LeetCode #13
 */
public class RomanToInteger {
    public static void main(String[] args) {
        int case1 = Solution.romanToInt("III");
        int case2 = Solution.romanToInt("LVIII");
        int case3 = Solution.romanToInt("MCMXCIV");
        System.out.println(case1);
        System.out.println(case2);
        System.out.println(case3);
    }

    static class Solution {
        public static int romanToInt(String s) {
            Map<String, Integer> romanIntMap = Map.of(
                    "I", 1,
                    "V", 5,
                    "X", 10,
                    "L", 50,
                    "C", 100,
                    "D", 500,
                    "M", 1000);

            String[] letters = s.split("");
            int result = 0;

            for (int i = 0; i < letters.length; i++) {
                int current = romanIntMap.get(letters[i]);
                if (i + 1 < letters.length) {
                    int next = romanIntMap.get(letters[i + 1]);
                    if (current < next) {
                        current = -current;
                    }
                }
                result += current;
            }

            return result;
        }
    }
}