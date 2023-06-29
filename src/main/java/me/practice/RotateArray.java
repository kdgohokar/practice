package me.practice;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            temp[i] = nums[j];
            j++;
        }
        for (int i = 0; i < k; i++) {
            temp[i] = nums[j];
            j++;
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public void rotateOptimize(int[] nums, int k) {
        // 6 5 4 3 2 1
        // 4 5 6 1 2 1
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int  i = start, j = end;
        while (i <= j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
