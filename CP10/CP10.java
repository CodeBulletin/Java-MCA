public class CP10 {
    public static void main(String[] args) {
        Geometry.run();
    }
}

interface GeoAnalyzer {
    double PI = 3.14159265358979323846;
    double area();
    double perimeter();
}

class Circle implements GeoAnalyzer {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }
}

class Ellipse implements GeoAnalyzer {
    private double semiMajorAxis;
    private double semiMinorAxis;

    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    @Override
    public double area() {
        return PI * semiMajorAxis * semiMinorAxis;
    }

    @Override
    public double perimeter() {
        // This is a rough approximation of the ellipse perimeter using Ramanujan's formula
        double a = semiMajorAxis;
        double b = semiMinorAxis;
        return PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}

class Rectangle implements GeoAnalyzer {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

class Geometry {
    public static void run() {
        GeoAnalyzer circle = new Circle(5);
        System.out.println("Area of circle: " + circle.area());
        System.out.println("Perimeter of circle: " + circle.perimeter());

        GeoAnalyzer ellipse = new Ellipse(5, 3);
        System.out.println("Area of ellipse: " + ellipse.area());
        System.out.println("Perimeter of ellipse: " + ellipse.perimeter());

        GeoAnalyzer rectangle = new Rectangle(5, 7);
        System.out.println("Area of rectangle: " + rectangle.area());
        System.out.println("Perimeter of rectangle: " + rectangle.perimeter());
    }
}