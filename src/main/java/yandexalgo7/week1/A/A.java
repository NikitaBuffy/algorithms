package yandexalgo7.week1.A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringJoiner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] groups = new int[n][2];
        int[][] rooms = new int[m][2];

        for (int i = 0; i < n; i++) {
            groups[i][0] = scanner.nextInt();
            groups[i][1] = i + 1;
        }
        for (int i = 0; i < m; i++) {
            rooms[i][0] = scanner.nextInt();
            rooms[i][1] = i + 1;
        }

        Arrays.sort(groups, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(rooms, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        int groupIdx = groups.length - 1;
        int roomIdx = rooms.length - 1;

        int[][] res = new int[n][2];

        while (groupIdx >= 0) {
            res[groupIdx][0] = groups[groupIdx][1];
            if (groups[groupIdx][0] >= rooms[roomIdx][0]) {
                res[groupIdx][1] = 0;
            } else {
                res[groupIdx][1] = rooms[roomIdx][1];
                count++;
                roomIdx--;
            }
            groupIdx--;
        }

        StringJoiner joiner = new StringJoiner(" ");
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < groups.length; i++) {
            joiner.add(String.valueOf(res[i][1]));
        }

        System.out.println(count);
        System.out.println(joiner);
    }
}