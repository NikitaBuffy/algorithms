package yandexalgo6.week2.H;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week2/H/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());

        long[] a = new long[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayInput.nextToken());
        }

        long curr = 0;
        long totalE = 0;

        for (int i = 0; i < n; i++) {
            curr += i * a[i];
            totalE += a[i];
        }

        long min = curr;
        long leftE = 0;
        long rightE = totalE;

        for (int j = 1; j < n; j++) {
            leftE += a[j - 1];
            rightE -= a[j - 1];

            curr += leftE - rightE;
            min = Math.min(min, curr);
        }

        System.out.println(min);
    }
}