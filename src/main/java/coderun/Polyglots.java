package coderun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Coderun #3
 */
public class Polyglots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> common = null;
        Set<String> all = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(scanner.nextLine());
            Set<String> langs = new HashSet<>();

            for (int j = 0; j < m; j++) {
                String language = scanner.nextLine();
                langs.add(language);
            }

            if (i == 0) {
                common = new HashSet<>(langs);
            } else {
                common.retainAll(langs);
            }

            all.addAll(langs);
        }

        System.out.println(common.size());
        for (String lang : common) {
            System.out.println(lang);
        }

        System.out.println(all.size());
        for (String lang : all) {
            System.out.println(lang);
        }
    }
}
