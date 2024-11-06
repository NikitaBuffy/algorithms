package yandexalgo6.week2.A;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] prefix = new int[n + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + a[i - 1];
            System.out.print(i + 1 >= prefix.length ? prefix[i]: prefix[i] + " ");
        }
    }
}