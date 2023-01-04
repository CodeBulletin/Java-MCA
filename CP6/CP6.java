import animals.animals;

public class CP6 {
    public static void main(String[] args) {
        animals.Dog d = new animals.Dog();
        animals.Cat c = new animals.Cat();

        d.eat();
        d.travel();

        c.eat();
        c.travel();
    }
}