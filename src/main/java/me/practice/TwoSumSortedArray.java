package me.practice;

public class TwoSumSortedArray {

    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum < target) {
                start++;
            } else if (currentSum > target) {
                end--;
            } else {
                return new int[] {start+1, end+1};
            }
        }
        return new int[0];
    }
}
