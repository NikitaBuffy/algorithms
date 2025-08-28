package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #438
 */
public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(Solution.findAnagrams2("cbaebabacd", "abc"));
        System.out.println(Solution.findAnagrams2("abab", "ab"));
    }

    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> pMap = new HashMap<>();
            Map<Character, Integer> sMap = new HashMap<>();

            if (s.length() < p.length()) return result;

            for (char value : p.toCharArray()) {
                pMap.put(value, pMap.getOrDefault(value, 0) + 1);
            }

            int l = 0, r = 0;

            while (r < s.length()) {
                char c = s.charAt(r);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);

                if (r - l == p.length() - 1) {
                    if (sMap.equals(pMap)) {
                        result.add(l);
                    }

                    char lChar = s.charAt(l);
                    sMap.put(lChar, sMap.get(lChar) - 1);
                    if (sMap.get(lChar) == 0) {
                        sMap.remove(lChar);
                    }

                    l++;
                }

                r++;
            }

            return result;
        }

        // O(N) time & O(min(m,k)) memory
        public static List<Integer> findAnagrams2(String s, String t) {
            List<Integer> res = new ArrayList<>();
            if (t.length() > s.length()) {
                return res;
            }

            // Словарь разницы символов между текущим окном и t
            Map<Character, Integer> diff = new HashMap<>();
            for (char ch : t.toCharArray()) {
                diff.put(ch, diff.getOrDefault(ch, 0) + 1);
            }

            int l = 0;
            int r = 0;

            // Заполняем начальное окно длины len(t)
            while (r < t.length()) {
                char current = s.charAt(r);
                diff.put(current, diff.getOrDefault(current, 0) - 1);
                if (diff.get(current) == 0) {
                    diff.remove(current);
                }
                r++;
            }

            if (diff.isEmpty()) {
                res.add(0);
            }

            // Двигаем окно по строке s
            while (r < s.length()) {
                // Убираем символ слева
                char leftChar = s.charAt(l);
                diff.put(leftChar, diff.getOrDefault(leftChar, 0) + 1);
                if (diff.get(leftChar) == 0) {
                    diff.remove(leftChar);
                }
                l++;

                // Добавляем символ справа
                char rightChar = s.charAt(r);
                diff.put(rightChar, diff.getOrDefault(rightChar, 0) - 1);
                if (diff.get(rightChar) == 0) {
                    diff.remove(rightChar);
                }
                r++;

                // Если все символы совпали — фиксируем позицию
                if (diff.isEmpty()) {
                    res.add(l);
                }
            }
            return res;
        }
    }
}
