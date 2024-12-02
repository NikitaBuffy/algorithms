package yandexalgo6.week4.E;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E {
    static List<List<Integer>> tree;
    static int[] subtreeSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();
        tree = new ArrayList<>();
        subtreeSize = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1, -1);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            builder.append(subtreeSize[i]).append(" ");
        }
        System.out.println(builder.toString().trim());
    }

    private static void dfs(int node, int parent) {
        subtreeSize[node] = 1;
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
            }
        }
    }
}