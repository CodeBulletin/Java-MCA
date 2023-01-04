// Problem Statement

// A word that reads the same backward as forward is called a palindrome,
// e.g., "mom", "dad", "racecar", "madam", and "Radar" (case-insensitive).
// Create a class called TestPalindromicWord, that prompts user for a word and
// prints ""xxx" is|is not a palindrome".

import java.util.Scanner;

public class CP2 {
    public static void main(String[] args) {
        TestPalindromicWord.checkPlaindrome();
    }
}

class TestPalindromicWord {
    public static void checkPlaindrome() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = sc.next();
        sc.close();
        
        boolean isPlaindrome = true;
        for(int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                isPlaindrome = false;
                break;
            }
        }

        System.out.println(
            "\"" + word + "\" is " +
            (isPlaindrome ? "" : "not ") +
            "a palindrome"
        );
    }
}