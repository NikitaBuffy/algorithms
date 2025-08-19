package leetcode;

/**
 * LeetCode #2264
 */
public class Largest3SameDigitNumberString {
    public static void main(String[] args) {
        System.out.println(Solution.largestGoodInteger("6777133339"));
        System.out.println(Solution.largestGoodInteger("2300019"));
        System.out.println(Solution.largestGoodInteger("42352338"));
        System.out.println(Solution.largestGoodInteger("101010"));
    }

    static class Solution {
        public static String largestGoodInteger(String num) {
            return searcher(num, 999);
        }

        private static String searcher(String num, int max) {
            if (max < 0) {
                return "";
            }
            if (max == 0 && !num.contains("000")) {
                return "";
            }

            String strNum = String.valueOf(max);

            if (num.contains(strNum)) {
                if (max == 0) {
                    return "000";
                }
                return strNum;
            } else {
                return searcher(num, max - 111);
            }
        }
    }
}
