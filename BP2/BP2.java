// Problem Statement
//Create a class named DuplicateFinder which initializes an array of at least 15 elements.
//Define appropriate methods to print its elements and calculate duplicate elements if any.
//It should detail the number of duplicates along with their frequency of occurrence.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BP2 {
    public static int random(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        DuplicateFinder finder = new DuplicateFinder(size);

        for(int i = 0; i < size; i++) {
            finder.set(i, random(0, 10));
        }

        System.out.println("Array: " + finder);

        finder.printDuplicates();

        scanner.close();
    }
}

class DuplicateFinder {
    private int size;
    ArrayList<Integer> array;

    DuplicateFinder(int size) throws IllegalArgumentException {
        if (size < 15) throw new IllegalArgumentException("size must be at least 15");
        array = new ArrayList<Integer>(Collections.nCopies(size, null));
        this.size = size;
        System.out.println(array.size());
    }

    public void set(int index, Integer value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index must be between 0 and " + size);
        array.set(index, value);
    }

    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index must be between 0 and " + size);
        return array.get(index);
    }

    public final int getSize() {
        return size;
    }

    public String toString() {
        return array.toString();
    }

    public final void printDuplicates() {
        Collections.sort(array);

        int start = array.get(0);
        int duplicates = 0;
        for(int i = 1; i < size; i++) {
            if(start == array.get(i)) {
                duplicates++;
                System.out.println("Found duplicate: " + start);
            }
            else start = array.get(i);
        }
        System.out.println("Duplicate Frequency: " + duplicates);
    }
}