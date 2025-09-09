package leetcode;

import java.util.Stack;

/**
 * LeetCode #1249
 */
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)")); // lee(t(c)o)de
        System.out.println(minRemoveToMakeValid("a)b(c)d")); // ab(c)d
        System.out.println(minRemoveToMakeValid("))((")); // ""
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < result.length(); i++) {
            char charElem = result.charAt(i);

            if (charElem == '(') {
                stack.push(i);
            } else if (charElem == ')' && stack.isEmpty()) {
                result.setCharAt(i, '\0');
            } else if (charElem == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            result.setCharAt(stack.pop(), '\0');
        }

        return result.toString().replace("\0", "");
    }
}
