package com;

public abstract class AbstractList<T> implements List<T> {
    protected int size = 0;

    public boolean isEmpty() { // Revisar si la lista esta vacia
        return size == 0;
    }

    public int size() { // Revisar el tamaño de la lista
        return size;
    }

    public T set(int index, T element) {
        throw new UnsupportedOperationException("set() not supported");
    }
}
