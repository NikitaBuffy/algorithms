package yandexalgo7.week2.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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

            if (action.equals("g")) {
                int num = Integer.parseInt(st.nextToken());
                System.out.println(tree.get(num));
            } else if (action.equals("a")) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int add = Integer.parseInt(st.nextToken());
                tree.add(l, r + 1, add);
            }
        }
    }

    static class SegmentTree {
        Pair[] tree;
        int m = 1;

        SegmentTree(int[] a) {
            while (m < a.length) m *= 2;
            tree = new Pair[2 * m];
            build(a);
        }

        private void build(int[] a) {
            for (int i = 0; i < 2 * m; i++) tree[i] = new Pair(0, 0);
            for (int i = 0; i < a.length; i++) {
                tree[i + m].value = a[i];
            }
            for (int i = m - 1; i > 0; i--) {
                tree[i].value = 0;
            }
        }

        private void push(int x, int lx, int rx) {
            if (tree[x].add != 0 && rx - lx > 1) {
                apply(2 * x + 1, tree[x].add);
                apply(2 * x + 2, tree[x].add);
                tree[x].add = 0;
            }
        }

        private void apply(int x, long v) {
            tree[x].value += v;
            tree[x].add += v;
        }

        public void add(int l, int r, int v) {
            add(l, r, v, 0, 0, m);
        }

        private void add(int l, int r, int v, int x, int lx, int rx) {
            if (rx <= l || lx >= r) return;
            if (lx >= l && rx <= r) {
                apply(x, v);
                return;
            }
            push(x, lx, rx);
            int m = (lx + rx) / 2;
            add(l, r, v, 2 * x + 1, lx, m);
            add(l, r, v, 2 * x + 2, m, rx);
        }

        public long get(int i) {
            return get(i, 0, 0, m);
        }

        private long get(int i, int x, int lx, int rx) {
            if (rx - lx == 1) {
                return tree[x].value;
            }
            push(x, lx, rx);
            int m = (lx + rx) / 2;
            if (i < m) {
                return get(i, 2 * x + 1, lx, m);
            } else {
                return get(i, 2 * x + 2, m, rx);
            }
        }

    }

    static class Pair {
        long value;
        long add;

        Pair(long value, long add) {
            this.value = value;
            this.add = add;
        }
    }
}
