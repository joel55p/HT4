package com;

/* Clase abstracta que implementa Stack osea el contrato, con métodos comunes para todas las pilas */ 
public abstract class AbstractStack<T> implements Stack<T> {
    @Override /*polimorfismo por interfaz */
    public boolean isEmpty() {
        return size() == 0;  /* Si el tamaño es 0, entonce la pila como tal esta vacia */
    }

    public abstract int size();  /*va a ser el metodo abstracto para obtener el tamaño de la pila */ 
}
