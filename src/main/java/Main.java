package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Importar las clases necesarias
import com.Calculator;
import com.VectorStack;
import com.ArrayListStack;
import com.ListStack;
import com.DoubleLinkedList;
import com.SingleLinkedList;
import com.InfixToPostfix;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la instancia única de Calculator
        Calculator calculator = Calculator.getInstance();

        // Preguntar al usuario qué tipo de stack quiere usar
        System.out.println("Seleccione el tipo de Stack que desea usar:");
        System.out.println("1. VectorStack");
        System.out.println("2. ArrayListStack");
        System.out.println("3. ListStack");
        System.out.println("4. DoubleLinkedList");
        System.out.println("5. SingleLinkedList");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Stack<Integer> stack = null;

        if (choice == 1) {
            stack = new VectorStack<>();
        } else if (choice == 2) {
            stack = new ArrayListStack<>();
        } else if (choice == 3) {
            System.out.println("Seleccione el tipo de List:");
            System.out.println("1. ArrayList");

            int listChoice = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (listChoice == 1) {
                List<Integer> list = new ArrayList<>();
                stack = new ListStack<>(list);
            }
        } else if (choice == 4) {
            stack = new ListStack<>(new DoubleLinkedList<>());
        } else if (choice == 5) {
            stack = new ListStack<>(new SingleLinkedList<>());
        } else {
            System.out.println("Opción no válida. Saliendo...");
            return;
        }

        // Leer la operación desde un archivo
        System.out.println("Ingrese la ruta del archivo con la operación infix:");
        String filePath = scanner.nextLine();

        try {
            String infixExpression = new String(Files.readAllBytes(Paths.get(filePath)));
            String postfixExpression = InfixToPostfix.infixToPostfix(infixExpression);

            // Evaluar la expresión postfix con la calculadora
            calculator.evaluate(postfixExpression);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
