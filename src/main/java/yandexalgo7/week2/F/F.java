package yandexalgo7.week2.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(arr);

        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(reader.readLine());
            int t = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken());

            if (t == 0) {
                tree.set(i, x);
            } else {
                int res = tree.get(i, x);
                System.out.println(res == -1 ? -1 : res + 1);
            }
        }
    }

    static class SegmentTree {
        int[] tree;
        int size = 1;

        SegmentTree(int[] arr) {
            int n = arr.length;
            while (size < n) size *= 2;
            tree = new int[2 * size];
            Arrays.fill(tree, 0);

            for (int i = 0; i < n; i++) {
                tree[i + size] = arr[i];
            }

            for (int i = size - 1; i > 0; i--) {
                tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
            }
        }

        public void set(int i, int val) {
            i += size;
            tree[i] = val;
            for (i /= 2; i >= 1; i /= 2) {
                tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
            }
        }

        public int get(int l, int x) {
            return get(l, x, 1, 0, size);
        }

        private int get(int l, int x, int v, int lx, int rx) {
            if (rx <= l || tree[v] < x) return -1;
            if (rx - lx == 1) return lx;

            int mid = (lx + rx) / 2;
            int res = get(l, x, 2 * v, lx, mid);
            if (res == -1) {
                res = get(l, x, 2 * v + 1, mid, rx);
            }
            return res;
        }
    }
}
