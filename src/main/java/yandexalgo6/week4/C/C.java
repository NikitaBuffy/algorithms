package yandexalgo6.week4.C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week4/C/input.txt"));

        int n = Integer.parseInt(reader.readLine());

        Map<String, String> tree = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            String[] line = reader.readLine().split(" ");
            String child = line[0];
            String parent = line[1];
            tree.put(child, parent);
        }

        List<String[]> input = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line != null) {
                String[] pair = line.split(" ");
                input.add(pair);
            } else {
                break;
            }
        }

        for (String[] pair : input) {
            String lca = findLCA(pair[0], pair[1], tree);
            System.out.println(lca);
        }
    }

    public static String findLCA(String a, String b, Map<String, String> parentMap) {
        Set<String> ancestorsA = new HashSet<>();
        while (a != null) {
            ancestorsA.add(a);
            a = parentMap.get(a);
        }

        while (b != null) {
            if (ancestorsA.contains(b)) {
                return b;
            }
            b = parentMap.get(b);
        }

        return null;
    }
}