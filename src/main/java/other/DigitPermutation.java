package other;

import java.util.*;

public class DigitPermutation {
    public static void main(String[] args) {
        System.out.println(digitPermutation(new int[]{1230, 99, 23001, 123, 111, 300021, 101010, 9000009, 9}));
        System.out.println(digitPermutation(new int[]{11, 22}));
    }

    static List<List<Integer>> digitPermutation(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int[] count = new int[9];
            int num = nums[i];
            while (num != 0) {
                int digit = num % 10;
                if (digit != 0) {
                    count[digit - 1]++;
                }
                num /= 10;
            }

            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(nums[i]);
        }

        return new ArrayList<>(map.values());
    }
}
