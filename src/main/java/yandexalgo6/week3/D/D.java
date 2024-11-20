package yandexalgo6.week3.D;

import java.util.Scanner;
import java.util.Stack;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String postfix = scanner.nextLine().trim();

        Stack<Integer> stack = new Stack<>();

        for (String tk : postfix.split(" ")) {
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
                default:
                    stack.push(Integer.parseInt(tk));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}