package yandexalgo7.week1.E;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] items = new int[n][2];
        for (int i = 0; i < items.length; i++) {
            items[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < items.length; i++) {
            items[i][1] = scanner.nextInt();
        }

        int[] arr = new int[m + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;

        for (int[] k : items) {
            for (int j = m - k[0]; j >= 0; j--) {
                if (arr[j] != -1) {
                    arr[j + k[0]] = Math.max(arr[j + k[0]], arr[j] + k[1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}

/*
4 9
2 3 5 2
2 1 4 4
 */
