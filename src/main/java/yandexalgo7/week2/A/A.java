package yandexalgo7.week2.A;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < n; i++) {
            int j = scanner.nextInt();
            tree.update(i, j);
        }

        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            Pair res = tree.find(l - 1, r);
            System.out.println(res.max + " " + res.count);
        }
    }

    static class SegmentTree {
        Pair[] tree;
        int m = 1;

        SegmentTree(int n) {
            while (m < n) m *= 2;
            tree = new Pair[2 * m - 1];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Pair(-1, 0);
            }
        }

        public void update(int i, int val) {
            update(i, val, 0, 0, m);
        }

        private void update(int i, int val, int v, int lx, int rx) {
            if (rx - lx == 1) {
                tree[v] = new Pair(val, 1);
                return;
            }

            int mid = (lx + rx) / 2;
            if (i < mid) {
                update(i, val, 2 * v + 1, lx, mid);
            } else {
                update(i, val, 2 * v + 2, mid, rx);
            }

            Pair left = tree[2 * v + 1];
            Pair right = tree[2 * v + 2];

            if (left.max > right.max) {
                tree[v] = left;
            } else if (left.max < right.max) {
                tree[v] = right;
            } else {
                tree[v] = new Pair(left.max, left.count + right.count);
            }
        }

        public Pair find(int l, int r) {
            return find(l, r, 0, 0, m);
        }

        private Pair find(int l, int r, int v, int lx, int rx) {
            if (l >= rx || lx >= r) {
                return new Pair(-1, 0);
            }
            if (lx >= l && rx <= r) {
                return tree[v];
            }

            int mid = (lx + rx) / 2;
            Pair left = find(l, r, 2 * v + 1, lx, mid);
            Pair right = find(l, r, 2 * v + 2, mid, rx);

            if (left.max > right.max) {
                return left;
            } else if (left.max < right.max) {
                return right;
            } else {
                return new Pair(left.max, left.count + right.count);
            }
        }

    }

    static class Pair {
        int max;
        int count;

        Pair(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }
}
