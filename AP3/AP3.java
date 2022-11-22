package AP3;

// Problem Statement
/*
Demonstrate type conversion in a simple java program by casting and 
checking output in the following cases:-
    a) Conversion of int to byte
    b) Conversion of double to int
    c) Conversion of double to byte
    d) Conversion of int to char
    e) Conversion of float to short
*/

public class AP3 {
    public static void main(String[] args) {
        int int_to_byte = 1000;
        System.out.println("1000 in byte: " + (byte) int_to_byte);

        double double_to_int = 12.93e3 + 0.5;
        System.out.println("12.93e3 + 0.5 in int: " + (int) double_to_int);

        double double_to_byte = 1.15;
        System.out.println("1.15 in byte: " + (byte) double_to_byte);

        int int_to_char = 88;
        System.out.println("88 in character: " + (char) int_to_char);

        float float_to_short = 1.175f;
        System.out.println("1.175 in short: " + (short) float_to_short);
    }
}
