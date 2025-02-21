public class StackSingleton {
    private static StackSingleton instance;
    private Stack<Integer> stack;

    private StackSingleton() {
        stack = new VectorStack<>(); // Se puede cambiar la implementación aquí
    }

    public static StackSingleton getInstance() {
        if (instance == null) {
            instance = new StackSingleton();
        }
        return instance;
    }

    public Stack<Integer> getStack() {
        return stack;
    }
}
