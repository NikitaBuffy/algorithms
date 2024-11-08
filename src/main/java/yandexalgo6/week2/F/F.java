package yandexalgo6.week2.F;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week2/F/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());

        int[] a = new int[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayInput.nextToken());
        }

        final int MOD = 1000000007;
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;

        for (int i = 0; i < n; i++) {
            sum3 = (sum3 + sum2 * a[i] % MOD) % MOD;
            sum2 = (sum2 + sum1 * a[i] % MOD) % MOD;
            sum1 = (sum1 + a[i]) % MOD;
        }

        System.out.println(sum3);
    }
}