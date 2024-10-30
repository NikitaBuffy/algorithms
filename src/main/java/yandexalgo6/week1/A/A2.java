package yandexalgo6.week1.A;

import java.util.Scanner;

/**
 * Оптимизированное решение
 */
public class A2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String result = "";

        if (y > y2) result += "N";
        if (y < y1) result += "S";
        if (x < x1) result += "W";
        if (x > x2) result += "E";

        System.out.println(result);
    }
}
