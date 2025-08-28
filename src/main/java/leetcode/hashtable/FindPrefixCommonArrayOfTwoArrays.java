package leetcode.hashtable;

import java.util.Arrays;

/**
 * LeetCode #2657
 */
public class FindPrefixCommonArrayOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,1,3,4,5};
        int[] nums2 = new int[]{3,1,2,5,4};
        System.out.println(Arrays.toString(findThePrefixCommonArray(nums1, nums2)));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        int[] freq = new int[A.length + 1];

        int common = 0;
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            freq[B[i]]++;

            if (A[i] == B[i]) {
                common++;
                result[i] = common;
                continue;
            }

            if (freq[A[i]] == 2) {
                common++;
            }

            if (freq[B[i]] == 2) {
                common++;
            }

            result[i] = common;
        }

        return result;
    }
}
