package com;

import java.util.ArrayList;  /* se implementan los arrayList */

/* Implementación de Stack pero usando ArrayList*/
public class ArrayListStack<T> extends AbstractStack<T> {
    private ArrayList<T> stack = new ArrayList<>(); /*en este caso  Usamos un ArrayList como almacenamiento interno*/ 

    @Override
    public void push(T item) {
        stack.add(item);  /*se  Agrega el elemento al final en este caso  de la lista*/
    }

    @Override
    public T pop() {
        return stack.isEmpty() ? null : stack.remove(stack.size() - 1); /* se retira el ultimo elemento, recordar que ? significa que si es true entonces  devuelve null, pero si false entonces stack.remove(stack.size() - 1)*/  
    }

    @Override
    public T peek() {   /*el ? es una manera mas corta de escribir  if-else */
        return stack.isEmpty() ? null : stack.get(stack.size() - 1);  /* retornamos el último sin eliminarlo a diferencia de pop que si lo elimina*/ 
    }

    @Override
    public int size() {
        return stack.size();  /*se retorna el tamaño de la pila */ 
    }
}
