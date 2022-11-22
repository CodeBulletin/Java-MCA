package AP1;
import java.util.Scanner;

// Problem Statement
// Explore the basic java program development scenario in Notepad and cmd by 
// creating an Integer Adder. The adder prints sum of 5 integer numbers 
// without using single variable where input will be taken through command 
// line arguments.

// a) Perform the above code using a function and call it in main().
// b) Make another class and a function in it to perform the above task.

public class AP1 {
    public static void main(String[] args) {
        System.out.print("Sum of arguments: ");
        System.out.println(
            Integer.parseInt(args[0]) +
            Integer.parseInt(args[1]) + 
            Integer.parseInt(args[2]) + 
            Integer.parseInt(args[3]) + 
            Integer.parseInt(args[4]));
        // Doing the same thing in a class
        System.out.println(AddInput.addInput(args));
    }
}

class AddInput {
    public static int addInput(String[] args) {
        System.out.print("Sum of arguments in class: ");
        return Integer.parseInt(args[0]) + 
            Integer.parseInt(args[1]) + 
            Integer.parseInt(args[2]) + 
            Integer.parseInt(args[3]) + 
            Integer.parseInt(args[4]);
    }
}
