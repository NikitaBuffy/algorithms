package yandexalgo6.week1.A;

import java.util.Scanner;

/**
 * Не оптимизированное решение.
 * Итоговый вариант в классе A2.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] swCoords = new int[2];
        int[] neCoords = new int[2];
        int[] userCoords = new int[2];

        for (int i = 0; i < swCoords.length; i++) {
            swCoords[i] = scanner.nextInt();
        }
        for (int i = 0; i < neCoords.length; i++) {
            neCoords[i] = scanner.nextInt();
        }
        for (int i = 0; i < userCoords.length; i++) {
            userCoords[i] = scanner.nextInt();
        }

        if (userCoords[0] > swCoords[0] && userCoords[0] < neCoords[0]) {
            System.out.println(userCoords[1] > neCoords[1] ? "N" : "S");
        } else if (userCoords[1] > swCoords[1] && userCoords[1] < neCoords[1]) {
            System.out.println(userCoords[0] > neCoords[0] ? "E" : "W");
        } else {
            if (userCoords[0] < swCoords[0] && userCoords[1] < swCoords[1]) {
                System.out.println("SW");
            } else if (userCoords[0] < swCoords[0] && userCoords[1] > neCoords[1]) {
                System.out.println("NW");
            } else if (userCoords[0] > neCoords[0] && userCoords[1] > neCoords[1]) {
                System.out.println("NE");
            } else if (userCoords[0] > neCoords[0] && userCoords[1] < swCoords[1]) {
                System.out.println("SE");
            }
        }
    }
}