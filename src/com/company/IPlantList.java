package com.company;

public interface IPlantList<T> {
    void add(T object);
    void clear();
    boolean remove(T object);
    T[] toArray();
    int size();
    boolean contains(T object);
}
