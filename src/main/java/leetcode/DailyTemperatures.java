package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode #739
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{5, 7, 8, 4, 2, 10, 7})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.add(new int[]{i, temperatures[i]});
            } else {
                while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                    int[] a = stack.pop();
                    result[a[0]] = i  - a[0];
                }

                stack.add(new int[]{i, temperatures[i]});
            }
        }

        return result;
    }
}
