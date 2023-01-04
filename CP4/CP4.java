// Problem Statement

/*
Demonstrate the working of a Static Inner Class through a class Electronics and
within it create Static Inner Class Television that has a method cost()
which displays cost of television object passed in constructor of Television class.
Demonstrate invoking inner class method with outer object when the method cost() is once a :-
    a) Instance (Non static) method
    b) Static method
*/

public class CP4 {
    public static void main(String[] args) {
        Electronics.Television t = new Electronics.Television(5);
        t.cost();
        Electronics.Television.cost(t);
    }
}

class Electronics {
    static class Television {
        private int cost = 0;
        Television(int cost) {
            this.cost = cost;
        }

        void cost() {
            System.out.println("cost(instance): " + cost);
        }

        static void cost(Television t) {
            System.out.println("cost(static): " + t.cost);
        }
    }
}