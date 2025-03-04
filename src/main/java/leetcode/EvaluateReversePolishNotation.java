package leetcode;

import java.util.Stack;

/**
 * LeetCode #150
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(Solution.evalRPN(new String[] {"2","1","+","3","*"}));
    }

    static class Solution {
        public static int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String tk : tokens) {
                switch (tk) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        int top = stack.pop();
                        int below = stack.pop();
                        stack.push(below - top);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int t = stack.pop();
                        int b = stack.pop();
                        stack.push(b / t);
                        break;
                    default:
                        stack.push(Integer.parseInt(tk));
                        break;
                }
            }

            return stack.pop();
        }
    }
}
