package other;

import java.util.List;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate(List.of("2","*","3","*","1","+","2","+","2","+","2","*","0","*","13","+","1")));
        System.out.println(calculate(List.of("1","+","2","+","3")));
    }

    public static int calculate(List<String> s) {
        int result = 0;
        int prevMul = Integer.parseInt(s.get(0));

        for (int i = 1; i < s.size(); i = i + 2) {
            if (s.get(i).equals("+")) {
                result += prevMul;
                prevMul = Integer.parseInt(s.get(i + 1));
            } else {
                prevMul *= Integer.parseInt(s.get(i + 1));
            }
        }

        result += prevMul;

        return result;
    }
}
