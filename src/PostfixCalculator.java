import java.io.*;
import java.util.*;

public class PostfixCalculator {
    public static void main(String[] args) throws IOException {
        // Wczytanie wyrażenia z pliku
        BufferedReader br = new BufferedReader(new FileReader("wyrazenie.txt"));
        String expression = br.readLine();
        br.close();

        // Podział wyrażenia na poszczególne elementy
        String[] tokens = expression.split(" ");

        // Stos na przechowywanie liczb
        Stack<Integer> stack = new Stack<>();

        // Przetwarzanie wyrażenia
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }

        // Wyświetlenie wyniku
        int result = stack.pop();
        System.out.println("Wyrażenie: " + expression);
        System.out.println("Wynik = " + result);
    }
}
