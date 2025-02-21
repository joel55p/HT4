import java.util.Stack;
import java.util.*;


/**
 * La clase Calculator realiza evaluaciones de operaciones aritméticas postfix 
 * utilizando nuestro StackVector.
 * 
 * @author Fabian Prado
 * @version 1.0
 */
public class Calculator {

    /**
     * Evalúa una operación aritmética dada en forma de cadena. La operación
     * puede contener números y los operadores +, -, *, /, %.
     * 
     * @param operation La cadena que representa la operación aritmética.
     */
    public void evaluate(String operation) {
        // Creación de la instancia de la pila
        Stack<Integer> stack = new Stack<>();

        // Creación de una variable booleana para asegurar que la operación se realizó correctamente
        boolean success = true;

        for (int i = 0; i < operation.length(); i++) {
            char placeholder = operation.charAt(i);

            // Verificar si el carácter es un número y si tiene más de un dígito
            if (Character.isDigit(placeholder)) {
                int number = Character.getNumericValue(placeholder);

                while ((i + 1 < operation.length()) && Character.isDigit(operation.charAt(i + 1))) {
                    i++;
                    number = number * 10 + Character.getNumericValue(operation.charAt(i));
                }

                stack.push(number);
            } 
            // Verificar operadores válidos
            else if (placeholder == '+' || placeholder == '-' || placeholder == '*' || 
                     placeholder == '/' || placeholder == '%') {

                // Verificar que haya suficientes números para operar
                if (stack.size() < 2) {
                    System.out.println("Not enough numbers for operation");
                    success = false;
                    break;
                }

                // Obtener ambos números
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                // Seleccionar la operación a realizar
                switch (placeholder) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        if (b == 0) {
                            System.out.println("Cannot divide by 0");
                            success = false;
                            break;
                        } else {
                            result = a / b;
                        }
                        break;
                    case '%':
                        result = a % b;
                        break;
                }
                if (!success) break;
                stack.push(result);
            } 
            // Manejar caracteres no válidos, ignorando espacios
            else if (placeholder != ' ') {
                success = false;
                System.out.println("The string contains an invalid character");
                break;
            }
        }

        if (success) {
            // Asegurarse de que solo quede un número en la pila
            if (stack.size() == 1) {
                System.out.println("Result: " + stack.pop());
            } else {
                System.out.println("Too many numbers left in the stack");
            }
        }
    }
}
