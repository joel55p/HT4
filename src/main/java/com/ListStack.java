package com;


/*Implementación de Stack usando una Lista (puede ser simplemente o doblemente encadenada) */ 
import java.util.List;
public class ListStack<T> extends AbstractStack<T> {
    private List<T> stack;  /*en este caso  Usamos una lista como almacenamiento interno*/ 

    /*Constructor que recibe una implementación de Lista */ 
    public ListStack(List<T> stack) {
        this.stack = stack;
    }

    @Override
    public void push(T item) {
        stack.add(item); /*se  Agrega el elemento al final en este caso  de la lista*/
    }

    @Override
    public T pop() {
        return stack.isEmpty() ? null: stack.remove(stack.size()-1) ;  /*se retira el ultimo elemento */
    }

    @Override
    public T peek() {   /*hay que recordar que en una lista no se puede hacer stack.LastElement ya que se tiene que recorrer toda la lista */
        if (stack.isEmpty()) return null;
        T top = this.pop();  /*se remueve el elemento superior */ 
        this.push(top);  /*se vuelve a insertar */
        return top;
    }

    @Override
    public int size() {
        return stack.size();  /*como tal tamaño de pila */
    }
}

    

