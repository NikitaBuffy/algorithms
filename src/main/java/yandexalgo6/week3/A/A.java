package yandexalgo6.week3.A;

import java.util.Scanner;
import java.util.Stack;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("no");
                    return;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    System.out.println("no");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "yes" : "no");
    }
}