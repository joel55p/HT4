package com;


// Implementacion de List como una Lista Simplemente Encadenada
public class SingleLinkedList<T> extends AbstractList<T> {
    private Node<T> head; // Creamos la lista con su nodo de cabeza

    private static class Node<T> { // Informaciond de cada nodo
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
        if (head == null) System.out.println("La lista esta vacia");;
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
