public class StackFactory {
    public static <T> Stack<T> createStack(String type) {
        switch (type.toLowerCase()) {
            case "vector":
                return new VectorStack<>();
            case "arraylist":
                return new ArrayListStack<>(); // Suponiendo que hay una implementación con ArrayList
            default:
                throw new IllegalArgumentException("Tipo de pila no soportado");
        }
    }
}
