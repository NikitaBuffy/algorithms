package yandexalgo6.week2.E;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week2/E/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());

        int[] a = new int[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayInput.nextToken());
        }

        int[] res = new int[n];
        PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int num : a) {
            right.offer(num);
        }

        for (int i = 0; i < n; i++) {
            while (right.size() > left.size() + 1) {
                left.offer(right.poll());
            }
            while (left.size() > right.size()) {
                right.offer(left.poll());
            }

            int median;
            if (right.size() > left.size()) {
                median = right.peek();
            } else {
                median = left.peek();
            }

            res[i] = median;

            if (median == right.peek()) {
                right.poll();
            } else {
                left.poll();
            }
        }

        System.out.println(Arrays.stream(res).boxed().toList().
                stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}