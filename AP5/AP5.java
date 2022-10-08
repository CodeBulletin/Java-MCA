package AP5;

import java.util.Scanner;

// Problem Statement

/*
Construct a number generator to accept three digits (i.e. 0 - 9) and print all its 
possible combinations. (For example if the three digits are 1, 2, 3 than all 
possible combinations are: 123, 132,213, 231, 312, 321.)
*/

public class AP5 {

    static int i1, i2, i3;

    static boolean ParseInput(Scanner scanner) {
        i1 = scanner.nextInt();
        i2 = scanner.nextInt();
        i3 = scanner.nextInt();

        if (!(i1 >= 0 && i1 <= 9 && i2 >= 0 && i2 <= 9 && i3 >= 0 && i3 <= 9)) return false;
        return true;
    }

    static void printarr(int[] array) {
        for(int i : array) {
            System.out.print(i);
        }
        System.out.print("\n");
    }

    static void perms(int[] array, int size) {
        if (size == 1) {
            printarr(array);
            return;
        }

        for (int i = 0; i < size; i++) {
            perms(array, size - 1);
            if (size % 2 == 1) {
                int temp = array[0];
                array[0] = array[size - 1];
                array[size - 1] = temp;
            } else {
                int temp = array[i];
                array[i] = array[size - 1];
                array[size - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the three digits sperated by space: ");
        boolean isCorrect = ParseInput(scanner);
        scanner.close();

        if (!isCorrect) {
            System.out.println("Wrong Input");
            return;
        }

        int[] array = new int[] {i1, i2, i3};

        perms(array, array.length);
    }
}
