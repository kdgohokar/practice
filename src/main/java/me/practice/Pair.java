package me.practice;

public class Pair<T, L> {
    private T key;
    private L value;

    public Pair(T key, L value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public L getValue() {
        return this.value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(L value) {
        this.value = value;
    }
}