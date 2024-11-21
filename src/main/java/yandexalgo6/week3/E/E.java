package yandexalgo6.week3.E;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();

        StringBuilder currNumb = new StringBuilder();
        List<String> expList = new ArrayList<>();
        int bracesBalance = 0;
        char prevChar = ' ';

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isAlphabetic(ch)) {
                System.out.println("WRONG");
                return;
            }

            if (Character.isDigit(ch)) {
                currNumb.append(ch);
                prevChar = ch;
            } else {
                if (ch == ' ' && !currNumb.isEmpty()) {
                    if (i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1))) {
                        System.out.println("WRONG");
                        return;
                    }
                }
                if (!currNumb.isEmpty()) {
                    expList.add(currNumb.toString());
                    currNumb.setLength(0);
                }
                if (isOperator(ch)) {
                    if (prevChar == '(') {
                        System.out.println("WRONG");
                        return;
                    }
                    if (isOperator(prevChar)) {
                        System.out.println("WRONG");
                        return;
                    }
                }
                if (ch != ' ') {
                    if (ch == '(') {
                        bracesBalance++;
                    }
                    if (ch == ')') {
                        if (isOperator(prevChar)) {
                            System.out.println("WRONG");
                            return;
                        }
                        bracesBalance--;
                    }
                    if (bracesBalance < 0) {
                        System.out.println("WRONG");
                        return;
                    }
                    expList.add(String.valueOf(ch));
                    prevChar = ch;
                }
            }
        }
        if (!currNumb.isEmpty()) {
            expList.add(currNumb.toString());
        }
        if (bracesBalance != 0) {
            System.out.println("WRONG");
            return;
        }
        if (!expList.isEmpty() && isOperator(expList.get(expList.size() - 1).charAt(0))) {
            System.out.println("WRONG");
            return;
        }

        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();

        for (String s : expList) {
            switch (s) {
                case "+":
                case "-":
                    while (!stack.isEmpty() && (stack.peek().equals("+")
                            || stack.peek().equals("-")
                            || stack.peek().equals("*"))) {
                        postfix.add(stack.pop());
                    }
                    stack.push(s);
                    break;
                case "(":
                    stack.push(s);
                    break;
                case ")":
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                    break;
                case "*":
                    while (!stack.isEmpty() && stack.peek().equals("*")) {
                        postfix.add(stack.pop());
                    }
                    stack.push(s);
                    break;
                default:
                    postfix.add(s);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        Stack<Integer> postfixStack = new Stack<>();

        for (String tk : postfix) {
            switch (tk) {
                case "+":
                    postfixStack.push(postfixStack.pop() + postfixStack.pop());
                    break;
                case "-":
                    int top = postfixStack.pop();
                    int below = postfixStack.pop();
                    postfixStack.push(below - top);
                    break;
                case "*":
                    postfixStack.push(postfixStack.pop() * postfixStack.pop());
                    break;
                default:
                    postfixStack.push(Integer.parseInt(tk));
                    break;
            }
        }

        System.out.println(postfixStack.pop());
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }
}