package yandexalgo7.week2.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner out = new StringJoiner(" ");

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(n);
        for (int i = 0; i < n; i++) {
            tree.update(i, arr[i]);
        }

        int k = Integer.parseInt(reader.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            String action = st.nextToken();

            if (action.equals("s")) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                Pair res = tree.find(l - 1, r);
                out.add(String.valueOf(res.max));
            } else if (action.equals("u")) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                tree.update(idx - 1, val);
            }
        }

        System.out.print(out);
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
                tree[v] = new Pair(val, i + 1);
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
            } else {
                tree[v] = right;
            }
        }

        public Pair find(int l, int r) {
            return find(l, r, 0, 0, m);
        }

        private Pair find(int l, int r, int v, int lx, int rx) {
            if (l >= rx || lx >= r) {
                return new Pair(-1, -1);
            }
            if (lx >= l && rx <= r) {
                return tree[v];
            }

            int mid = (lx + rx) / 2;
            Pair left = find(l, r, 2 * v + 1, lx, mid);
            Pair right = find(l, r, 2 * v + 2, mid, rx);

            if (left.max > right.max) {
                return left;
            } else {
                return right;
            }
        }
    }

    static class Pair {
        int max;
        int index;

        Pair(int max, int index) {
            this.max = max;
            this.index = index;
        }
    }
}
