package yandexalgo6.week3.H;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * O(N^2)
 */
public class H2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week3/H/input.txt"));

        int n = Integer.parseInt(reader.readLine());
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(reader.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            char action = op.charAt(0);
            switch (action) {
                case '+':
                    int num = Integer.parseInt(op.substring(1).trim());
                    stack.push(num);
                    break;
                case '?':
                    int k = Integer.parseInt(op.substring(1).trim());
                    sum(stack, k);
                    break;
                case '-':
                    System.out.println(stack.pop());
                    break;
            }
        }
    }

    private static void sum(Stack<Integer> stack, int k) {
        long sum = 0;
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < k; i++) {
            int value = stack.pop();
            sum += value;
            temp.push(value);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        System.out.println(sum);
    }
}