package yandexalgo6.week4.B;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<String>> tree = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            String[] line = scanner.nextLine().split(" ");
            String child = line[0];
            String parent = line[1];
            tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        Set<String> all = new HashSet<>(tree.keySet());
        for (List<String> children : tree.values()) {
            all.addAll(children);
        }

        Map<String, Integer> desc = new HashMap<>();

        for (String name : all) {
            if (!desc.containsKey(name)) {
                computeDesc(name, tree, desc);
            }
        }

        List<String> sortedNames = new ArrayList<>(desc.keySet());
        Collections.sort(sortedNames);

        for (String name : sortedNames) {
            System.out.println(name + " " + desc.get(name));
        }
    }

    public static int computeDesc(String name, Map<String, List<String>> tree, Map<String, Integer> descendants) {
        if (!tree.containsKey(name)) {
            descendants.put(name, 0);
            return 0;
        }

        int count = 0;
        for (String child : tree.get(name)) {
            count += 1 + computeDesc(child, tree, descendants);
        }
        descendants.put(name, count);
        return count;
    }
}