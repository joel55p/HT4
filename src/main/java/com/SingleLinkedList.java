package com;

import java.util.List;
import java.util.LinkedList;

// Implementación de List como una Lista Simplemente Encadenada
public class SingleLinkedList<T> extends LinkedList<T> implements List<T> {
    private Node<T> head; // Creamos la lista con su nodo de cabeza
    private int size = 0; // Definimos la variable size

    private static class Node<T> { // Información de cada nodo
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void push(T data) { // Agregar un elemento a la lista y convertirlo en la nueva cabeza
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() { // Eliminar el primer elemento de la lista
        if (head == null) {
            System.out.println("La lista esta vacia");
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T peek() { // Ver el siguiente elemento de la lista sin quitarlo
        if (head == null) return null;
        return head.data;
    }
}