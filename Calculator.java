package com;

import java.util.Stack;

public class Calculator {

    private static Calculator instance; // Instancia única para Singleton

    // Constructor privado
    private Calculator() {}

    // Método para obtener la instancia única
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public void evaluate(String operation) {
        Stack<Integer> stack = new Stack<>();
        boolean success = true;

        for (int i = 0; i < operation.length(); i++) {
            char placeholder = operation.charAt(i);

            if (Character.isDigit(placeholder)) {
                int number = Character.getNumericValue(placeholder);

                while ((i + 1 < operation.length()) && Character.isDigit(operation.charAt(i + 1))) {
                    i++;
                    number = number * 10 + Character.getNumericValue(operation.charAt(i));
                }

                stack.push(number);
            } else if ("+-*/%".indexOf(placeholder) != -1) {
                if (stack.size() < 2) {
                    System.out.println("Error: No hay suficientes operandos.");
                    success = false;
                    break;
                }

                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (placeholder) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/':
                        if (b == 0) {
                            System.out.println("Error: División por cero.");
                            success = false;
                        } else {
                            result = a / b;
                        }
                        break;
                    case '%': result = a % b; break;
                    default:
                        System.out.println("Error: Operador desconocido.");
                        success = false;
                }

                if (!success) break;
                stack.push(result);
            } else if (placeholder != ' ') {
                System.out.println("Error: Caracter inválido detectado -> '" + placeholder + "'");
                success = false;
                break;
            }
        }

        if (success) {
            if (stack.size() == 1) {
                System.out.println("Resultado: " + stack.pop());
            } else {
                System.out.println("Error: Quedaron demasiados operandos en la pila.");
            }
        }
    }
}


