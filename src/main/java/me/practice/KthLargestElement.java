package me.practice;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(n);
            } else if (!minHeap.isEmpty() && n > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(n);
            }
        }
        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }

    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        //int[] arr = {3,2,1,5,6,4};
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = obj.findKthLargest(arr, k);
        System.out.println(res);
    }
}
