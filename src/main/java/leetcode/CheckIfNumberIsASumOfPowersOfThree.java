package leetcode;

/**
 * LeetCode #1780
 */
public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        System.out.println(Solution.checkPowersOfThree(12));
        System.out.println(Solution.checkPowersOfThree(91));
        System.out.println(Solution.checkPowersOfThree(21));
    }

    static class Solution {
        public static boolean checkPowersOfThree(int n) {
            int[] powers = new int[] {4782969, 1594323, 531441, 177147, 59049, 19683, 6561, 2187, 729, 243, 81, 27, 9, 3, 1};

            for (int power : powers) {
                if (n - power < 0) {
                    continue;
                } else if (n - power > 0) {
                    n -= power;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
}
