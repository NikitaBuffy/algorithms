package yandexalgo7.week1.F;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F {
    public static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] weights = new int[n];
        int[] costs = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= weights[i - 1]) {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - weights[i - 1]] + costs[i - 1]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        findConsequence(arr, weights, n, m);

        result.forEach(System.out::println);
    }

    public static void findConsequence(int[][] arr, int[] weights, int i, int j) {
        if (arr[i][j] == 0) {
            return;
        }
        if (arr[i - 1][j] == arr[i][j]) {
            findConsequence(arr, weights, i - 1, j);
        } else {
            findConsequence(arr, weights, i - 1, j - weights[i - 1]);
            result.add(i);
        }
    }
}
