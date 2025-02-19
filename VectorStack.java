import java.util.Vector; /*se importa el vector */

/*Implementación de Stack usando Vector */ 
public class VectorStack<T> extends AbstractStack<T> {
    private Vector<T> stack = new Vector<>();  /*en este caso  Usamos un vector como almacenamiento interno*/ 

    @Override
    public void push(T item) {
        stack.add(item);  /*se agregamos elemento al final */ 
    }

    @Override
    public T pop() {
        return stack.isEmpty() ? null : stack.remove(stack.size() - 1); /*se retira el ultimo elemento */
    }

    @Override
    public T peek() {
        return stack.isEmpty() ? null : stack.lastElement();  /*Ahora el ultimo sin eliminar */
    }

    @Override
    public int size() {
        return stack.size();  /*como tal tamaño de pila */
    }
}
