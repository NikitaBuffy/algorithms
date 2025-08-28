package leetcode.hashtable;

/**
 * LeetCode #274
 */
public class HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex(new int[]{1, 3, 1}));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int citation : citations) {
            count[Math.min(n, citation)]++;
        }

        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += count[i];
            if (cnt >= i) {
                return i;
            }
        }

        return cnt;
    }
}
