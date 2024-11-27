package yandexalgo6.week4.A;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, String> tree = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            String[] line = scanner.nextLine().split(" ");
            String child = line[0];
            String parent = line[1];
            tree.put(child, parent);
        }

        Set<String> all = new HashSet<>(tree.keySet());
        all.addAll(tree.values());

        Map<String, Integer> heights = new HashMap<>();

        for (String name : all) {
            if (!heights.containsKey(name)) {
                computeHeight(name, tree, heights);
            }
        }

        List<String> sortedNames = new ArrayList<>(heights.keySet());
        Collections.sort(sortedNames);

        for (String name : sortedNames) {
            System.out.println(name + " " + heights.get(name));
        }
    }

    public static int computeHeight(String name, Map<String, String> tree, Map<String, Integer> heights) {
        if (!tree.containsKey(name)) {
            heights.put(name, 0);
            return 0;
        }

        String parent = tree.get(name);
        if (heights.containsKey(parent)) {
            int value = heights.get(parent) + 1;
            heights.put(name, value);
            return value;
        }

        int value = computeHeight(parent, tree, heights) + 1;
        heights.put(name, value);
        return value;
    }
}