package yandexalgo6.week3.I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class I {
    static int a, b;
    static int time = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = scanner.nextInt() - 1;
        b = scanner.nextInt() - 1;

        List<List<Rover>> queues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            queues.add(new ArrayList<>());
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt() - 1;
            int t = scanner.nextInt();
            queues.get(d).add(new Rover(t, i));
        }

        for (int i = 0; i < 4; i++) {
            Collections.sort(queues.get(i));
        }

        while (n > 0) {
            boolean[] moves = new boolean[4];
            for (int dir = 0; dir < 4; dir++) {
                if (canGo(queues, dir)) {
                    if (isMain(dir) && isMain(right(dir)) && canGo(queues, right(dir))) {
                        continue;
                    }
                    if (!isMain(dir) && (canGo(queues, right(dir)) || canGo(queues, a) || canGo(queues, b))) {
                        continue;
                    }
                    moves[dir] = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                if (moves[i]) {
                    n--;
                    Rover rover = queues.get(i).remove(0);
                    ans[rover.index] = time;
                }
            }
            time++;
        }

        for (int t : ans) {
            System.out.println(t);
        }
    }

    static boolean isMain(int x) {
        return x == a || x == b;
    }

    static int right(int x) {
        return (x + 3) % 4;
    }

    static boolean canGo(List<List<Rover>> qs, int x) {
        return !qs.get(x).isEmpty() && qs.get(x).get(0).time <= time;
    }

    static class Rover implements Comparable<Rover> {
        int time, index;

        Rover(int time, int index) {
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Rover other) {
            return Integer.compare(this.time, other.time);
        }
    }
}