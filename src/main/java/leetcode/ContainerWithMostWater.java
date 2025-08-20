package leetcode;

/**
 * LeetCode #11
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(Solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(Solution.maxArea(new int[]{1,1}));
    }

    static class Solution {
        public static int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;

            int result = -1;

            while (l < r) {
                int amount = Math.min(height[l], height[r]) * (r - l);
                result = Math.max(amount, result);

                if (height[l] > height[r]) {
                    r--;
                }  else {
                    l++;
                }
            }

            return result;
        }
    }
}
