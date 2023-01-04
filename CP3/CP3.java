// Problem statement

// A java based program which prompts user for the number of students in a class
// (a non-negative integer), and saves it in int variable called numStudents.
// It then prompts user for the grade of each of the students
// (integer between 0 to 100) and saves them in an int array called grades.
// The program shall then compute and print the average
// (in double rounded to 2 decimal places) and minimum/maximum(in int). 

import java.text.DecimalFormat;
import java.util.Scanner;

public class CP3 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        if(numStudents <= 0) {
            sc.close();
            throw new IllegalArgumentException(
                "Number of students must be greater than zero"
            );
        }
        int[] numGrade = new int[numStudents];
        System.out.print("Enter the grades (0, 100): ");
        int i = 0;
        sc.nextLine();
        String grades = sc.nextLine();
        Scanner parser = new Scanner(grades);
        while(parser.hasNextInt() && i < numStudents) {
            numGrade[i] = parser.nextInt();
            if(numGrade[i] < 0 || numGrade[i] > 100) {
                sc.close();
                parser.close();
                throw new IllegalArgumentException(
                    "Grade must be between 0 and 100"
                );
            }
            i++;
        }
        parser.close();
        sc.close();
        int max = numGrade[0];
        int min = numGrade[0];
        double sum = numGrade[0];
        for(i = 1; i < numStudents; i++) {
            max = Math.max(max, numGrade[i]);
            min = Math.min(min, numGrade[i]);
            sum += numGrade[i];
        }
        DecimalFormat df = new DecimalFormat("##.00");
        System.out.println(
            "Average: " + df.format(sum / numStudents) + "\n" +
            "Maximum: " + max + "\n" +
            "Minimum: " + min
        );
    }
}