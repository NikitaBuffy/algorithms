package leetcode.hashtable;

import java.util.*;

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

    // Без учета кратности
    public List<Integer> findCommonPrefix(List<Integer> nums1, List<Integer> nums2) {
        Set<Integer> used1 = new HashSet<>();
        Set<Integer> used2 = new HashSet<>();
        int commonCount = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.size(); i++) {
            if (!used1.contains(nums1.get(i))) {
                used1.add(nums1.get(i));
                if (used2.contains(nums1.get(i))) {
                    commonCount++;
                }
            }

            if (!used2.contains(nums2.get(i))) {
                used2.add(nums2.get(i));
                if (used1.contains(nums2.get(i))) {
                    commonCount++;
                }
            }
            result.add(commonCount);
        }
        return result;
    }
}
