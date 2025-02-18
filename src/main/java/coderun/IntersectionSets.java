package coderun;

import java.util.*;

/**
 * Coderun #61
 */
public class IntersectionSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        String line = scanner.nextLine();
        String[] strNumbers = line.split(" ");

        for (String str : strNumbers) {
            first.add(Integer.parseInt(str));
        }

        String line2 = scanner.nextLine();
        String[] strNumbers2 = line2.split(" ");

        for (String str : strNumbers2) {
            second.add(Integer.parseInt(str));
        }

        Collections.sort(first);
        Collections.sort(second);

        List<Integer> result = new ArrayList<>();
        int n1 = 0, n2 = 0;

        while (n1 < first.size() && n2 < second.size()) {
            Integer f = first.get(n1);
            Integer s = second.get(n2);
            if (f.equals(s)) {
                result.add(f);
                n1++;
                n2++;
            } else if (f < s) {
                n1++;
            } else {
                n2++;
            }
        }

        result.forEach(i -> System.out.print(i + " "));
    }
}
