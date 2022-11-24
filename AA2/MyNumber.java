import java.util.Scanner;

// Problem Statement

// A java application "MyNumber.java" that performs following operations on a variable 'num' of type double. Code to include the following functionality:
// Finds the round value of 'num' and stores the result in a variable numRound of type double.
// Finds the ceil value of 'num' and stores the result in a variable numCeil of type double.
// Finds the floor value of 'num' and stores the result in a variable numFloor of type double
// Cast 'num' to type int and stores the result in a variable numInteger of type int.

public class MyNumber {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();

        double numRound = Math.round(num);
        double numCeil = Math.ceil(num);
        double numFloor = Math.floor(num);
        int numInteger = (int) num;

        System.out.println("Round of a number: " +
            numRound);
        
        System.out.println("Ceil of a number: " + 
            numCeil);

        System.out.println("Floor of a number: " +
            numFloor);

        System.out.println("numInteger: " + numInteger);

        sc.close();
    }
}