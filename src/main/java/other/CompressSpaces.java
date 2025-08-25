package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompressSpaces {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add(' ');
        list.add(' ');
        list.add('b');
        list.add(' ');
        list.add('c');
        list.add(' ');
        list.add(' ');
        list.add(' ');
        System.out.println(compressSpaces(list));
    }

    public static List<Character> compressSpaces(List<Character> chars) {
        int slow = 0;
        int fast = 0;
        int spaces = 0;

        while (fast < chars.size()) {
            char c = chars.get(fast);
            spaces = c == ' ' ? spaces + 1 : 0;

            if (spaces <= 1) {
                Collections.swap(chars, slow, fast);
                slow++;
            }
            fast++;
        }
        return chars.subList(0, slow);
    }
}
