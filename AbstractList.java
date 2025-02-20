public abstract class AbstractList<T> implements List<T> {
    protected int size = 0;

    @Override
    public boolean isEmpty() { // Revisar si la lista esta vacia
        return size == 0;
    }

    @Override
    public int size() { // Revisar el tamaño de la lista
        return size;
    }
}
