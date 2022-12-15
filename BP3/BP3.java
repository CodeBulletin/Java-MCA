// Problem Statement

// Define a class named VowelFilter which contains a static method named filterVowel().
// This method receives a character array as argument and returns another array which contains only the non-vowel characters of the argument array.

import java.util.Scanner;

public class BP3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String string = scanner.nextLine();

        System.out.println("String without vowel: " + VowelFilter.filterVowel(string));

        scanner.close();
    }
}

class VowelFilter {
    public static String filterVowel(String array) {

        String newStr = "";
        for(int i = 0; i < array.length(); i++) {
            char c = array.charAt(i);
            if (c != 'a' && c != 'A' &&
                c != 'e' && c != 'E' &&
                c != 'i' && c != 'I' &&
                c != 'o' && c != 'O' &&
                c != 'u' && c != 'U') {
                    newStr += c;
            }
        }
        return newStr;
    }
}