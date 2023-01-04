import java.util.Scanner;

public class DP1 {
    public static void main(String[] args) {
        double g = 9.81;

        Gravity earth = (double h, double r) -> {
            if (h + r == 0) {
                throw new ArithmeticException("Divide by zero");
            }
            return g * r * r / ((h + r) * (h + r));
        };
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the height: ");
            double height = sc.nextDouble();
            System.out.print("Enter the radius: ");
            double radius = sc.nextDouble();
            System.out.printf(
                "gravity at height h = %fs is %fm/s^2\n",
                height, earth.at(height, radius)
            );
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Exception:" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

@FunctionalInterface
interface Gravity {
    public double at(double a, double b)
        throws ArithmeticException;
}