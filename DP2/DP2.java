import java.util.LinkedList;
import java.util.Scanner;

import Tokenizer.*;
import Parser.*;
import Exceptions.Exceptions;

public class DP2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        int i = -1;
        boolean loop = true;
        while (loop) {
            i += 1;
            try {
                System.out.print("I " + i + "> ");
                String line = sc.nextLine();
                if (line.trim().toLowerCase().equals("exit"))
                    break;
                if (line == null || line.trim().isEmpty())
                    continue;
                double out = calculator.calculate(line);
                System.out.printf("O %d> %s \n", i, out);
            } catch (Exceptions.TokenException e) {
                System.err.println("Token Error: " + e.getMessage());
            } catch (Exceptions.ParserException e) {
                System.err.println("Parser Error: " + e.getMessage());
            } catch (Exceptions.EvaluationException e) {
                System.err.println("Evaluationn Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println(
                    e.getClass().getSimpleName() + ": " + e.getMessage()
                );
            }
        }
        sc.close();
    }
}

class Calculator {
    Tokenizer tokenizer = Tokenizer.InitTokenizer();
    Parser parser = new Parser();

    public double calculate(String input) throws Exception {
        tokenizer.clear();
        LinkedList<Token> tokens = tokenizer.tokenize(input).getTokens();
        SyntaxNode node = parser.parse(tokens);
        return node.getValue();
    }
}