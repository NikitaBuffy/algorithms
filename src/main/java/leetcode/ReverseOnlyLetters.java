package leetcode;

/**
 * LeetCode #917
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String case1 = Solution.reverseOnlyLetters("ab-cd");
        System.out.println(case1.equals("dc-ba"));

        String case2 = Solution.reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(case2.equals("j-Ih-gfE-dCba"));

        String case3 = Solution.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(case3.equals("Qedo1ct-eeLg=ntse-T!"));
    }

    static class Solution {
        public static String reverseOnlyLetters(String s) {
            char[] chars = s.toCharArray();
            int l = 0, r = chars.length - 1;

            while (l < r) {
                if (!Character.isLetter(chars[l])) {
                    l++;
                } else if (!Character.isLetter(chars[r])) {
                    r--;
                } else {
                    char temp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = temp;
                    l++;
                    r--;
                }
            }

            return new String(chars);
        }
    }
}
