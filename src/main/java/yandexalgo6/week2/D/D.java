package yandexalgo6.week2.D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week2/D/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());
        int k = Integer.parseInt(initialInput.nextToken());

        int[] a = new int[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayInput.nextToken());
        }

        Arrays.sort(a);

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (a[right] - a[left] <= k) {
                max = Integer.max(max, right - left + 1);
                right++;
            } else {
                left++;
            }
        }

        System.out.println(max);

        reader.close();
    }
}