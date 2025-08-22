package other;

import java.util.ArrayList;
import java.util.List;

public class UrlficationOfString {
    public static void main(String[] args) {
        System.out.println(urlify(new ArrayList<>(List.of('a', 'b', ' ', 'c', '#', '#')), 4));
        System.out.println(urlify(new ArrayList<>(List.of(' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#')), 5));
    }

    static List<Character> urlify(List<Character> s, int k) {
        int p1 = s.size() - 1;
        int p2 = k - 1;

        while (p2 >= 0) {
            if (s.get(p2) != ' ') {
                s.set(p1, s.get(p2));
                p1--;
            } else {
                s.set(p1--, '0');
                s.set(p1--, '2');
                s.set(p1--, '%');
            }
            p2--;
        }

        return s;
    }
}
