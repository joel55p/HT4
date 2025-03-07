package com;

import java.util.List;
import java.util.LinkedList;

// Implementación de List como una Lista Doblemente Encadenada
public class DoubleLinkedList<T> extends LinkedList<T> implements List<T> {
    private Node<T> head, tail; // Creamos la lista con su nodo de cabeza y cola
    private int size = 0; // Definimos la variable size

    private static class Node<T> { // Propiedades de los nodos
        T data;
        Node<T> next, prev; // Next: siguiente nodo, Prev: nodo previo
        Node(T data) { this.data = data; }
    }

    public void push(T data) { /// Agregar un elemento a la lista y convertirlo en la nueva cabeza
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else { // Asegurarse que la lista mantiene su estructura
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public T pop() { // Eliminar el primer elemento de la lista
        if (head == null) {
            System.out.println("La lista esta vacia");
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    public T peek() { // Ver el siguiente elemento de la lista sin quitarlo
        if (head == null) return null;
        return head.data;
    }
}
