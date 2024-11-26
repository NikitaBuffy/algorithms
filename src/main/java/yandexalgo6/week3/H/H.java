package yandexalgo6.week3.H;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * O(N)
 */
public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week3/H/input.txt"));

        int n = Integer.parseInt(reader.readLine());
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(reader.readLine());
        }

        StackWithSum stackWithSum = new StackWithSum();

        for (String op : operations) {
            char action = op.charAt(0);
            switch (action) {
                case '+':
                    int num = Integer.parseInt(op.substring(1).trim());
                    stackWithSum.push(num);
                    break;
                case '?':
                    int k = Integer.parseInt(op.substring(1).trim());
                    System.out.println(stackWithSum.sumK(k));
                    break;
                case '-':
                    System.out.println(stackWithSum.pop());
                    break;
            }
        }
    }
}

class StackWithSum {
    private final Stack<Integer> stack;
    private final Stack<Long> sumStack;

    public StackWithSum() {
        stack = new Stack<>();
        sumStack = new Stack<>();
        sumStack.push(0L);
    }

    public void push(int x) {
        stack.push(x);
        sumStack.push(sumStack.peek() + x);
    }

    public int pop() {
        sumStack.pop();
        return stack.pop();
    }

    public long sumK(int k) {
        return sumStack.peek() - sumStack.get(sumStack.size() - k - 1);
    }
}