package me.practice.linkedlist;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {

    RandomNodeList head;

    public static void main(String[] args) {
        DeepCopy obj = new DeepCopy();
        obj.head = new RandomNodeList(7);
        obj.head.next = new RandomNodeList(13);
        obj.head.next.next = new RandomNodeList(11);
        obj.head.next.next.next = new RandomNodeList(10);
        obj.head.next.next.next.next = new RandomNodeList(1);

        obj.head.random = null;
        obj.head.next.random = obj.head;
        obj.head.next.next.random = obj.head.next.next.next.next;
        obj.head.next.next.next.random = obj.head.next.next;
        obj.head.next.next.next.next.random = obj.head;

        obj.print();

        RandomNodeList tmp = obj.head;
        obj.head = obj.copyRandomList(tmp);
        obj.print();
    }

    public void print() {
        RandomNodeList tmp = head;
        System.out.println();
        while (tmp != null) {
            var randomVal = null != tmp.random ? tmp.random.val : "null";
            System.out.print("[" + tmp.val + "," + randomVal + "]" + " -> ");
            if (tmp.next == null) {
                System.out.print("null");
            }
            tmp = tmp.next;
        }
    }

    public RandomNodeList copyRandomList(RandomNodeList head) {
        Map<RandomNodeList, RandomNodeList> oldToCopy = new HashMap<>();
        RandomNodeList current = head;
        while (current != null) {
            RandomNodeList copy = new RandomNodeList(current.val);
            oldToCopy.put(current, copy);
            current = current.next;
        }

        current = head;
        while (current != null) {
            RandomNodeList copy = oldToCopy.get(current);
            copy.next = oldToCopy.get(current.next);
            copy.random = oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }

}

class RandomNodeList {
    int val;
    RandomNodeList next;
    RandomNodeList random;

    RandomNodeList() {
    }

    RandomNodeList(int val) {
        this.val = val;
        next = random = null;
    }

    RandomNodeList(int val, RandomNodeList next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }

    RandomNodeList(int val, RandomNodeList next, RandomNodeList random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
