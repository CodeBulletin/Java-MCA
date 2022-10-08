package AP6;

// Problem Statement
/*

*/

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

public class AP6 {
    public static void main(String[] args) {
        Box b1 = new Box(1.0f, 2.0f, 3.0f);
        Box b2 = new Box(2.0f, 4.0f, 6.0f);

        System.out.println(b1);
        System.out.println(b2);
    }
}
