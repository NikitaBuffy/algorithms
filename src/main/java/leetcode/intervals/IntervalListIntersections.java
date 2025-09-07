package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #986
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        List<int[]> f = new ArrayList<>();
        f.add(new int[]{0,2});
        f.add(new int[]{5,10});
        f.add(new int[]{13,23});
        f.add(new int[]{24,25});

        List<int[]> s = new ArrayList<>();
        s.add(new int[]{1,5});
        s.add(new int[]{8,12});
        s.add(new int[]{15,24});
        s.add(new int[]{25,26});

        // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(Arrays.deepToString(intervalIntersection(f.toArray(new int[f.size()][]), s.toArray(new int[s.size()][]))));
    }

    private static boolean isIntersects(int[] a, int[] b) {
        return Math.max(a[0], b[0]) <= Math.min(a[1], b[1]);
    }

    private static int[] mergeSegment(int[] a, int[] b) {
        int[] overlap = new int[2];
        overlap[0] = Math.max(a[0], b[0]);
        overlap[1] = Math.min(a[1], b[1]);

        return overlap;
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < firstList.length && p2 < secondList.length) {
            if (isIntersects(firstList[p1], secondList[p2])) {
                result.add(mergeSegment(firstList[p1], secondList[p2]));
            }

            if (firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
