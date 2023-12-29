package me.practice.binarytree;

import com.sun.source.tree.Tree;
import me.practice.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int maxDepthDFSIterative(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        int res = 0;
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            if (node != null) {
                res = Math.max(res, depth);
                if (node.left != null) {
                    stack.push(new Pair<>(node.left, depth + 1));
                }
                if (node.right != null) {
                    stack.push(new Pair<>(node.right, depth + 1));
                }
            }
        }
        return res;
    }

    public int maxDepthBFSLevelOrderQueue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int level = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level += 1;
        }
        return level;
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree obj = new MaxDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int maxDepth = obj.maxDepth(root);
        System.out.println(maxDepth);

        int maxDepthIterative = obj.maxDepthDFSIterative(root);
        System.out.println(maxDepthIterative);

        int maxDepthBFSLevelOrderQueue = obj.maxDepthBFSLevelOrderQueue(root);
        System.out.println(maxDepthBFSLevelOrderQueue);
    }
}
