package yandexalgo6.week3.C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week3/C/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());
        int k = Integer.parseInt(initialInput.nextToken());

        int[] a = new int[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayInput.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && a[deque.peekLast()] >= a[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = a[deque.peekFirst()];
            }
        }

        Arrays.stream(res).forEach(System.out::println);

        reader.close();
    }
}