package yandexalgo6.week1.C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Оптимизированное решение.
 * Ключевая идея:
 * Компрессия матрицы. Сначала удалим все одинаковые строки, затем перевернем матрицу и повторим для столбцов до тех пор, пока
 * все прямоугольники не станут единичной ширины и высоты. После чего их можно сравнить с константными образцами.
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, char[][]> references = Map.of(
                "I", new char[][] {
                        {'#'}
                },
                "L", new char[][] {
                        {'#', '.'},
                        {'#', '#'}
                },
                "C", new char[][] {
                        {'#', '#'},
                        {'#', '.'},
                        {'#', '#'}
                },
                "O", new char[][] {
                        {'#', '#', '#'},
                        {'#', '.', '#'},
                        {'#', '#', '#'}
                },
                "P", new char[][] {
                        {'#', '#', '#'},
                        {'#', '.', '#'},
                        {'#', '#', '#'},
                        {'#', '.', '.'}
                },
                "H", new char[][] {
                        {'#', '.', '#'},
                        {'#', '#', '#'},
                        {'#', '.', '#'},
                }
        );

        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        grid = compress(grid);
        grid = revert(grid);
        grid = compress(grid);
        grid = revert(grid);

        String result = "X";

        for (Map.Entry<String, char[][]> entry : references.entrySet()) {
            char[][] value = entry.getValue();
            if (Arrays.deepEquals(grid, value)) {
                result = entry.getKey();
                break;
            }
        }

        System.out.println(result);
    }

    private static char[][] compress(char[][] grid) {
        ArrayList<char[]> res = new ArrayList<>();
        res.add(grid[0]);

        for (int i = 0; i < grid.length; i++) {
            char[] curr = grid[i];

            if ((i + 1 < grid.length && !Arrays.equals(curr, grid[i + 1]))
                    || (i + 1 >= grid.length)) {
                if (!Arrays.equals(curr, res.get(res.size() - 1))) {
                    res.add(curr);
                }
            }

            if (res.size() > 1 && isAllDots(res.get(0))) {
                res.remove(0);
            }

        }
        if (res.size() > 1 && isAllDots(res.get(res.size() - 1))) {
            res.remove(res.size() - 1);
        }

        return res.toArray(new char[res.size()][]);
    }

    private static boolean isAllDots(char[] row) {
        for (char c : row) {
            if (c != '.') {
                return false;
            }
        }
        return true;
    }

    private static char[][] revert(char[][] grid) {
        char[][] res = new char[grid[0].length][grid.length];

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                res[x][y] = grid[y][x];
            }
        }

        return res;
    }
}