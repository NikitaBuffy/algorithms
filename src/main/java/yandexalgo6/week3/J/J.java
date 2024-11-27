package yandexalgo6.week3.J;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class J {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week3/J/input.txt"));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int H = Integer.parseInt(firstLine[1]);

        int[] height = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] width = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Chair[] chairs = new Chair[n];
        for (int i = 0; i < n; i++) {
            chairs[i] = new Chair(height[i], width[i]);
        }

        Arrays.sort(chairs, Comparator.comparingInt(a -> a.height));

        int min = Integer.MAX_VALUE;
        int wSum = 0;
        int l = 0;

        Deque<Integer> discomfortDeque = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            wSum += chairs[r].width;

            if (r > 0) {
                int discomfort = Math.abs(chairs[r].height - chairs[r - 1].height);

                while (!discomfortDeque.isEmpty() && discomfortDeque.peekLast() < discomfort) {
                    discomfortDeque.pollLast();
                }
                discomfortDeque.addLast(discomfort);
            }

            while (wSum >= H) {
                if (!discomfortDeque.isEmpty()) {
                    min = Math.min(min, discomfortDeque.peekFirst());
                } else {
                    min = 0;
                }

                wSum -= chairs[l].width;

                if (l + 1 <= r && Math.abs(chairs[l + 1].height - chairs[l].height) == discomfortDeque.peekFirst()) {
                    discomfortDeque.pollFirst();
                }
                l++;
            }
        }

        System.out.println(min);
    }
}

class Chair {

    int height, width;

    Chair(int height, int width) {
        this.height = height;
        this.width = width;
    }
}