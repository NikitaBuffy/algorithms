package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #22
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
    }

    static class Solution {
        public static List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();

            generate(list, 0, 0, n, "");

            return list;
        }

        private static void generate(List<String> res, int openN, int closeN, int n, String curr) {
            if (curr.length() == 2 * n) {
                res.add(curr);
                return;
            }

            if (openN < n) {
                generate(res, openN + 1, closeN, n,curr + "(");
            }

            if (closeN < openN) {
                generate(res, openN, closeN + 1, n, curr + ")");
            }
        }
    }
}
