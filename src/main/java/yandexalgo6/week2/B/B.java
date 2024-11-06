package yandexalgo6.week2.B;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        int counter = 0;
        int left = 0, sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}