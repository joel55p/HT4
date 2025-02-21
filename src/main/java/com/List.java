package com;
/* Interfaz genérica para una Pila (List)*/ 
public interface List<T> {
    public void push(T data); // Agregar un elemento a la lista
    public T pop(); // Eliminar el primer elemento de la lista
    public T peek(); // Ver el siguiente elemento de la lista sin quitarlo
    public boolean isEmpty(); // Revisar si la lista esta vacia
    public int size(); // Revisar el tamaño de la lista
}
