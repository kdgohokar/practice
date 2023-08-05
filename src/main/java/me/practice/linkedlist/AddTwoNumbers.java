package me.practice.linkedlist;

import java.util.List;

/***
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int v1 = l1 != null  ? l1.val : 0;
            int v2 = l2 != null  ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);

            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(1);

        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode ans = obj.addTwoNumbers(l1, l2);

        /***
         * 2 -> 4 -> 3
         * 5 -> 6 -> 4 -> 1
         * ----------------
         * 7 -> 0 -> 8 -> 1
         *
         *       3 4 2
         *   + 1 4 6 5
         *    --------
         *     1 8 0 7
         */

        LinkedListOperations.printList(l1);
        LinkedListOperations.printList(l2);
        LinkedListOperations.printList(ans);
    }
}
