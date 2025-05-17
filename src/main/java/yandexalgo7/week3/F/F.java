package yandexalgo7.week3.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K == 0) {
            System.out.println("NO");
            System.out.println("1 1 1");
            return;
        }

        long[] xy = new long[N + 1];
        long[] zy = new long[N + 1];
        long[] xz = new long[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            xy[x] |= (1L << (y - 1));
            zy[z] |= (1L << (y - 1));
            xz[x] |= (1L << (z - 1));
        }

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int z = 1; z <= N; z++) {
                    if ((xy[x] & (1L << (y - 1))) == 0 &&
                            (zy[z] & (1L << (y - 1))) == 0 &&
                            (xz[x] & (1L << (z - 1))) == 0) {

                        System.out.println("NO");
                        System.out.println(x + " " + y + " " + z);
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
    }
}