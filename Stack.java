/* Interfaz genérica para una Pila (Stack)*/ 
public interface Stack<T> {
    public void push(T item);  /*Agregar un elemento a la pila */ 
    public T pop();  /*Para eliminar y obtener  el elemento en la cima de la pila */ 
    public T peek(); /* Para ver el elemento en la cima sin retirarlo*/ 
    public boolean isEmpty();  /* para ver si la pila esta vacia*/ 
}

