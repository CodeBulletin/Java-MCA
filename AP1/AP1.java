import java.util.Scanner;

// Problem Statement
// Explore the basic java program development scenario in Notepad and cmd by 
// creating an Integer Adder. The adder prints sum of 5 integer numbers 
// without using single variable where input will be taken through command 
// line arguments.

// a) Perform the above code using a function and call it in main().
// b) Make another class and a function in it to perform the above task.

class AddInput {
    public static int addInput(Scanner scanner) {
        System.out.println("Enter the 5 nums");
        return scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
    }
}

public class AP1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the 5 nums");
        System.out.println(scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt());

        // Doing the same thing in a class
        System.out.println(AddInput.addInput(scanner));

        scanner.close();
    }
}
