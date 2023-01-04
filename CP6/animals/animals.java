package animals;

public interface animals {
    void eat();
    void travel();

    public static class Cat implements animals {
        @Override
        public void eat() {
            System.out.println("Eating cat food");
        }
        
        @Override
        public void travel() {
            System.out.println("Running away from the dog");
        }
    }
    
    public static class Dog implements animals {
        @Override
        public void eat() {
            System.out.println("Eating dog food");
        }
        
        @Override
        public void travel() {
            System.out.println("Chasing the cat");
        }
    }
}
