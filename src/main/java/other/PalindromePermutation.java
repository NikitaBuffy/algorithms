package other;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("cabab"));
        System.out.println(isPalindromePermutation("hello"));
    }

    public static boolean isPalindromePermutation(String s) {
        int[] count = new int[26];

        for (Character ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int odd = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
        }

        return odd <= 1;
    }
}
