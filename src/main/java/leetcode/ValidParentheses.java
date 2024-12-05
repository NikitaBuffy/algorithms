package leetcode;

import java.util.Stack;

/**
 * LeetCode #20
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(Solution.isValid("()"));
        System.out.println(Solution.isValid("()[]{}"));
        System.out.println(Solution.isValid("(]"));
        System.out.println(Solution.isValid("([])"));
    }

    public static class Solution {
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == '}' && top != '{') ||
                            (c == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}