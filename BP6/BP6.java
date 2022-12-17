// Problem Statement

// Develop a command line driven code to accept the following city names as 
// an argument in the command line and sort them in alphabetic order
// – City Name = Kolkata, Chennai, Mumbai, Delhi, Bangalore, Ahmedabad.

import java.util.Arrays;

public class BP6 {
    public static void main(String[] args) {
        Arrays.sort(args);

        System.out.println("Sorted by name: " + Arrays.toString(args));
    }
}