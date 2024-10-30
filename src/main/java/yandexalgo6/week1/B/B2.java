package yandexalgo6.week1.B;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Оптимизированное решение
 */
public class B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        List<int[]> ans = new ArrayList<>();

        if (a > 0 && c > 0) {
            ans.add(new int[]{b + 1, d + 1});
        }
        if (b > 0 && d > 0) {
            ans.add(new int[]{a + 1, c + 1});
        }
        if (a > 0 && b > 0) {
            ans.add(new int[]{Math.max(a, b) + 1, 1});
        }
        if (c > 0 && d > 0) {
            ans.add(new int[]{1, Math.max(c, d) + 1});
        }

        int[] res = ans.stream().min(Comparator.comparingInt(pair -> pair[0] + pair[1])).orElse(new int[]{0, 0});

        System.out.println(res[0] + " " + res[1]);
    }
}
