package other;

import java.util.List;

public class LongestStockGrowth {
    public static void main(String[] args) {
        System.out.println(longestStockGrowth(List.of(-1, 1, -1, 1, 1, 1, 1, -1, 1))); // 4
        System.out.println(longestStockGrowth(List.of(1, -1, -1, 1))); // 1
    }

    public static int longestStockGrowth(List<Integer> stock)  {
        int l = 0;
        int r = 0;

        int max = 0;

        while (l < stock.size()) {
            while (r + 1 < stock.size() && stock.get(r) == stock.get(r + 1)) {
                r++;
            }

            if (stock.get(r) == 1) {
                max = Math.max(max, r - l + 1);
            }

            l = r + 1;
            r = r + 1;
        }

        return max;
    }
}
