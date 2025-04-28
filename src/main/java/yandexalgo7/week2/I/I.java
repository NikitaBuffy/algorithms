package yandexalgo7.week2.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner out = new StringJoiner(" ");

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(arr);

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String action = st.nextToken();

            if (action.equals("m")) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                Pair res = tree.max(l - 1, r);

                out.add(String.valueOf(res.max));
            } else if (action.equals("a")) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int add = Integer.parseInt(st.nextToken());
                tree.add(l - 1, r, add);
            }
        }

        System.out.println(out);
    }

    static class SegmentTree {
        int m = 1;
        Pair[] tree;

        SegmentTree(int[] a) {
            while (m < a.length) m <<= 1;
            tree = new Pair[2 * m];
            build(a);
        }

        private void build(int[] a) {
            for (int i = 0; i < 2 * m; i++) tree[i] = new Pair(0, 0);
            for (int i = 0; i < a.length; i++) {
                tree[i + m].max = a[i];
            }
            for (int i = m - 1; i > 0; i--) {
                tree[i].max = Math.max(tree[2 * i].max, tree[2 * i + 1].max);
            }
        }

        private void push(int x) {
            if (tree[x].add != 0) {
                apply(2 * x, tree[x].add);
                apply(2 * x + 1, tree[x].add);
                tree[x].add = 0;
            }
        }

        private void apply(int x, long v) {
            tree[x].max += v;
            tree[x].add += v;
        }

        public void add(int l, int r, int v) {
            add(l, r, v, 1, 0, m);
        }

        private void add(int l, int r, int v, int x, int lx, int rx) {
            if (rx <= l || lx >= r) return;
            if (lx >= l && rx <= r) {
                apply(x, v);
                return;
            }
            push(x);
            int mid = (lx + rx) / 2;
            add(l, r, v, 2 * x, lx, mid);
            add(l, r, v, 2 * x + 1, mid, rx);
            tree[x].max = Math.max(tree[2 * x].max, tree[2 * x + 1].max);
        }

        public Pair max(int l, int r) {
            return max(l, r, 1, 0, m);
        }

        private Pair max(int l, int r, int x, int lx, int rx) {
            if (l >= rx || lx >= r) {
                return new Pair(-1, -1);
            }
            if (lx >= l && rx <= r) {
                return tree[x];
            }
            push(x);
            int mid = (lx + rx) / 2;
            Pair left = max(l, r, 2 * x, lx, mid);
            Pair right = max(l, r, 2 * x + 1, mid, rx);

            return (left.max >= right.max) ? left : right;
        }
    }

    static class Pair {
        long max;
        long add;

        Pair(long max, long add) {
            this.max = max;
            this.add = add;
        }
    }
}