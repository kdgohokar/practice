package me.practice.linkedlist;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 3};
        FindDuplicate obj = new FindDuplicate();
        int res = obj.findDuplicate(nums);
        System.out.println(res);
    }
}
