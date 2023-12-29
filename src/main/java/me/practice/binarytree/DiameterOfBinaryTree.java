package me.practice.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        int lheight = maxDepth(root.left);
        int rheight = maxDepth(root.right);

        max = Math.max(max, (lheight + rheight));
        return Math.max(lheight, rheight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
}
