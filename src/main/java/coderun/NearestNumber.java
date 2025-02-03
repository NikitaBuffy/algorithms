package coderun;

import java.util.Scanner;

/**
 * Coderun #2
 */
public class NearestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        int minDistance = Integer.MAX_VALUE;
        int closNum = nums[0];

        for (int num : nums) {
            int distance = Math.abs(x - num);

            if (distance < minDistance) {
                minDistance = distance;
                closNum = num;
            } else if (distance == minDistance) {
                if (num < closNum) {
                    closNum = num;
                }
            }
        }

        System.out.println(closNum);
    }
}
