package yandexalgo6.week3.G;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int b = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long total = 0;
        long queue = 0;

        for (int i = 0; i < n; i++) {
            queue += a[i];
            total += queue;
            queue = Math.max(0, queue - b);
        }

        total += queue;

        System.out.println(total);
    }
}