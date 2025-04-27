package yandexalgo7.week2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(arr);

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] parts = reader.readLine().split(" ");
            if (parts[0].equals("UPDATE")) {
                int idx = Integer.parseInt(parts[1]) - 1;
                int val = Integer.parseInt(parts[2]);
                tree.update(idx, val);
            } else if (parts[0].equals("QUERY")) {
                int l = Integer.parseInt(parts[1]) - 1;
                int r = Integer.parseInt(parts[2]);
                int res = tree.query(l, r).max;
                System.out.println(res);
            }
        }
    }

    static class SegmentTree {
        int size = 1;
        Node[] tree;

        SegmentTree(int[] a) {
            while (size < a.length) size <<= 1;
            tree = new Node[2 * size];
            build(a);
        }

        private void build(int[] a) {
            for (int i = 0; i < 2 * size; i++) {
                tree[i] = new Node(0, 0, 0, 1);
            }
            for (int i = 0; i < a.length; i++) {
                tree[i + size] = Node.fromValue(a[i]);
            }
            for (int i = size - 1; i > 0; i--) {
                tree[i] = Node.merge(tree[2 * i], tree[2 * i + 1]);
            }
        }

        public void update(int i, int x) {
            i += size;
            tree[i] = Node.fromValue(x);
            for (i >>= 1; i > 0; i >>= 1) {
                tree[i] = Node.merge(tree[2 * i], tree[2 * i + 1]);
            }
        }

        public Node query(int l, int r) {
            l += size;
            r += size;
            Node leftRes = null, rightRes = null;

            while (l < r) {
                if ((l & 1) == 1) {
                    leftRes = (leftRes == null) ? tree[l] : Node.merge(leftRes, tree[l]);
                    l++;
                }
                if ((r & 1) == 1) {
                    r--;
                    rightRes = (rightRes == null) ? tree[r] : Node.merge(tree[r], rightRes);
                }
                l >>= 1;
                r >>= 1;
            }

            if (leftRes == null) return rightRes;
            if (rightRes == null) return leftRes;
            return Node.merge(leftRes, rightRes);
        }
    }

    static class Node {
        int max, prefix, suffix, length;

        Node(int max, int prefix, int suffix, int length) {
            this.max = max;
            this.prefix = prefix;
            this.suffix = suffix;
            this.length = length;
        }

        static Node fromValue(int val) {
            if (val == 0) {
                return new Node(1, 1, 1, 1);
            } else {
                return new Node(0, 0, 0, 1);
            }
        }

        static Node merge(Node left, Node right) {
            int totalLength = left.length + right.length;
            int prefix = (left.prefix == left.length) ? left.length + right.prefix : left.prefix;
            int suffix = (right.suffix == right.length) ? right.length + left.suffix : right.suffix;
            int maxZeros = Math.max(Math.max(left.max, right.max), left.suffix + right.prefix);
            return new Node(maxZeros, prefix, suffix, totalLength);
        }
    }
}
