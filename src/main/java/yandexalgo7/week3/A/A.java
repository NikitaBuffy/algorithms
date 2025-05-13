package yandexalgo7.week3.A;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextLong();
        int count = 0;

        while (x != 0) {
            count += (int) (x & 1);
            x >>>= 1;
        }

        System.out.println(count);
    }
}