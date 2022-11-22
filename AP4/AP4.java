package AP4;

// problem statememtn

/*
Construct a character counter that inputs a piece of text that is analyzed character by character to determine the vowels, spaces and letters used. Fill in 
the code that computes the number of spaces, vowels, and consonants.
public class AP4 {
    public static void main(String[] args) {
        String text = "To be or not to be, that is the question;"
            + "Whether this nobler in the mind to suffer"
            + " the slings and arrows of outrageous fortune,"
            + " or to take arms against a sea of troubles,"
            + " and by opposing end them?";
        int spaces = 0, vowels = 0, letters = 0;
        //YOUR CODE HERE
        System.out.println("The text contained\nvowels: " +
            vowels + "\ncharacters: " + characters + "\nspaces: " + spaces);
    }
}
*/

public class AP4 {
    static boolean isVowels(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    } 

    public static void main(String[] args) {
        String text = "To be or not to be, that is the question;"
            + "Whether this nobler in the mind to suffer"
            + " the slings and arrows of outrageous fortune,"
            + " or to take arms against a sea of troubles,"
            + " and by opposing end them?";
            
        int spaces = 0, vowels = 0, characters = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') spaces += 1;
            else if (isVowels(Character.toLowerCase(c))) vowels += 1;
            else characters += 1;
        }
    
        System.out.println("The text contained\nvowels: " +
            vowels + "\ncharacters: " + characters + "\nspaces: " + spaces);
    }
}
