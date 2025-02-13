package leetcode;

/**
 * LeetCode #4
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(Double.compare(
                2, Solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})
        ));
        System.out.println(Double.compare(
                2.5, Solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})
        ));
        System.out.println(Double.compare(
                2, Solution.findMedianSortedArrays2(new int[]{1, 3}, new int[]{2})
        ));
        System.out.println(Double.compare(
                2.5, Solution.findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4})
        ));
    }

    static class Solution {
        /*
         * O(n + m)
         */
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int p1 = 0, p2 = 0, idx = 0;
            int[] res = new int[nums1.length + nums2.length];

            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] > nums2[p2]) {
                    res[idx++] = nums2[p2];
                    p2++;
                } else {
                    res[idx++] = nums1[p1];
                    p1++;
                }
            }
            while (p1 < nums1.length) {
                res[idx++] = nums1[p1++];
            }
            while (p2 < nums2.length) {
                res[idx++] = nums2[p2++];
            }

            double median;

            if (res.length % 2 == 0) {
                int mid1 = res.length / 2 - 1;
                int mid2 = res.length / 2;

                median = (double) (res[mid1] + res[mid2]) / 2;
            } else {
                median = res[res.length / 2];
            }

            return median;
        }

        /*
         * O(log(min(n + m)) = O(log(n + m)
         */
        public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            if (m > n) {
                return findMedianSortedArrays2(nums2, nums1);
            }

            int l = 0, r = m;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                int mid2 = (m + n + 1) / 2 - mid;

                int l1 = mid == 0 ? Integer.MIN_VALUE: nums1[mid - 1];
                int r1 = mid == m ? Integer.MAX_VALUE: nums1[mid];

                int l2 = mid2 == 0 ? Integer.MIN_VALUE: nums2[mid2 - 1];
                int r2 = mid2 == n ? Integer.MAX_VALUE: nums2[mid2];

                if (l1 <= r2 && l2 <= r1) {
                    if ((n + m) % 2 == 0) {
                        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    } else {
                        return Math.max(l1, l2);
                    }
                } else {
                    if (l1 > r2) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }

            return 0;
        }
    }
}
