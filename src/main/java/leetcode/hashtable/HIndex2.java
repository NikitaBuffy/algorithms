package leetcode.hashtable;

/**
 * LeetCode #275
 */
public class HIndex2 {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0,1,3,5,6}));
        System.out.println(hIndex(new int[]{1,2,100}));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        int h = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = n - mid;

            if (citations[mid] >= count) {
                h = count;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return h;
    }
}
