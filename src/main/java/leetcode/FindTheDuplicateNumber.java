package leetcode;

/**
 * LeetCode #287
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(findDuplicate(new int[]{3,1,3,4,2})); // 3
        System.out.println(findDuplicate(new int[]{3,3,3,3,3})); // 3
    }

    // O(N) и O(1)
    // Решение через алгоритм Флойда («черепаха и заяц») по аналогии с определением зациклинности связного списка
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int finder = nums[0];

        while (finder != slow) {
            finder = nums[finder];
            slow = nums[slow];
        }

        return finder;
    }
}
