package yandexalgo7.week3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int x =  Integer.parseInt(tk.nextToken());
                if (i != j) {
                    a[i] |= x;
                }
            }
        }

        for (int k : a) {
            System.out.print(k + " ");
        }
    }
}