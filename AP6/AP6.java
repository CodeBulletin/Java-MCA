package AP6;

// Problem Statement
/*
A java standalone application makes use of a parameterized method inside a 
class. Take the following case: Create a class Box and define a method in this 
class which will return the volume of the box. Initialize two objects for your 
class and print out the volumes respectively.
*/

public class AP6 {
    public static void main(String[] args) {
        Box b1 = new Box(1.0f, 2.0f, 3.0f);
        Box b2 = new Box(2.0f, 4.0f, 6.0f);

        System.out.println(b1);
        System.out.println(b2);
    }
}


class Box {
    public float l = 0.0f, b = 0.0f, h = 0.0f;

    public Box(float lenght, float breadth, float height) {
        this.l = lenght;
        this.b = breadth;
        this.h = height;
    }

    public float volume() {
        return this.l * this.b * this.h;
    }

    public String toString() {
        return String.format("Volume of Box(l: %f, b: %f, h: %f) = %f", l, b, h, volume());
    }
}