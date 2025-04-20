package yandexalgo7.week1.D;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] gold = new int[n];
        for (int i = 0; i < gold.length; i++) {
            gold[i] = scanner.nextInt();
        }

        boolean[] arr = new boolean[m + 1];
        arr[0] = true;

        for (int k : gold) {
            for (int j = m - k; j >= 0; j--) {
                if (arr[j]) {
                    arr[j + k] = true;
                }
            }
        }

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}