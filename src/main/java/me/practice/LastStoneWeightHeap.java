package me.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeightHeap {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            Integer val1 = maxHeap.poll();
            Integer val2 = maxHeap.poll();
            if (val1 != val2) {
                int bal = val1 - val2;
                maxHeap.add(bal);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeightHeap obj = new LastStoneWeightHeap();
        int[] arr = { 2, 7, 4, 1, 8, 1 };
        int res = obj.lastStoneWeight(arr);
        System.out.println(res);
    }

}