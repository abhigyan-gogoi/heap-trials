package com.ziroh.common;

public class Node<T extends Comparable<T>> {
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
