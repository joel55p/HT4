import java.util.*;
import java.util.Stack;


public class InfixToPostfix {
    
    // Metodo para convertir una expresion en formato infix a postfix
    public static String infixToPostfix(String expression) {

        // Variable que guardara la expresion en postfix
        StringBuilder result = new StringBuilder(); 

        // Stack que guardara los operadores y parentesis
        Stack<Character> stack = new Stack<>(); 
        
        // Usaremos un Hashmap para definir el orden de PEMDAS de cada operando
        Map<Character, Integer> pemdas = new HashMap<>();

        // Sumar y restar tienen nivel PEMDAS de 1
        pemdas.put('+', 1); 
        pemdas.put('-', 1); 

        // Multiplicar y dividir tienen nivel PEMDAS de 2
        pemdas.put('*', 2); 
        pemdas.put('/', 2); 

        // Exponente tienen nivel PEMDAS de 1
        pemdas.put('^', 3); 

        // Iterar a traves de la lista de la expresion postfix
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // Si el char es un digito agregarlo al result
            if (Character.isDigit(c)) {
                
                // Manejar numeros con mas de un digito
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    result.append(expression.charAt(i));
                    i++;
                }

                // Agregar un espacio despues de cada numero
                result.append(" "); 

                // Ajustar de regreso el index despues del while loop de arriba
                i--; 
            } 

            // Si el char es un parentesis abierto, agregarlo al stack de operadores
            else if (c == '(') {
                stack.push(c);
            } 

            /*  Si el char es un parentesis cerrado, buscar el parentesis abierto en el stack usando peek
            *   Si previo a encontrar el parentesis encontramos un operando, 
            *   lo sacamos del stack usando pop y lo agregamos a la expresion.
            */
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop(); 
            } 

             // Si el char es un operando, usamos pemdas para procesarlo
            else if (pemdas.containsKey(c)) {

                // Revisamos en el stack si hay algun operando que segun PEMDAS vaya antes
                while (!stack.isEmpty() && pemdas.getOrDefault(stack.peek(), 0) >= pemdas.get(c)) {

                    // Usamos pop si encontramos alguno y lo agregamos al result
                    result.append(stack.pop()).append(" "); 
                }

                // Agregamos el operador original al stack
                stack.push(c); 
            }
        }
        
        // Usando pop, sacamos los operandos restantes del stack y los agregamos al result
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        
        // Se regresa el string en formato postfix
        return result.toString().trim(); 
    }
}