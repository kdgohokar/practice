package me.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {

    static class BinaryTree {
        int data;
        BinaryTree left, right;

        BinaryTree(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void printPreOrder(BinaryTree node) {
        if (null == node) {
            return;
        }
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void printInOrder(BinaryTree node) {
        if (null == node) {
            return;
        }
        printPreOrder(node.left);
        System.out.print(node.data + " ");
        printPreOrder(node.right);
    }

    public static void printPostOrder(BinaryTree node) {
        if (null == node) {
            return;
        }
        printPreOrder(node.left);
        printPreOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void printLevelOrderIterative(BinaryTree root) {
        if (root == null) return;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public static void levelOrderRecursive(BinaryTree root) {
        if (root == null)
            return;

        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    private static void printCurrentLevel(BinaryTree root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    public static int getHeight(BinaryTree root) {
        if (null == root) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public static int getHeightIterative(BinaryTree root) {

        if (root == null)
            return 0;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        int height = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {
                BinaryTree node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        BinaryTree node = new BinaryTree(10);
        node.left = new BinaryTree(8);
        node.right = new BinaryTree(2);
        node.left.left = new BinaryTree(3);
        node.left.right = new BinaryTree(5);
        node.right.left = new BinaryTree(2);

        printPreOrder(node);
        System.out.println();
        printInOrder(node);
        System.out.println();
        printPostOrder(node);

        System.out.println("Height = " + getHeight(node));
        System.out.println("Height Iterative = " + getHeightIterative(null));

        System.out.println("***** Level Order Traversal *****");
        System.out.println("Recursive: ");
        levelOrderRecursive(node);
        System.out.println("\nIterative: ");
        printLevelOrderIterative(node);
    }
}
