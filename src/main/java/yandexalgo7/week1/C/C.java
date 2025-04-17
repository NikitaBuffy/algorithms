package yandexalgo7.week1.C;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = 31;
        int M = scanner.nextInt();
        long[] a = new long[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextLong();
        }

        for (int i = 1; i < N; i++) {
            if (a[i] < a[i - 1] || a[i] < a[i - 1] * 2) {
                a[i] = a[i - 1] * 2;
            }
        }

        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (M >= a[i]) {
                M -= (int) a[i];
                result += (1 << i);
            }
        }

        if (M > 0) {
            result++;
        }

        System.out.println(result);
    }
}