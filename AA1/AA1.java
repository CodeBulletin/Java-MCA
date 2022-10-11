package AA1;

@FunctionalInterface
interface Gravity {
    public double at(double t);
}

public class AA1 {

    public static void main(String[] args) {
        double a = 9.81;
        double v = 0;
        double x = 0;

        Gravity earth = (double t) -> {
            return 0.5 * a * t * t + v * t + x;
        };
        
        double t = 2.0;

        System.out.printf("Position of ball after time t = %fs is %fm\n", t, earth.at(t));
    }
}
