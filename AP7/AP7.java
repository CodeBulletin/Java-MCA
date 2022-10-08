package AP7;

import java.util.Scanner;

// Problem Statement
/*
A java standalone application reads in a sentence from the user and prints it 
out with each word reversed, but with the words and punctuation in the original order.
*/ 

public class AP7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your sentence: ");
        String[] words = scanner.nextLine().split(" ");
        scanner.close();

        for (String word: words) {
            StringBuilder builder = new StringBuilder();
            builder.append(word);
            builder.reverse();
            builder.append(" ");
            System.out.print(builder);
        }
    }
}
