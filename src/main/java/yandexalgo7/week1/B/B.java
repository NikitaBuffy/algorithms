package yandexalgo7.week1.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int k = 0; k < a.length; k++) {
                a[k] = scanner.nextInt();
            }

            List<Integer> segments = new ArrayList<>();
            int start = 0;

            while (start < a.length) {
                int min = a[start];
                int end = start;

                while (end < a.length) {
                    min = Math.min(min, a[end]);
                    int length = end - start + 1;

                    if (min < length) {
                        break;
                    }

                    end++;
                }

                segments.add(end - start);
                start = end;
            }

            result.add(segments);
        }

        for (List<Integer> integers : result) {
            StringJoiner joiner = new StringJoiner(" ");
            System.out.println(integers.size());
            integers.forEach(i -> {
                joiner.add(i.toString());
            });
            System.out.println(joiner);
        }
    }
}