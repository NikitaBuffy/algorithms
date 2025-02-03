package coderun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Coderun #1
 */
public class SynonymDictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> kTv = new HashMap<>();
        Map<String, String> vTk = new HashMap<>();

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] pair = scanner.nextLine().split(" ");
            String word = pair[0];
            String synonym = pair[1];

            kTv.put(word, synonym);
            kTv.put(synonym, word);
        }
        String word = scanner.nextLine();

        if (kTv.containsKey(word)) {
            System.out.println(kTv.get(word));
        } else {
            System.out.println(vTk.get(word));
        }
    }
}
