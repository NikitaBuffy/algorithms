package yandexalgo6.week3.F;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week3/F/input.txt"));

        int n = Integer.parseInt(reader.readLine());
        String w = reader.readLine();
        String s = Optional.ofNullable(reader.readLine()).orElse("");

        Map<Character, Integer> priority = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            priority.put(w.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder(s);

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isPair(stack.peek(), c)) {
                    stack.pop();
                }
            }
        }

        while (stack.size() != n - res.length()) {
            if (!stack.isEmpty()) {
                char open = stack.peek();
                char close = getCloseBracket(open);

                if (priority.get(close) < priority.get('(') && priority.get(close) < priority.get('[')) {
                    res.append(close);
                    stack.pop();
                } else {
                    char nextOpen = priority.get('(') < priority.get('[') ? '(' : '[';
                    res.append(nextOpen);
                    stack.push(nextOpen);
                }
            } else {
                if (priority.get('(') < priority.get('[')) {
                    res.append('(');
                    stack.push('(');
                } else {
                    res.append('[');
                    stack.push('[');
                }
            }
        }

        while (!stack.isEmpty()) {
            char openBracket = stack.pop();
            res.append(getCloseBracket(openBracket));
        }

        System.out.println(res);
    }

    private static char getCloseBracket(char openBracket) {
        return openBracket == '(' ? ')' : ']';
    }

    private static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']');
    }
}