package me.practice.linkedlist;

import javax.swing.plaf.ListUI;

public class LinkedListOperations {

    public static ListNode appendNode(int val, ListNode list) {
        ListNode root = list;
        if (null == root) {
            root = new ListNode(val);
            return root;
        }

        while (list.next != null) {
            list = list.next;
        }

        list.next = new ListNode(val);
        return root;
    }

    public static ListNode insert(int val, ListNode list) {
        ListNode root = list;
        if (null == root) {
            root = new ListNode(val);
            return root;
        }

        ListNode head = new ListNode(val);
        head.next = list;
        return head;
    }

    public static ListNode insertAtGivenNode(int val, ListNode prevNode) {
        if (prevNode == null) {
            System.out.println("Given node cannot be null");
            return null;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        return prevNode;
    }

    public static void printList(ListNode list) {
        System.out.println("\n:: LinkedList ::");
        while (null != list) {
            System.out.print(list.val + " -> ");
            if (list.next == null) {
                System.out.print("null");
            }
            list = list.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        printList(list);
        list = appendNode(6, list);
        printList(list);
        list = insert(0, list);
        printList(list);
        ListNode newList = new ListNode(10);
        ListNode inputNode = newList.next = new ListNode(20);
        newList.next.next = new ListNode(40);
        printList(newList);
        ListNode listNode = insertAtGivenNode(30, inputNode);
        printList(newList);
    }
}
