package other;

import java.util.List;

public class BestParkingSpot {
    public static void main(String[] args) {
        System.out.println(bestParkingSpot(List.of(1, 0, 0, 0, 1, 0, 1))); // 2
        System.out.println(bestParkingSpot(List.of(1, 0, 0, 0))); // 3
    }

    public static int bestParkingSpot(List<Integer> spots)  {
        int l = 0;
        int r = 0;
        int result = 0;

        while (l < spots.size()) {
            while (r + 1 < spots.size() && spots.get(r) == spots.get(r + 1)) {
                r++;
            }

            if (spots.get(l) != 1) {
                if (l == 0 || r == spots.size() - 1) {
                    result = Math.max(result, r - l + 1);
                } else {
                    result = Math.max(result, (r - l + 2) / 2);
                }
            }

            l = r + 1;
            r = r + 1;
        }

        return result;
    }
}
