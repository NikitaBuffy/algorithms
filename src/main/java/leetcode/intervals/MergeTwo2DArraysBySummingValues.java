package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #2570
 */
public class MergeTwo2DArraysBySummingValues {
    public static void main(String[] args) {
        List<int[]> f = new ArrayList<>();
        f.add(new int[]{2,4});
        f.add(new int[]{3,6});
        f.add(new int[]{5,5});

        List<int[]> s = new ArrayList<>();
        s.add(new int[]{1,3});
        s.add(new int[]{4,3});

        // [[1,3],[2,4],[3,6],[4,3],[5,5]]
        System.out.println(Arrays.deepToString(mergeArrays(f.toArray(new int[f.size()][]), s.toArray(new int[s.size()][]))));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1][0] < nums2[p2][0]) {
                result.add(new int[]{nums1[p1][0], nums1[p1][1]});
                p1++;
            } else if (nums1[p1][0] > nums2[p2][0]) {
                result.add(new int[]{nums2[p2][0], nums2[p2][1]});
                p2++;
            } else {
                result.add(new int[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]});

                p1++;
                p2++;
            }
        }

        while (p1 < nums1.length) {
            result.add(new int[]{nums1[p1][0], nums1[p1][1]});
            p1++;
        }

        while (p2 < nums2.length) {
            result.add(new int[]{nums2[p2][0], nums2[p2][1]});
            p2++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
