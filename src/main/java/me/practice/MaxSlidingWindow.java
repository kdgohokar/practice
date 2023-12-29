package me.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            // Get the left index of window by right - windowSize + 1
            int leftIndex = (i - k + 1);

            // if left of window is greater than first deque element
            // then remove the element from deque as it is no longer in window
            if (!queue.isEmpty() && leftIndex > queue.peekFirst()) {
                queue.pollFirst();
            }

            // if current element is greater than last element in queue
            // then poll all the elements until this consition satisfies.
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }

            // Insert current element into the queue. We are inserting index.
            queue.offer(i);

            // if current window size is equals to k then add into output.
            // as i is starting from 0 so we have to minus 1 from k.
            // We will be inserting greatest element from queue into the output.
            // queue will have first element as greatest always.
            if (i >= k - 1) {
                output[j++] = nums[queue.peekFirst()];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = {7, 2, 4};
        MaxSlidingWindow obj = new MaxSlidingWindow();
        int[] ans = obj.maxSlidingWindow(input, 2);
        System.out.println(Arrays.toString(ans));
    }
}
