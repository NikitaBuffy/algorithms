package yandexalgo7.week3.D;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int max = n;
        int length = Integer.toBinaryString(n).length();

        for (int i = 0; i < length - 1; i++) {
            n = ((n >> 1) | ((n & 1) << (length - 1)));
            max = Math.max(max, n);
        }

        System.out.println(max);
    }
}