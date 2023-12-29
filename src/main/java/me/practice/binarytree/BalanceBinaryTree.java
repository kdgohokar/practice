package me.practice.binarytree;

import com.sun.source.tree.Tree;

public class BalanceBinaryTree {

    public boolean isBalanced(TreeNode root) {
        NodeBalanceHeightResult result = maxDepth(root);
        return result.isBalanced;
    }

    private NodeBalanceHeightResult maxDepth(TreeNode root) {
        if (null == root)
            return new NodeBalanceHeightResult(true, 0);

        NodeBalanceHeightResult left = maxDepth(root.left);
        NodeBalanceHeightResult right = maxDepth(root.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1);

        int maxDepth = 1 + Math.max(left.height, right.height);

        return new NodeBalanceHeightResult(isBalanced, maxDepth);
    }

    static class NodeBalanceHeightResult {
        boolean isBalanced;
        int height;

        NodeBalanceHeightResult(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new BalanceBinaryTree().isBalanced(root));
    }
}
