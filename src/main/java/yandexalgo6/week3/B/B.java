package yandexalgo6.week3.B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week3/B/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());

        int[] a = new int[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayInput.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        String result = Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);

        reader.close();
    }
}