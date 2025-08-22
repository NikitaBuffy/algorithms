package other;

public class OneEditInstance {
    public static void main(String[] args) {
        System.out.println(isSimilar("iq", "ieq"));
        System.out.println(isSimilar("abcd", "abcdef"));
    }

    public static boolean isSimilar(String s, String t) {
        if (s.equals(t)) {
            return true;
        }

        int p1 = 0;
        int p2 = 0;
        int counter = 0;

        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            } else {
                counter++;
                if (counter > 1) {
                    return false;
                }
                if (s.length() == t.length()) {
                    p1++;
                    p2++;
                } else if (s.length() < t.length()) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }

        if (t.length() - p2 > 1 || s.length() - p1 > 1) {
            return false;
        }

        return true;

    }
}
