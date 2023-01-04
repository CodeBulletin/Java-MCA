import java.util.InputMismatchException;
import java.util.Scanner;

public class DP4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Try block to handle InputMismatchException
        try {
            take_input(sc);
        } catch (InputMismatchException e) {
            // Catch block to handle InputMismatchException
            System.out.println(
                "InputMismatchException occurred: " + e.getMessage()
            );
        } finally {
            sc.close();
        }
    }

    static void take_input(Scanner sc) throws InputMismatchException {
        int number = 0;
        System.out.print("Enter a number between 1 and 10: ");
        number = sc.nextInt();
        if (number < 1 || number > 10) {
            throw new InputMismatchException(
                "Number is not within the range of 1 and 10"
            );
        }
        System.out.println("You entered: " + number);
    }
}