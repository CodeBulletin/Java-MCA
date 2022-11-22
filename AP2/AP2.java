package AP2;

import java.util.Scanner;

// Problem Statement
// Develop a Number Reciprocator java application to computes the sum of the 
// reciprocals without using a single variable in the format:
// 1/1 + 1/2 + 1/3 + ... + 1/10

public class AP2 {
    static float count_resiprocal(int curr) {
        if (curr == 1) return 1.0f;
        return 1.0f/curr + count_resiprocal(curr - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        System.out.println(count_resiprocal(scanner.nextInt()));
        scanner.close();
    } 
}