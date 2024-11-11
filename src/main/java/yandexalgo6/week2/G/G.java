package yandexalgo6.week2.G;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week2/G/input.txt"));

        StringTokenizer initialInput = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(initialInput.nextToken());
        long c = Long.parseLong(initialInput.nextToken());

        StringTokenizer stringInput = new StringTokenizer(reader.readLine());
        String s = stringInput.nextToken();

        int l = 0;
        long countA = 0, countB = 0, roughness = 0, max = 0;

        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == 'a') {
                countA++;
            }
            if (s.charAt(r) == 'b') {
                countB++;
                roughness += countA;
            }

            while (roughness > c) {
                if (s.charAt(l) == 'a') {
                    roughness -= countB;
                    countA--;
                }
                if (s.charAt(l) == 'b') {
                    countB--;
                }
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        System.out.println(max);
    }
}