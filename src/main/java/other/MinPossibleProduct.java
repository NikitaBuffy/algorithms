package other;

public class MinPossibleProduct {
    public static void main(String[] args) {
        System.out.println(minPossibleProduct(new int[]{2,-6,-4,10,-5})); // -60
        System.out.println(minPossibleProduct(new int[]{3, 10, 1, 7, 2})); // 2
    }

    public static int minPossibleProduct(int[] nums) {
        int a = nums[0];
        int b = nums[1];

        // min1 — самый минимальный элемент в массиве
        // min2 — второй минимальный элемент
        int min1 = Math.min(a, b);
        int min2 = Math.max(a, b);

        // max1 — самый максимальный элемент в массиве
        // max2 — второй максимальный элемент
        int max1 = Math.max(a, b);
        int max2 = Math.min(a, b);

        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];

            // Обновляем минимумы
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            // Обновляем максимумы
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        // Выбираем наименьшее произведение из трёх возможных комбинаций
        // Заметка: max1 * max2 даст минимальный результат, когда
        // в массиве только отрицательные числа
        return Math.min(Math.min(min1 * min2, min1 * max1), max1 * max2);
    }
}
