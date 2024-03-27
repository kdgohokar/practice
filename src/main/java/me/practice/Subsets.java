package me.practice;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tempList = new ArrayList<>(res.get(i));
                tempList.add(num);
                res.add(tempList);
            }
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        List<Integer> tempList = new ArrayList<>(curr); // copy list as curr getting modified
        res.add(tempList);
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }



    public static void main(String[] args) {
        Subsets obj = new Subsets();
        List<List<Integer>> subsets = obj.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

        List<List<Integer>> subsetsIterative = obj.subsetsIterative(new int[]{1, 2, 3});
        System.out.println(subsetsIterative);
    }
}
