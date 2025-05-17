package yandexalgo7.week3.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {
    static int n;
    static long[] a;
    static long[] t;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new long[n];
        t = new long[n];

        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(reader.readLine());
            String action = st.nextToken();

            if (action.equals("A")) {
                int i = Integer.parseInt(st.nextToken()) - 1;
                long x = Long.parseLong(st.nextToken());
                update(i, x);
            } else if (action.equals("Q")) {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                System.out.println(getSum(r) - getSum(l - 1));
            }
        }
    }

    static void update(int i, long x) {
        long delta = x - a[i];
        a[i] = x;
        for (int j = i; j < n; j |= (j + 1)) {
            t[j] += delta;
        }
    }

    static long getSum(int r) {
        long res = 0;
        while (r >= 0) {
            res += t[r];
            r = (r & (r + 1)) - 1;
        }
        return res;
    }
}