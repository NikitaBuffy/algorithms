package coderun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Coderun #4
 */
public class LargestProductTwoNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] strNumbers = line.split(" ");

        List<Integer> nums = new ArrayList<>();
        for (String str : strNumbers) {
            nums.add(Integer.parseInt(str));
        }

        Collections.sort(nums);

        int size = nums.size();

        int maxProduct = nums.get(size - 1) * nums.get(size - 2);
        int minProduct = nums.get(0) * nums.get(1);

        if (maxProduct > minProduct) {
            System.out.println(nums.get(size - 2) + " " + nums.get(size - 1));
        } else {
            System.out.println(nums.get(0) + " " + nums.get(1));
        }
    }
}
