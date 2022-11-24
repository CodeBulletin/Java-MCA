package AA1;

// Problem Statement

// A Gravity Calculator in java to compute the position of an object after falling for 10 seconds, outputting the position in meters. The formula in Math notation is:
// x(t) = 0.5 × at 2 + vit + xi

// Variable	 meaning                    value	
// a         Acceleration (m/s 2)       -9.81
// t         Time (s)                   10
// vi        Initial velocity (m/s)     0
// xi        Initial position           0


public class AA1 {
    public static void main(String[] args) {
        double a = 9.81;
        double v = 0;
        double x = 0;

        Gravity earth = (double t) -> {
            return 0.5 * a * t * t + v * t + x;
        };
        
        double t = 10.0;

        System.out.printf("Position of ball after time t = %fs is %fm\n", t, earth.at(t));
    }
}

@FunctionalInterface
interface Gravity {
    public double at(double t);
}