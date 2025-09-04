package other;

import java.util.ArrayList;
import java.util.List;

public class KElementsMultiply {
    public static void main(String[] args) {
        System.out.println(kElementsMultiply(List.of(-2,0,1,8,-9,0,1,2,3,0), 3)); // [0,0,-72,0,0,0,6,0]
        System.out.println(kElementsMultiply(List.of(-100, 2), 1)); // [-100,2]
        System.out.println(kElementsMultiply(List.of(1,8,9), 5)); // []
    }

    public static List<Integer> kElementsMultiply(List<Integer> price, int k) {
        if (k > price.size()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int prod = 1;
        int zeroCount = 0;

        int l = 0;
        int r = 0;

        for (int i = 0; i < k; i++) {
            if (price.get(i) == 0) {
                zeroCount++;
            } else {
                prod *= price.get(i);
            }
            r++;
        }

        if (zeroCount > 0) {
            result.add(0);
        } else {
            result.add(prod);
        }

        while (r < price.size()) {
            if (price.get(l) == 0) {
                zeroCount--;
            } else {
                prod /= price.get(l);
            }

            if (price.get(r) == 0) {
                zeroCount++;
            } else {
                prod *= price.get(r);
            }

            if (zeroCount > 0) {
                result.add(0);
            } else {
                result.add(prod);
            }

            l++;
            r++;
        }

        return result;
    }
}
