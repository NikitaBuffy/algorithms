package yandexalgo7.week3.E;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x1 = scanner.nextLong();
        long y1 = scanner.nextLong();
        long x2 = scanner.nextLong();
        long c2 = scanner.nextLong();

        long label = x1 ^ y1;
        long y2 = x2 ^ c2;

        System.out.println(label);
        System.out.println(y2);
    }
}