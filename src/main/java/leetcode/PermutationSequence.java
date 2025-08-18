package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(Solution.getPermutation(3, 3));
    }

    static class Solution {
        public static String getPermutation(int n, int k) {
            List<Integer> numbers = new ArrayList<>();
            int fact = 1; // (n-1)!
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
                if (i < n) fact *= i;
            }

            k--; // чтобы индексация была с 0
            StringBuilder sb = new StringBuilder();

            for (int i = n - 1; i >= 0; i--) {
                int index = k / fact;
                sb.append(numbers.get(index));
                numbers.remove(index);

                if (i > 0) {
                    k %= fact;
                    fact /= i;
                }
            }

            return sb.toString();
        }
    }
}
