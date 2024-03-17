package me.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class KClosestPoint {

    static class Points {
        double val;
        int[] xy;

        Points(int[] xy) {
            this.xy = xy;
            this.val = (this.xy[0] * this.xy[0]) + (this.xy[1] * this.xy[1]);
        }
    }


    public int[][] kClosest(int[][] points, int k) {
        //Queue<Points> minHeap = new PriorityQueue<>(Comparator.comparingDouble(p -> p.val));
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] + p1[1] * p1[1]);

        //iterate over the array
        for (int[] n : points) {
            //first add the integer to heap
            heap.add(n);
            //if size of the heap is greater than k
            if (heap.size() > k) {
                //remove the root element (lowest of all)
                heap.poll();
            }
        }
        //finally heap has k largest elements left with root as the kth largest element

        return heap.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        KClosestPoint o = new KClosestPoint();
        int[][] arr = {{1, 3}, {-2, 2}};
        int[][] res = o.kClosest(arr, 1);
        Stream.of(res).forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
