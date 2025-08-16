package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #658
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        System.out.println(Solution.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
    }

    static class Solution {
        public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int l = 0;
            int r = arr.length - 1;

            while (r - l + 1 > k) {
                if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                    l++;
                } else {
                    r--;
                }
            }

            List<Integer> ans = new ArrayList<>();

            for (int i = l; i <= r; i++) {
                ans.add(arr[i]);
            }

            return ans;
        }
    }
}
