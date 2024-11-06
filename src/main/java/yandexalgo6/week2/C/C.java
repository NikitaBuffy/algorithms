package yandexalgo6.week2.C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week2/C/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());
        int m = Integer.parseInt(initialInput.nextToken());

        int[] d = new int[n];
        StringTokenizer arrayInput = new StringTokenizer(reader.readLine());
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(arrayInput.nextToken());
        }

        long counter = 0;
        int left = 0, right = 0;

        while (right < n && left < n - 1) {
            if (d[right] - d[left] <= m) {
                right++;
            } else {
                counter += n - right;
                left++;
            }
        }

        System.out.println(counter);

        reader.close();
    }
}