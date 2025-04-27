package yandexalgo7.week2.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class E {
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

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String action = st.nextToken();

            if (action.equals("s")) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                int res = tree.find(l - 1, r, k);

                out.add(String.valueOf(res));
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
                tree[i] = new Pair(0);
            }
        }

        public void update(int i, int val) {
            update(i, val, 0, 0, m);
        }

        private void update(int i, int val, int v, int lx, int rx) {
            if (rx - lx == 1) {
                tree[v] = new Pair(val == 0 ? 1 : 0);
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

            tree[v] = new Pair(left.count + right.count);
        }

        public int find(int l, int r, int k) {
            return find(l, r, k, 0, 0, m);
        }

        private int find(int l, int r, int k, int v, int lx, int rx) {
            if (tree[v].count < k) return -1;
            if (rx - lx == 1) return lx + 1;

            int mid = (lx + rx) / 2;

            int leftCount = countZeros(l, r, 2 * v + 1, lx, mid);
            if (leftCount >= k) {
                return find(l, r, k, 2 * v + 1, lx, mid);
            } else {
                return find(l, r, k - leftCount, 2 * v + 2, mid, rx);
            }
        }

        private int countZeros(int l, int r, int v, int lx, int rx) {
            if (lx >= r || rx <= l) return 0;
            if (lx >= l && rx <= r) return tree[v].count;

            int mid = (lx + rx) / 2;
            return countZeros(l, r, 2 * v + 1, lx, mid) + countZeros(l, r, 2 * v + 2, mid, rx);
        }

    }

    static class Pair {
        int count;

        Pair(int count) {
            this.count = count;
        }
    }
}
