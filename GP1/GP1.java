public class GP1 {
    public static void main(String[] args) {
        Fruit sourMango = new Fruit() {
            @Override
            public String mango() {
                return "sour";
            }
        };

        Fruit sweetMango = new Fruit();

        System.out.println(sourMango.mango()); // prints "sour"
        System.out.println(sweetMango.mango()); // prints "sweet"
    }
}

class Fruit {
    public String mango() {
        return "sweet";
    }
}