package me.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;

        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node left;
    private final Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(this.capacity);
        this.left = this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.prev = prev;
        node.next = next;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > this.capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
