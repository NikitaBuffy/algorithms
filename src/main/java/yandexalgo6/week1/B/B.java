package yandexalgo6.week1.B;

import java.util.Scanner;

/**
 * Не оптимизированное решение.
 * Итоговый вариант в классе B2.
 * Класс для прогонов тестов - BTest.
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blueShirt = scanner.nextInt();
        int redShirt = scanner.nextInt();
        int blueSocks = scanner.nextInt();
        int redSocks = scanner.nextInt();

        int M, N;
        int tempM = 0, tempN = 0;

        if (blueShirt == redShirt) {
            M = blueShirt + 1;
            N = 1;
            System.out.println(M + " " + N);
            return;
        }

        if ((blueShirt == 0 && blueSocks == 0) || (redShirt == 0 && redSocks == 0)) {
            M = 1;
            N = 1;
            System.out.println(M + " " + N);
            return;
        }

        if (blueShirt == 0 || blueSocks == 0) {
            if (blueShirt == 0) {
                M = 1;
                N = Math.max(blueSocks, redSocks) + 1;
            } else {
                M = blueShirt + 1;
                N = 1;
            }
        } else if (redShirt == 0 || redSocks == 0) {
            if (redShirt == 0) {
                M = 1;
                N = Math.min(blueSocks, redSocks) + 1;
            } else {
                M = redShirt + 1;
                N = 1;
            }
        } else {
            M = Math.max(blueShirt, redShirt) + 1;
            N = 1;
            int MNSum = M + N;

            if (redShirt < blueShirt && redSocks < blueSocks) {
                tempM = redShirt + 1;
                tempN = redSocks + 1;
            }
            if (redShirt > blueShirt && redSocks > blueSocks) {
                tempM = blueShirt + 1;
                tempN = blueSocks + 1;
            }
            int tempMNSum = tempM + tempN;

            int reverseMNSum = 1 + Math.max(blueSocks, redSocks) + 1;

            int minimum = tempMNSum == 0 ? Math.min(MNSum, reverseMNSum) : Math.min(MNSum, Math.min(tempMNSum, reverseMNSum));

            if (minimum == MNSum) {
                System.out.println(M + " " + N);
            } else if (minimum == tempMNSum) {
                System.out.println(tempM + " " + tempN);
            } else {
                System.out.println(1 + " " + (Math.max(blueSocks, redSocks) + 1));
            }
            return;
        }

        System.out.println(M + " " + N);
    }
}