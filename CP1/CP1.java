// Problem Statement
// Design a class called DecipherCaesarCode to decipher the Caesar's code.
// The program shall prompts user for a ciphertext string consisting of mix-case letters only;
// compute the plaintext; and print the plaintext in uppercase.
// Design the solution with appropriate methods?

public class CP1 {
    public static void main(String[] args) {
        String Encoded = 
            DecipherCaesarCode.Encode("HELLOWORLD", 3);
        System.out.println("Encoded String: " +
            Encoded);
        System.out.println("Decoded String: " +
            DecipherCaesarCode.Decode(Encoded, 3));
    }
}

class DecipherCaesarCode {
    public static String Encode(String str, int n)
        throws IllegalArgumentException {
        String encoded = "";
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                int c = (str.charAt(i) - 'A' + n) % 26;
                encoded += (char) (c + 'A');
            }
            else throw 
                new IllegalArgumentException("Char range A-Z got: " +
                    str.charAt(i));
        }
        return encoded;
    } 

    public static String Decode(String str, int n) 
        throws IllegalArgumentException {
        String decoded = "";
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                int c = (str.charAt(i) - 'A' - n) % 26;
                decoded += (char) (c + 'A');
            }
            else throw 
                new IllegalArgumentException("Char range A-Z got: " +
                    str.charAt(i));
        }
        return decoded;
    } 
}