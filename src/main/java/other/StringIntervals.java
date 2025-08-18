package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class StringIntervals {
    public static void main(String[] args) {
        System.out.println(generateIntervalsOptimized(new int[]{1,4,5,2,3,9,8,11,0}));
        System.out.println(generateIntervalsOptimized(new int[]{1,4,3,2}));
        System.out.println(generateIntervalsOptimized(new int[]{1,4}));
        System.out.println(generateIntervalsOptimized(new int[]{1}));
    }

    // O(N) - но не гарантирован порядок вывода
    static String generateIntervalsOptimized(int[] nums) {
        StringJoiner joiner = new StringJoiner(",");
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int end = num;
                while (set.contains(end + 1)) {
                    end++;
                }

                if (end != num) {
                    joiner.add(num + "-" + end);
                } else {
                    joiner.add(String.valueOf(num));
                }
            }
        }

        return joiner.toString();
    }

    // O(n log n)
    static String generateIntervals(int[] nums) {
        StringJoiner joiner = new StringJoiner(",");
        Arrays.sort(nums);

        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (r + 1 < nums.length && nums[r + 1] - nums[r] < 2) {
                r++;
            } else {
                if (l != r) {
                    joiner.add(nums[l] + "-" + nums[r]);
                } else {
                    joiner.add(String.valueOf(nums[l]));
                }
                l = ++r;
            }
        }

        return joiner.toString();
    }
}
