package other;

import java.util.List;

public class ShortestDistanceBetweenXY {
    public static void main(String[] args) {
        System.out.println(shortestDistance(List.of("X", "X"))); // 0
        System.out.println(shortestDistance(List.of("X", "Y"))); // 1
        System.out.println(shortestDistance(List.of("O", "O", "X", "O", "O", "Y", "O", "X", "O"))); // 2
    }

    public static int shortestDistance(List<String> s) {
        int dist = Integer.MAX_VALUE;

        int xIdx = -1;
        int yIdx = -1;

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals("X")) {
                xIdx = i;
            }

            if (s.get(i).equals("Y")) {
                yIdx = i;
            }

            if (xIdx != -1 && yIdx != -1) {
                dist = Math.min(dist, Math.abs(xIdx - yIdx));
            }
        }

        return (xIdx == -1 || yIdx == -1) ? 0 : dist;
    }
}
