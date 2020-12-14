package com.company;

public class Node<T> {
    private Node<T> previous, next;
    private T data;
    public Node(T data)
    {
        this.data = data;
    }
    public Node<T> getPrevious() {
        return previous;
    }
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}