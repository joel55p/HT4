// Implementacion de List como una Lista Doblemente Encadenada
public class DoubleLinkedList<T> extends AbstractList<T> {
    private Node<T> head, tail; // Creamos la lista con su nodo de cabeza y cola

    private static class Node<T> { // Propiedades de los nodos
        T data;
        Node<T> next, prev; // Next: siguiente nodo, Prev: nodo previo
        Node(T data) { this.data = data; }
    }

    @Override
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

    @Override
    public T pop() { // Eliminar el primer elemento de la lista
        if (head == null) System.out.println("La lista esta vacia");
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    @Override
    public T peek() { // Ver el siguiente elemento de la lista sin quitarlo
        if (head == null) return null;
        return head.data;
    }
}
